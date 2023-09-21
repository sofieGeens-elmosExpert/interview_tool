package be.elmos.interview_tool_spring.controller;

import be.elmos.interview_tool_spring.dto.*;
import be.elmos.interview_tool_spring.model.Answer;
import be.elmos.interview_tool_spring.model.Question;
import be.elmos.interview_tool_spring.model.enums.AnswerType;
import be.elmos.interview_tool_spring.model.enums.Category;
import be.elmos.interview_tool_spring.model.enums.PersonType;
import be.elmos.interview_tool_spring.model.enums.QuestionType;
import be.elmos.interview_tool_spring.model.persistence.AnswerRepository;
import be.elmos.interview_tool_spring.model.persistence.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping
    public String getAllQuestions(Model model) {
        //Only get active Candidates (soft delete)
        Iterable<Question> questions = questionRepository.findAllByActive(true);
        List<SelectQuestionDto> questionDtos = new ArrayList<>();
        questions.forEach(q -> questionDtos.add(convertToSelectQuestionDTO(q)));
        model.addAttribute("questions", questionDtos);
        return "questions";
    }

    @GetMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable(value = "id") long id) {
        Question question = questionRepository.findById(id);
        question.setActive(false);
        questionRepository.save(question);
        List<Answer> answers= answerRepository.findAllByQuestion(question);
        for( Answer a : answers){
            a.setActive(false);
            answerRepository.save(a);
        }
        return "redirect:/questions";
    }

    @GetMapping("/edit/{id}")
    public String editQuestion(@PathVariable(value = "id") long id, Model model) {
        Question question = questionRepository.findById(id);
        System.out.println("hier" + question);
        UpdateQuestionDto qDto = convertToUpdateQuestionDTO(question);
        List<Answer> answers = answerRepository.findAllByQuestion(question);
        List<UpdateAnswerDto> aDtos = new ArrayList<>();
        answers.forEach(a -> aDtos.add(convertToUpdateAnswerDTO(a)));
        model.addAttribute("q",qDto);
        model.addAttribute("answers",aDtos);
        model.addAttribute("id",id);
        System.out.println(qDto);
        return "update-question";
    }

    @PostMapping("/update/{id}")
    public String updateQuestion(@PathVariable(value = "id") long id, BindingResult result, UpdateQuestionDto question, List<UpdateAnswerDto> answers) {
        if(result.hasErrors()){
            return "update-candidate";
        }
        Question q = convertToQuestionEntity(id,question);
        questionRepository.save(q);
        for(UpdateAnswerDto answer: answers){
            Answer a = convertToAnswerEntity(q,answer);
            answerRepository.save(a);
        }
        return "redirect:/questions";
    }

    @GetMapping("/new")
    public String newQuestion(Model model){
        UpdateQuestionDto dto = new UpdateQuestionDto();
        model.addAttribute("question",dto);
        return "new-question";
    }

    @PostMapping("/add")
    public String addQuestion(UpdateQuestionDto questionDto,BindingResult result) {
        if(result.hasErrors()){
            return "new-question";
        }
        Question q = convertToQuestionEntity(questionDto);
        questionRepository.save(q);
        return "redirect:/questions";
    }

    public SelectQuestionDto convertToSelectQuestionDTO(Question question) {
        String role = setRole(question.getRole());
        String category = setCategory(question.getCategory());
        String questionType = setQuestionType(question.getQuestionType());
        String answerType = setAnswerType(question.getAnswerType());
        return new SelectQuestionDto(question.getId(),role,category,questionType,answerType,question.getQuestion());
    }

    public UpdateQuestionDto convertToUpdateQuestionDTO(Question question) {
        String role = setRole(question.getRole());
        String category = setCategory(question.getCategory());
        String questionType = setQuestionType(question.getQuestionType());
        String answerType = setAnswerType(question.getAnswerType());
        return new UpdateQuestionDto(role,category,questionType,answerType,question.getQuestion());
    }

    public Question convertToQuestionEntity(long id, UpdateQuestionDto dto) {
        Question q = questionRepository.findById(id);
        return setQuestion(q,dto);
    }

    public Question convertToQuestionEntity(UpdateQuestionDto dto) {
        Question q = new Question();
        return setQuestion(q,dto);
    }

    public UpdateAnswerDto convertToUpdateAnswerDTO(Answer answer){
        return new UpdateAnswerDto(answer.getAnswer());
    }

    public Answer convertToAnswerEntity(Question q,UpdateAnswerDto dto){
        return new Answer(q,dto.getAnswer());
    }

    public Question setQuestion(Question q,UpdateQuestionDto dto){
        q.setQuestion(dto.getQuestion());
        q.setQuestionType(dto.getQuestionType());
        q.setRole(dto.getRole());
        q.setAnswerType(dto.getAnswerType());
        q.setCategory(dto.getCategory());
        q.setLanguage(dto.getLanguage());
        return q;
    }

    private String setRole(PersonType role) {
        String parameter = "";
        switch (role) {
            case JUNIOR -> parameter = "junior";
            case MEDIOR -> parameter = "medior";
            case SENIOR -> parameter = "senior";
            default -> parameter = "";
        }
        return parameter;
    }

    private String setQuestionType(QuestionType questionType) {
        String parameter = "";
        switch (questionType) {
            case START -> parameter = "start";
            case MIDDLE -> parameter = "middle";
            case END -> parameter = "end";
            default -> parameter = "not specified";
        }
        return parameter;
    }

    private String setCategory(Category category) {
        String parameter = "";
        switch (category) {
            case TECHNICAL -> parameter = "technical";
            case RECRUITING -> parameter = "recruiting";
            default -> parameter = "not specified";
        }
        return parameter;
    }

    private String setAnswerType(AnswerType answerType) {
        String parameter = "";
        switch (answerType) {
            case BOOL -> parameter = "true/false";
            case SCALE -> parameter = "scale";
            case OPEN -> parameter = "open";
            default -> parameter = "not specified";
        }
        return parameter;
    }
}

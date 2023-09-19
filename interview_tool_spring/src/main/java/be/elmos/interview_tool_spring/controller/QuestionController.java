package be.elmos.interview_tool_spring.controller;

import be.elmos.interview_tool_spring.dto.*;
import be.elmos.interview_tool_spring.model.Answer;
import be.elmos.interview_tool_spring.model.Question;
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
        Iterable<Question> questions = questionRepository.findByActive(true);
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
        UpdateQuestionDto qDto = convertToUpdateQuestionDTO(question);
        List<Answer> answers = answerRepository.findAllByQuestion(question);
        List<UpdateAnswerDto> aDtos = new ArrayList<>();
        answers.forEach(a -> aDtos.add(convertToUpdateAnswerDTO(a)));
        model.addAttribute("question",qDto);
        model.addAttribute("answers",aDtos);
        return "redirect:/update-question";
    }

    @PostMapping("/update/{id}")
    public String updateQuestion(@PathVariable(value = "id") long id, BindingResult result, UpdateQuestionDto question) {
        if(result.hasErrors()){
            return "update-candidate";
        }
        Question q = convertToQuestionEntity(id,question);
        questionRepository.save(q);
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
        return new SelectQuestionDto(question.getId(),question.getRole(),question.getCategory(),question.getQuestionType(),question.getAnswerType(),question.getQuestion());
    }

    public UpdateQuestionDto convertToUpdateQuestionDTO(Question question) {
        return new UpdateQuestionDto(question.getRole(),question.getCategory(),question.getQuestionType(),question.getAnswerType(),question.getQuestion());
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

    public Question setQuestion(Question q,UpdateQuestionDto dto){
        q.setQuestion(dto.getQuestion());
        q.setQuestionType(dto.getQuestionType());
        q.setRole(dto.getRole());
        q.setAnswerType(dto.getAnswerType());
        q.setCategory(dto.getCategory());
        return q;
    }
}

package be.elmos.interview_tool_spring.controller;

import be.elmos.interview_tool_spring.dto.*;
import be.elmos.interview_tool_spring.model.Answer;
import be.elmos.interview_tool_spring.model.Candidate;
import be.elmos.interview_tool_spring.model.Question;
import be.elmos.interview_tool_spring.model.persistence.CandidateRepository;
import be.elmos.interview_tool_spring.model.persistence.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping
    public String getAllCandidates(Model model) {
        //todo add answers to questions.html
        //todo get answers with same id
        //Only get active Candidates (soft delete)
        Iterable<Question> questions = questionRepository.findByActive(true);
        List<SelectQuestionDto> candidateDtos = new ArrayList<>();
        questions.forEach(p -> candidateDtos.add(convertToSelectDTO(p)));
        model.addAttribute("questions", questions);
        return "questions";
    }

    public SelectQuestionDto convertToSelectDTO(Question question){
        return new SelectQuestionDto(question.getRole(),question.getCategory(),question.getQuestionType(),question.getAnswerType(),question.getQuestion());
    }

    public SelectQuestionDto convertToSelectDTO(Question question, long id){
        SelectQuestionDto dto = new SelectQuestionDto(question.getRole(),question.getCategory(),question.getQuestionType(),question.getAnswerType(),question.getQuestion());
        dto.setId(id);
        return dto;
    }

    public SelectAnswerDto covertToAnswerDTO(Answer answer){
        return new SelectAnswerDto(answer.getAnswer());
    }

    public SelectAnswerDto covertToAnswerDTO(Answer answer, long id){
        SelectAnswerDto dto = new SelectAnswerDto(answer.getAnswer());
        dto.setId(id);
        return dto;
    }
}

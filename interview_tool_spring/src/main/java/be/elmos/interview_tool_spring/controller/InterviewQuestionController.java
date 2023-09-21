package be.elmos.interview_tool_spring.controller;

import be.elmos.interview_tool_spring.model.persistence.InterviewQuestionRepository;
import be.elmos.interview_tool_spring.model.persistence.InterviewRepository;
import be.elmos.interview_tool_spring.model.persistence.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/interviewQuestions")
public class InterviewQuestionController {
    private final InterviewQuestionRepository interviewQuestionRepository;

    @Autowired
    private InterviewRepository interviewRepository;
    @Autowired
    private QuestionRepository questionRepository;

    public InterviewQuestionController(InterviewQuestionRepository interviewQuestionRepository) {
        this.interviewQuestionRepository = interviewQuestionRepository;
    }
}

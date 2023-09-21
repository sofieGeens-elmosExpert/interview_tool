package be.elmos.interview_tool_spring.controller;

import be.elmos.interview_tool_spring.dto.UpdateAnswerDto;
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

@Controller
@RequestMapping("answers")
public class AnswerController {

    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/delete/{id}")
    public String deleteAnswer(@PathVariable(name = "id") long id) {
        Answer a = answerRepository.findById(id);
        a.setActive(false);
        return "redirect:/update-question";
    }

    @GetMapping("/new")
    public String newAnswer(Model model){
        Answer a = new Answer();
        model.addAttribute("answer",a);
        return "new-answer";
    }

    @PostMapping("/add/{questionId}")
    public String addAnswer(@PathVariable(name = "questionId") long qId, BindingResult result, UpdateAnswerDto dto){
        if(result.hasErrors()){
            return "update-candidate";
        }
        Answer a = convertToEntity(qId,dto);
        answerRepository.save(a);
        return "redirect:/update-question";
    }

    public Answer convertToEntity(long qId,UpdateAnswerDto dto){
        Answer a = new Answer();
        a.setAnswer(dto.getAnswer());
        Question q = questionRepository.findById(qId);
        a.setQuestion(q);
        return a;
    }
}

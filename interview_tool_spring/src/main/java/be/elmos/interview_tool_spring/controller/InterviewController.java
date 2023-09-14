package be.elmos.interview_tool_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/interview")
public class InterviewController {

    @GetMapping("/start")
    public String startInterview(){
        //TODO: get list of candidates
        //TODO: display list of candidates in new-interview.html
        return "new-interview";
    }

    @PostMapping("/start")
    public String candidateChosen(){
        return "interview;";
    }
}

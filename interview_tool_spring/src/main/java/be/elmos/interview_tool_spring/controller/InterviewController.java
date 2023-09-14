package be.elmos.interview_tool_spring.controller;

import be.elmos.interview_tool_spring.dto.CandidateDto;
import be.elmos.interview_tool_spring.model.Candidate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/interview")
public class InterviewController {

    @GetMapping("/start")
    public String startInterview(CandidateDto candidateDto){
        List<Candidate> candidates = candidateDto.getAllCandidates();
        //TODO: display list of candidates in new-interview.html
        return "new-interview";
    }

    @PostMapping("/start")
    public String candidateChosen(){
        return "interview;";
    }
}

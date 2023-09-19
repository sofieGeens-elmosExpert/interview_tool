package be.elmos.interview_tool_spring.controller;

import be.elmos.interview_tool_spring.dto.SelectCandidateDto;
import be.elmos.interview_tool_spring.model.Candidate;
import be.elmos.interview_tool_spring.model.persistence.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/interview")
public class InterviewController {

    @Autowired
    private CandidateRepository candidateRepository;

    @GetMapping("/start")
    public String startInterview(Model model){
        Iterable<Candidate> candidates = candidateRepository.findByActive(true);
        List<SelectCandidateDto> candidateDtos = new ArrayList<>();
        candidates.forEach(c -> candidateDtos.add(convertToSelectCandidateDTO(c)));
        model.addAttribute("candidates", candidates);
        return "new-interview";
    }

    @PostMapping("/start-interview")
    public String candidateChosen(Model model, SelectCandidateDto candidate){
        model.addAttribute("candidate",candidate);
        return "interview;";
    }

    public SelectCandidateDto convertToSelectCandidateDTO(Candidate candidate) {
        return new SelectCandidateDto(candidate.getLastName(),candidate.getFirstName(),candidate.getEmail(),candidate.getId(),candidate.getRole());
    }
}

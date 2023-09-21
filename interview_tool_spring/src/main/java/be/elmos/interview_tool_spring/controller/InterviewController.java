package be.elmos.interview_tool_spring.controller;

import be.elmos.interview_tool_spring.dto.SelectCandidateDto;
import be.elmos.interview_tool_spring.model.Candidate;
import be.elmos.interview_tool_spring.model.enums.PersonType;
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
@RequestMapping("/interview")// interviews ?
public class InterviewController {

    @Autowired
    private CandidateRepository candidateRepository;

    @GetMapping("/start")
    public String startInterview(Model model) {
        Iterable<Candidate> candidates = candidateRepository.findAllByActive(true);
        List<SelectCandidateDto> candidateDtos = new ArrayList<>();
        candidates.forEach(c -> candidateDtos.add(convertToSelectCandidateDTO(c)));
        model.addAttribute("candidates", candidates);
        return "new-interview";
    }

    @PostMapping("/start-interview")
    public String candidateChosen(Model model, SelectCandidateDto candidate) {
        model.addAttribute("candidate", candidate);
        return "interview";
    }

    public SelectCandidateDto convertToSelectCandidateDTO(Candidate candidate) {
        String role = setRole(candidate.getRole());
        return new SelectCandidateDto(candidate.getLastName(),candidate.getFirstName(),candidate.getEmail(),candidate.getId(),role);
    }

    // TODO get edit, post update, get delete, convert to entity
    public String setRole(PersonType r) {
        String  par = "";
        switch (r) {
            case SENIOR -> par = "senior";
            case MEDIOR -> par = "medior";
            case JUNIOR -> par = "junior";
            default -> par = "not specified";
        }
        return par;
    }
}

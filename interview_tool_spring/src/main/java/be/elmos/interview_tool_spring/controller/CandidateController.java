package be.elmos.interview_tool_spring.controller;

import be.elmos.interview_tool_spring.dto.SelectCandidateDto;
import be.elmos.interview_tool_spring.dto.UpdateCandidateDto;
import be.elmos.interview_tool_spring.model.Candidate;
import be.elmos.interview_tool_spring.model.persistence.CandidateRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;

    @GetMapping
    public String getAllCandidates(Model model) {
        //Only get active Candidates (soft delete)
        Iterable<Candidate> candidates = candidateRepository.findByActive(true);
        List<SelectCandidateDto> candidateDtos = new ArrayList<>();
        candidates.forEach(p -> candidateDtos.add(convertToSelectDTO(p)));
        model.addAttribute("candidates", candidates);
        return "candidates";
    }

    @GetMapping("/{id}")
    public String getCandidate(@PathVariable(value = "id") int id, Model model) {
        Candidate candidate = candidateRepository.findById(id);
        SelectCandidateDto candidateDto = convertToSelectDTO(candidate);
        model.addAttribute("candidate", candidateDto);
        return "single-candidate";
    }

    //soft delete
    @GetMapping("/delete/{id}")
    public String deleteCandidate(@PathVariable(value = "id") int id, Model model){
        Candidate candidate = candidateRepository.findById(id);
        candidate.setActive(false);
        candidateRepository.save(candidate);

        return "redirect:/candidates";
    }

    //redirects to a page where information can be changed
    @GetMapping("/edit/{id}")
    public String editCandidate(@PathVariable(value = "id") int id, Model model){
        Candidate candidate = candidateRepository.findById(id);
        UpdateCandidateDto dto = convertToUpdatDTO(candidate);
        model.addAttribute("candidate",dto);

        return "update-candidate";
    }

    //updates the information and redirects to overview page
    @PostMapping("/update/{id}")
    public String updateCandidate(@PathVariable(value = "id") int id, UpdateCandidateDto candidate, Model model){
        //todo: update info in database
        return "redirect:/candidates";
    }

    public SelectCandidateDto convertToSelectDTO(Candidate candidate) {
        return new SelectCandidateDto(candidate.getLastName(),candidate.getFirstName(),candidate.getEmail(),candidate.getID(),candidate.getRole());
    }

    public UpdateCandidateDto convertToUpdatDTO(Candidate candidate){
        return new UpdateCandidateDto(candidate.getLastName(),candidate.getFirstName(),candidate.getEmail(),candidate.getRole());
    }
}


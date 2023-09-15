package be.elmos.interview_tool_spring.controller;

import be.elmos.interview_tool_spring.dto.SelectCandidateDto;
import be.elmos.interview_tool_spring.dto.UpdateCandidateDto;
import be.elmos.interview_tool_spring.model.Candidate;
import be.elmos.interview_tool_spring.model.enums.PersonType;
import be.elmos.interview_tool_spring.model.persistence.CandidateRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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
        UpdateCandidateDto dto = convertToUpdateDTO(candidate);
        model.addAttribute("cand",dto);

        return "update-candidate";
    }

    //updates the information and redirects to overview page
    @PostMapping("/update/{id}")
    public String updateCandidate(@PathVariable(value = "id") long id, UpdateCandidateDto candidate, BindingResult result, Model model){
        if(result.hasErrors()){
            return "update-candidate";
        }
        Candidate cand = convertToUpdateEntity(candidate, id);
        candidateRepository.save(cand);
        return "redirect:/candidates";
    }

    @GetMapping("/new")
    public String newCandidate(Model model){
        UpdateCandidateDto dto = new UpdateCandidateDto();
        model.addAttribute("candidate",dto);
        model.addAttribute("exists","");
        return "new-candidate";
    }

    @PostMapping("/add")
    public String addCandidate(@PathVariable(value = "id") long id, UpdateCandidateDto candidate, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("exists","");
            return "new-candidate";
        }
        if(exists(candidate)){
            model.addAttribute("exists","A candidate with this e-mail already exists");
            return "new-candidate";
        }
        Candidate cand = convertToUpdateEntity(candidate);
        candidateRepository.save(cand);
        return "redirect:/candidates";
    }

    public Boolean exists(UpdateCandidateDto dto){
        Candidate candidate = convertToUpdateEntity(dto);
        return candidateRepository.findByEmail(candidate.getEmail()) != null;
    }

    public SelectCandidateDto convertToSelectDTO(Candidate candidate) {
        return new SelectCandidateDto(candidate.getLastName(),candidate.getFirstName(),candidate.getEmail(),candidate.getId(),candidate.getRole());
    }

    public UpdateCandidateDto convertToUpdateDTO(Candidate candidate){
        return new UpdateCandidateDto(candidate.getLastName(),candidate.getFirstName(),candidate.getEmail(),candidate.getRole());
    }
    public Candidate convertToUpdateEntity(UpdateCandidateDto dto, long id){
        PersonType role;
        switch (dto.getRole()){
            case "junior":
                role = PersonType.JUNIOR;
                break;
            case "medior":
                role = PersonType.MEDIOR;
                break;
            case "senior":
                role = PersonType.SENIOR;
                break;
            default:
                role = PersonType.JUNIOR;
        }
        Candidate candidate = new Candidate(dto.getFirstname(),dto.getLastname(),dto.getEmail(),role);
        candidate.setId(id);
        return candidate;
    }

    public Candidate convertToUpdateEntity(UpdateCandidateDto dto){
        PersonType role;
        switch (dto.getRole()){
            case "junior":
                role = PersonType.JUNIOR;
                break;
            case "medior":
                role = PersonType.MEDIOR;
                break;
            case "senior":
                role = PersonType.SENIOR;
                break;
            default:
                role = PersonType.JUNIOR;
        }
        Candidate candidate = new Candidate(dto.getFirstname(),dto.getLastname(),dto.getEmail(),role);
        return candidate;
    }
}


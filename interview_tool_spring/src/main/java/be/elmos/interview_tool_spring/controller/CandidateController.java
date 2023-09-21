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
        Iterable<Candidate> candidates = candidateRepository.findAllByActive(true);
        List<SelectCandidateDto> candidateDtos = new ArrayList<>();
        System.out.println("\nCANDIDATES\n");
        candidates.forEach(p -> System.out.println(p));
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
    public String deleteCandidate(@PathVariable(value = "id") int id){
        Candidate candidate = candidateRepository.findById(id);
        candidate.setActive(false);
        candidateRepository.save(candidate);

        return "redirect:/candidates";
    }

    //redirects to a page where information can be changed
    @GetMapping("/edit/{id}")
    public String editCandidate(@PathVariable(value = "id") int id, Model model) {
        Candidate candidate = candidateRepository.findById(id);
        UpdateCandidateDto dto = convertToUpdateDTO(candidate);
        model.addAttribute("cand",dto);
        model.addAttribute("id", id);
//        model.addAttribute("junior", candidate.getRole() == PersonType.JUNIOR);
//        model.addAttribute("medior", candidate.getRole() == PersonType.MEDIOR);
//        model.addAttribute("senior", candidate.getRole() == PersonType.SENIOR);
        model.addAttribute("role", candidate.getRole());

        return "update-candidate";
    }

    //updates the information and redirects to overview page
    @PostMapping("/update/{id}")
    public String updateCandidate(@PathVariable(value = "id") long id, UpdateCandidateDto candidate, BindingResult result) {
        if (result.hasErrors()) {
            return "update-candidate";
        }
        System.out.println("UPDATE CANDIDATE " + candidate.toString()); //TODO wegdoen
        System.out.println("UPDATE CANDIDATE " + candidate.getRole()); //TODO wegdoen
        Candidate cand = convertToUpdateEntity(candidate, id);
        System.out.println("UPDATE CANDIDATE " + cand.toString()); //TODO wegdoen
        System.out.println("UPDATE CANDIDATE " + cand.getRole()); //TODO wegdoen
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
    public String addCandidate(UpdateCandidateDto candidate, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("exists","");
            return "new-candidate";
        }
        if (exists(candidate)) {
            model.addAttribute("exists","A candidate with this e-mail already exists");
            return "new-candidate";
        }
        System.out.println("\nCREATE CANDIDATE\n" + candidate.toString());
        Candidate cand = convertToUpdateEntity(candidate);
        candidateRepository.save(cand);
        //todo: redirect to dashboard when user is recruiter, redirect to candidates (overview page) when user is manager or admin
        return "redirect:/candidates";
    }

    public Boolean exists(UpdateCandidateDto dto){
        Candidate candidate = convertToUpdateEntity(dto);
        return candidateRepository.findByEmail(candidate.getEmail()) != null;
    }

    public SelectCandidateDto convertToSelectDTO(Candidate candidate) {
//        String role = setRole(candidate.getRole());
        return new SelectCandidateDto(candidate.getLastName(),candidate.getFirstName(),candidate.getEmail(),candidate.getId(),String.valueOf(candidate.getRole().getName()));
    }

    public UpdateCandidateDto convertToUpdateDTO(Candidate candidate) {
//        String role = setRole(candidate.getRole());
        return new UpdateCandidateDto(candidate.getLastName(),candidate.getFirstName(),candidate.getEmail(),String.valueOf(candidate.getRole().getName()));
    }

    public Candidate convertToUpdateEntity(UpdateCandidateDto dto, long id) {
        PersonType role = switch (dto.getRole()) {
            case "c" -> PersonType.MEDIOR;
            case "s" -> PersonType.SENIOR;
            default -> PersonType.JUNIOR;
        };
        Candidate candidate = new Candidate(dto.getFirstname(),dto.getLastname(),dto.getEmail(),String.valueOf(role.getName()));
        candidate.setId(id);
        return candidate;
    }

    public Candidate convertToUpdateEntity(UpdateCandidateDto dto) {
        PersonType role = switch (dto.getRole()) {
            case "c" -> PersonType.MEDIOR;
            case "s" -> PersonType.SENIOR;
            default -> PersonType.JUNIOR;
        };
        return new Candidate(dto.getFirstname(),dto.getLastname(),dto.getEmail(),String.valueOf(role.getName()));
    }

    public String setRole(String r) {
        String  par = "";
        switch (r) {
            case "s" -> par = "senior";
            case "m" -> par = "medior";
            case "j" -> par = "junior";
            default -> par = "not specified";
        }
        return par;
    }
}


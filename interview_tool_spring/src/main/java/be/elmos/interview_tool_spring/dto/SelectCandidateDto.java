package be.elmos.interview_tool_spring.dto;

import be.elmos.interview_tool_spring.model.Candidate;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

public class SelectCandidateDto {
    private String lastname;
    private String firstname;
    private String email;
    private String role;

    public SelectCandidateDto(String ln, String fn, String mail, String r) {
        lastname = ln;
        firstname = fn;
        email = mail;
        role = r;
    }
    //TODO: make getters and setters
}

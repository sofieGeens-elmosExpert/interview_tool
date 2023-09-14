package be.elmos.interview_tool_spring.dto;

import be.elmos.interview_tool_spring.model.Candidate;
import be.elmos.interview_tool_spring.model.Type;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class CandidateDto {
    private String lastname;
    private String firstname;
    private String email;
    private String role;


    public CandidateDto(String ln, String fn, String mail, Type r) {
        lastname = ln;
        firstname = fn;
        email = mail;
        if (r == Type.JUNIOR) {
            role = "junior";
        } else if (r == Type.MEDIOR) {
            role = "medior";
        } else if (r == Type.SENIOR) {
            role = "senior";
        } else {
            role = "unknown";
        }
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

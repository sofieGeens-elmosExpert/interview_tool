package be.elmos.interview_tool_spring.dto;

import be.elmos.interview_tool_spring.model.enums.PersonType;

public abstract class CandidateDto {
    private String lastname;
    private String firstname;
    private String email;
    private String role;

    public CandidateDto() {
    }

    public CandidateDto(String ln, String fn, String mail, PersonType r) {
        lastname = ln;
        firstname = fn;
        email = mail;
        if (r == PersonType.JUNIOR) {
            role = "junior";
        } else if (r == PersonType.MEDIOR) {
            role = "medior";
        } else if (r == PersonType.SENIOR) {
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

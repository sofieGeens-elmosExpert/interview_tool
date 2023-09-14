package be.elmos.interview_tool_spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "candidate")
public class Candidate extends Person {
    public Candidate(String firstName, String lastName, String email, String password, Type role) {
        super(firstName, lastName, email, password, role);
    }
}

package be.elmos.interview_tool_spring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "candidate")
public class Candidate extends Person {

    public Candidate() {
        super();
    }

    public Candidate(String firstName, String lastName, String email, Type role) {
        super(firstName, lastName, email, role);
    }



}

package be.elmos.interview_tool_spring.model;

import be.elmos.interview_tool_spring.model.enums.PersonType;
import jakarta.persistence.*;

@Entity
@Table(name = "candidate")
public class Candidate extends Person {

    public Candidate() {
        super();
    }

    public Candidate(String firstName, String lastName, String email, PersonType role) {
        super(firstName, lastName, email, role);
    }



}

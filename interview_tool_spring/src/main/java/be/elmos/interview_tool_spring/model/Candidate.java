package be.elmos.interview_tool_spring.model;

import be.elmos.interview_tool_spring.model.enums.PersonType;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "candidate")
public class Candidate extends Person implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    public Candidate() {
        super();
    }

    public Candidate(String firstName, String lastName, String email, PersonType role) {
        super(firstName, lastName, email, role);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int compareTo(Object person) {
        return (int) (this.getId() - ((Candidate)person).getId());
    }
}

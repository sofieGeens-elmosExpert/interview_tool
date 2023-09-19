package be.elmos.interview_tool_spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Entity
public class Interview implements Serializable {
    @Id
    private long id; // auto generate?
    // id?

    @Column(name = "person_id")
    private long personId;

    @Column(name = "candidate_id")
    private long candidateId;
    private Date day;
    private Time starttime;

    public Interview() {

    }
}

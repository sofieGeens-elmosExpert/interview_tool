package be.elmos.interview_tool_spring.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "interview")
public class Interview implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long id;

    @Column(name = "person_id")
    private long personId;

    @Column(name = "candidate_id")
    private long candidateId;
    @Column(name = "day")
    private Date day;
    @Column(name = "starttime")
    private Time starttime;


    @ManyToMany
    @JoinTable(
            name = "interview_has_questions",
            joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "question_id", referencedColumnName = "id") // TODO CHECK IF GOOD
    )
    private Set<Question> interview_questions;

    public Interview() {
    }

//    public Interview()

    public Set<Question> getInterview_questions() {
        return interview_questions;
    }

    public void setInterview_questions(Set<Question> interview_questions) {
        this.interview_questions = interview_questions;
    }


}

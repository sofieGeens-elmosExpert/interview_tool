package be.elmos.interview_tool_spring.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "example_answer")
public class Answer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "question.id")
    private Question question;
    private String answer;
    private Boolean isActive;

    public Answer() {
    }

    public Answer(Question questionId, String answer) {
        this.question = questionId;
        this.answer = answer;
        this.isActive = true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}

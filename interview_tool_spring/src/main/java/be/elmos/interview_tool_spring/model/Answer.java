package be.elmos.interview_tool_spring.model;

import jakarta.persistence.*;

public class Answer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column(name = "question_id")
    Question questionId;
    @Column(name = "answer")
    String answer;
    @Column(name = "active")
    Boolean isActive;

    public Answer() {
    }

    public Answer(Question questionId, String answer, Boolean isActive) {
        this.questionId = questionId;
        this.answer = answer;
        this.isActive = isActive;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Question getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Question questionId) {
        this.questionId = questionId;
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

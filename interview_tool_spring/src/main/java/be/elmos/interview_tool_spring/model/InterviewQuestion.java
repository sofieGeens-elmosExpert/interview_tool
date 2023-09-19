package be.elmos.interview_tool_spring.model;

import be.elmos.interview_tool_spring.model.persistence.InterviewQuestionId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "interview_has_questions")
public class InterviewQuestion {
    @EmbeddedId
    private InterviewQuestionId id;
    private String rating;

    public InterviewQuestion() {

    }

    public InterviewQuestion(InterviewQuestionId id, String rating) {
        this.id = id;
        this.rating = rating;
    }

    public InterviewQuestionId getId() {
        return id;
    }

    public void setId(InterviewQuestionId id) {
        this.id = id;
    }

    public String getRating() {
        return this.rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Interview Question { interviewQuestionId" + id + ", rating=" + rating + "}";
    }
}

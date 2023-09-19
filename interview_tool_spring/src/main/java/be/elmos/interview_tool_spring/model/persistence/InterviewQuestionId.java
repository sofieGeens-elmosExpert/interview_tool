package be.elmos.interview_tool_spring.model.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class InterviewQuestionId implements Serializable {
    @Column
    private long interview_id;
    @Column
    private long question_id;

    public InterviewQuestionId() {}

    public InterviewQuestionId(long interview_id, long question_id) {
        this.interview_id = interview_id;
        this.question_id = question_id;
    }

    public long getInterviewId() {
        return this.interview_id;
    }

    public void setInterviewId(long interviewId) {
        this.interview_id = interviewId;
    }

    public long getQuestionId() {
        return this.question_id;
    }

    public void setQuestionId(long questionId) {
        this.question_id = questionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InterviewQuestionId that = (InterviewQuestionId) o;
        return interview_id == that.getInterviewId() && question_id == that.getQuestionId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(interview_id, question_id);
    }

    @Override
    public String toString() {
        return "InterviewQuestionId { interviewId=" + interview_id + ", questionId=" + question_id + "}";
    }
}

package be.elmos.interview_tool_spring.dto;

import be.elmos.interview_tool_spring.model.persistence.InterviewQuestionId;

public class InterviewQuestionDto {
    private InterviewQuestionId id;
    private String rating;

    public InterviewQuestionDto(InterviewQuestionId id, String rating) {
        this.id = id;
        this.rating = rating;
    }

    public void setId(InterviewQuestionId id) {
        this.id = id;
    }

    public InterviewQuestionId getId() {
        return this.id;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRating() {
        return this.rating;
    }

}

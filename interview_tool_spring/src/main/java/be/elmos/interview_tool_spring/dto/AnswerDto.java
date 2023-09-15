package be.elmos.interview_tool_spring.dto;

import be.elmos.interview_tool_spring.model.Question;
import jakarta.persistence.*;

public class AnswerDto {
    String answer;

    public AnswerDto() {
    }

    public AnswerDto(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

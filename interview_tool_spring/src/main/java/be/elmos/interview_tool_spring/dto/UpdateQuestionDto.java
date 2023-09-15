package be.elmos.interview_tool_spring.dto;

import be.elmos.interview_tool_spring.model.enums.AnswerType;
import be.elmos.interview_tool_spring.model.enums.Category;
import be.elmos.interview_tool_spring.model.enums.PersonType;
import be.elmos.interview_tool_spring.model.enums.QuestionType;

public class UpdateQuestionDto extends QuestionDto {
    public UpdateQuestionDto() {
    }

    public UpdateQuestionDto(PersonType role, Category category, QuestionType questionType, AnswerType answerType, String question, Boolean isActive) {
        super(role, category, questionType, answerType, question);
    }
}

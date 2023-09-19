package be.elmos.interview_tool_spring.dto;

import be.elmos.interview_tool_spring.model.enums.AnswerType;
import be.elmos.interview_tool_spring.model.enums.Category;
import be.elmos.interview_tool_spring.model.enums.PersonType;
import be.elmos.interview_tool_spring.model.enums.QuestionType;

public class SelectQuestionDto extends QuestionDto{
    long id;

    public SelectQuestionDto() {
    }

    public SelectQuestionDto( long id, PersonType role, Category category, QuestionType questionType, AnswerType answerType, String question) {
        super(role, category, questionType, answerType, question);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

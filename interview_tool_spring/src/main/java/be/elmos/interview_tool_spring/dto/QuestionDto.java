package be.elmos.interview_tool_spring.dto;

import be.elmos.interview_tool_spring.model.enums.AnswerType;
import be.elmos.interview_tool_spring.model.enums.Category;
import be.elmos.interview_tool_spring.model.enums.PersonType;
import be.elmos.interview_tool_spring.model.enums.QuestionType;


public abstract class QuestionDto {
    PersonType role;
    Category category;
    QuestionType questionType;
    AnswerType answerType;
    String question;
    Boolean isActive;

    public QuestionDto() {
    }

    public QuestionDto(PersonType role, Category category, QuestionType questionType, AnswerType answerType, String question) {
        this.role = role;
        this.category = category;
        this.questionType = questionType;
        this.answerType = answerType;
        this.question = question;
        this.isActive = isActive;
    }

    public PersonType getRole() {
        return role;
    }

    public void setRole(PersonType role) {
        this.role = role;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public AnswerType getAnswerType() {
        return answerType;
    }

    public void setAnswerType(AnswerType answerType) {
        this.answerType = answerType;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}

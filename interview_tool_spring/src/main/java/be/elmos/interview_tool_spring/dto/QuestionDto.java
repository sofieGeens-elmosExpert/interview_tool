package be.elmos.interview_tool_spring.dto;

import be.elmos.interview_tool_spring.model.enums.AnswerType;
import be.elmos.interview_tool_spring.model.enums.Category;
import be.elmos.interview_tool_spring.model.enums.PersonType;
import be.elmos.interview_tool_spring.model.enums.QuestionType;


public abstract class QuestionDto {
    String role;
    String category;
    String questionType;
    String answerType;
    String question;
    Boolean isActive;

    public QuestionDto() {
    }

    public QuestionDto(PersonType role, Category category, QuestionType questionType, AnswerType answerType, String question) {
        setQuestion(question);
        setRole(role);
        setCategory(category);
        setQuestionType(questionType);
        setAnswerType(answerType);
        setActive(true);
    }

    public String getRole() {
        return role;
    }

    public void setRole(PersonType role) {
        switch (role) {
            case JUNIOR -> this.role = "junior";
            case MEDIOR -> this.role = "medior";
            case SENIOR -> this.role = "senior";
            default -> this.role = "";
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        switch (category) {
            case RECRUITING -> this.category = "recruiting";
            case TECHNICAL -> this.category = "technical";
            default -> this.category = "not specified";
        }
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        switch (questionType) {
            case START -> this.questionType = "start";
            case MIDDLE -> this.questionType = "middle";
            case END -> this.questionType = "end";
            default -> this.questionType = "not specified";
        }
    }

    public String getAnswerType() {
        return answerType;
    }

    public void setAnswerType(AnswerType answerType) {
        switch (answerType) {
            case BOOL -> this.answerType = "true/false";
            case SCALE -> this.answerType = "scale";
            case OPEN -> this.answerType = "open";
            default -> this.answerType = "not specified";
        }
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

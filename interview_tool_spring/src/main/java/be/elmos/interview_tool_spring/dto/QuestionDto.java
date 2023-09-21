package be.elmos.interview_tool_spring.dto;

import be.elmos.interview_tool_spring.model.Language;


public abstract class QuestionDto {
    String role;
    String category;
    String questionType;
    String answerType;
    String question;
    Language language;
    Boolean isActive;

    public QuestionDto() {
    }

    public QuestionDto(String role, String category, String questionType, String answerType, String question) {
        this.question = question;
        this.role = role;
        this.category = category;
        this.questionType = questionType;
        this.answerType = answerType;
        setActive(true);
    }

    public String getRole() {
        return role;
    }

    public String getCategory() {
        return category;
    }

    public String getQuestionType() {
        return questionType;
    }

    public Language getLanguage(){
        return this.language;
    }

    public void setLanguage(Language language){
        this.language = language;
    }

    public String getAnswerType() {
        return answerType;
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

    @Override
    public String toString() {
        return "QuestionDto{" +
                "role='" + role + '\'' +
                ", category='" + category + '\'' +
                ", questionType='" + questionType + '\'' +
                ", answerType='" + answerType + '\'' +
                ", question='" + question + '\'' +
                ", language=" + language +
                ", isActive=" + isActive +
                '}';
    }
}

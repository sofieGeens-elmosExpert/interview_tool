package be.elmos.interview_tool_spring.model;

import be.elmos.interview_tool_spring.model.enums.AnswerType;
import be.elmos.interview_tool_spring.model.enums.Category;
import be.elmos.interview_tool_spring.model.enums.PersonType;
import be.elmos.interview_tool_spring.model.enums.QuestionType;
import jakarta.persistence.*;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    long id;
    @Column(name = "role")
    PersonType role;
    @Column(name = "category")
    Category category;
    @Column(name = "question_type")
    QuestionType questionType;
    @Column(name = "answer_type")
    AnswerType answerType;
    @Column(name = "question")
    String question;
    @Column(name = "active")
    Boolean isActive;

    public Question() {
    }

    public Question(PersonType role, Category category, QuestionType questionType, AnswerType answerType, String question) {
        this.role = role;
        this.category = category;
        this.questionType = questionType;
        this.answerType = answerType;
        this.question = question;
        this.isActive = true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

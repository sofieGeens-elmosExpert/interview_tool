package be.elmos.interview_tool_spring.model;

import be.elmos.interview_tool_spring.model.enums.AnswerType;
import be.elmos.interview_tool_spring.model.enums.Category;
import be.elmos.interview_tool_spring.model.enums.PersonType;
import be.elmos.interview_tool_spring.model.enums.QuestionType;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "question")
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name = "role")
    private PersonType role;
    @Column(name = "category")
    private Category category;
    @Column(name = "question_type")
    private QuestionType questionType;
    @Column(name = "answer_type")
    private AnswerType answerType;
    @Column(name = "question")
    private String question;
    @Column(name = "active")
    //private Boolean isActive; // changed to avoid 'query findByActive failed in QuestionRepo -> could not find attribute (active)
    private Boolean active;

    public Question() {
        this.active = true;
    }

    public Question(PersonType role, Category category, QuestionType questionType, AnswerType answerType, String question) {
        this.role = role;
        this.category = category;
        this.questionType = questionType;
        this.answerType = answerType;
        this.question = question;
        this.active = true;
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

    public void setRole(String role){
        switch (role) {
            case "junior" -> this.role = PersonType.JUNIOR;
            case "medior" -> this.role = PersonType.MEDIOR;
            case "senior" -> this.role = PersonType.SENIOR;
            default -> this.role = PersonType.EMPTY;
        }
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setCategory(String category){
        switch (category) {
            case "recruiting" -> this.category = Category.RECRUITING;
            case "technical" -> this.category = Category.TECHNICAL;
            default -> this.category = Category.RECRUITING;
        }
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public void setQuestionType(String questionType){
        switch (questionType) {
            case "start" -> this.questionType = QuestionType.START;
            case "middle" -> this.questionType = QuestionType.MIDDLE;
            case "end" -> this.questionType = QuestionType.END;
            default -> this.questionType = QuestionType.MIDDLE;
        }
    }

    public AnswerType getAnswerType() {
        return answerType;
    }

    public void setAnswerType(AnswerType answerType) {
        this.answerType = answerType;
    }

    public void setAnswerType(String answerType){
        switch (answerType) {
            case "true/false" -> this.answerType = AnswerType.BOOL;
            case "rating" -> this.answerType = AnswerType.SCALE;
            case "open" -> this.answerType = AnswerType.OPEN;
            default -> this.answerType = AnswerType.SCALE;
        }
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}

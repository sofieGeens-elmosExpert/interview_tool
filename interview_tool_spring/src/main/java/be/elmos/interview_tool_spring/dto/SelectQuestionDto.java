package be.elmos.interview_tool_spring.dto;


public class SelectQuestionDto extends QuestionDto{
    private long id;

    public SelectQuestionDto() {
    }

    public SelectQuestionDto( long id, String role, String category, String questionType, String answerType, String question) {
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

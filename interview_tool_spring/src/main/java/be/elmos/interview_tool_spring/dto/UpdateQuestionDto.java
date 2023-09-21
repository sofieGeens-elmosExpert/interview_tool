package be.elmos.interview_tool_spring.dto;

public class UpdateQuestionDto extends QuestionDto {
    public UpdateQuestionDto() {
    }

    public UpdateQuestionDto(String role, String category, String questionType, String answerType, String question) {
        super(role, category, questionType, answerType, question);
    }
}

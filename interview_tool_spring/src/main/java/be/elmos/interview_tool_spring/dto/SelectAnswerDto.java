package be.elmos.interview_tool_spring.dto;

public class SelectAnswerDto extends AnswerDto {

    long id;

    public SelectAnswerDto() {
    }

    public SelectAnswerDto(String answer) {
        super(answer);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

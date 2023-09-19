package be.elmos.interview_tool_spring.dto;

public class SelectAnswerDto extends AnswerDto {

    long id;

    public SelectAnswerDto() {
    }

    public SelectAnswerDto(long id, String answer) {
        super(answer);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

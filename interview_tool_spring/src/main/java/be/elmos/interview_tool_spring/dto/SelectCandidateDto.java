package be.elmos.interview_tool_spring.dto;

import be.elmos.interview_tool_spring.model.enums.PersonType;

public class SelectCandidateDto extends CandidateDto {

    private long id;

    public SelectCandidateDto(){
        super();
    }

    public SelectCandidateDto(String ln, String fn, String mail,long id, PersonType r){
        super(ln,fn,mail,r);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

package be.elmos.interview_tool_spring.dto;

import be.elmos.interview_tool_spring.model.Candidate;
import be.elmos.interview_tool_spring.model.Type;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

public class SelectCandidateDto extends CandidateDto {

    private long id;

    public SelectCandidateDto(String ln, String fn, String mail,long id, Type r){
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

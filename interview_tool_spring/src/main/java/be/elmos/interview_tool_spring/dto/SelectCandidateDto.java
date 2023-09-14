package be.elmos.interview_tool_spring.dto;

import be.elmos.interview_tool_spring.model.Candidate;
import be.elmos.interview_tool_spring.model.Type;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

public class SelectCandidateDto extends CandidateDto {

    public SelectCandidateDto(String ln, String fn, String mail, Type r){
        super(ln,fn,mail,r);
    }
}

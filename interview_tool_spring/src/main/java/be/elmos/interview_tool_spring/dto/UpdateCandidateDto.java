package be.elmos.interview_tool_spring.dto;

import be.elmos.interview_tool_spring.model.Type;

public class UpdateCandidateDto extends CandidateDto {
    public UpdateCandidateDto(String ln, String fn, String mail, Type r){
        super(ln,fn,mail,r);
    }
}

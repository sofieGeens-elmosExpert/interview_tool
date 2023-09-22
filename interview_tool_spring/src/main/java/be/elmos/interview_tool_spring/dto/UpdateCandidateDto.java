package be.elmos.interview_tool_spring.dto;

public class UpdateCandidateDto extends CandidateDto {
    public UpdateCandidateDto(String ln, String fn, String mail, String r){
        super(ln,fn,mail,r);
    }
    public UpdateCandidateDto(){super();}
}

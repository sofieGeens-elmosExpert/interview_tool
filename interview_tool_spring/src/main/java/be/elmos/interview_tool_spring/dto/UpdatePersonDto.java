package be.elmos.interview_tool_spring.dto;

public class UpdatePersonDto extends PersonDto {

    private String password;

    public UpdatePersonDto(){
        super();
    }
    public UpdatePersonDto(String ln,String fn,String mail, String r, String p){
        super(ln,fn,mail,r);
        setPassword(p);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package be.elmos.interview_tool_spring.dto;

public class SelectPersonDto extends PersonDto {

    private long id;

    public SelectPersonDto(){
        super();
    }
    public SelectPersonDto(String ln,String fn,String mail, String r, long id) {
        super(ln,fn,mail,r);
        setId(id);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

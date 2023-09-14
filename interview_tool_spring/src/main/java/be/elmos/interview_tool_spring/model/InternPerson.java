package be.elmos.interview_tool_spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class InternPerson extends Person {

    @Column(name = "password")
    private String password;

    public String getPassword(){
        return password;
    }

    public void setPassword(String pw){
        password=pw;
    }

    public InternPerson(String lastName, String firstName, String email, String pw, Type role) {
        super(lastName, firstName, email, role);
        password = pw;
    }

    public InternPerson(){}

}

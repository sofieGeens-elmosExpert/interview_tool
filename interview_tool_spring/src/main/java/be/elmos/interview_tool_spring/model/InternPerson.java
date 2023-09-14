package be.elmos.interview_tool_spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    public InternPerson(String firstName, String lastName, String email, String password, Type role) {
        super(firstName, lastName, email, password, role);
    }
}

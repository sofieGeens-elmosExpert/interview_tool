package be.elmos.interview_tool_spring.model;

import be.elmos.interview_tool_spring.model.enums.PersonType;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "person")
public class InternPerson extends Person implements Serializable {

//    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    private Long id;

    @Column(name = "password")
    private String password;

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public InternPerson() {
    }

    public InternPerson(String lastName, String firstName, String email, String password, String role) {
        super(lastName, firstName, email, role);
        this.password = password;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    @Override
    public int compareTo(Object person) {
        return (int) (this.getId()- ((InternPerson)person).getId());
    }
}

package be.elmos.interview_tool_spring.model;


import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@MappedSuperclass
public abstract class Person implements Comparable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long ID;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "email")
    private String email;
    @Column(name = "role")
    private Type role;
    @Column(name = "active")
    private Boolean active;

    public Person(String lastName, String firstName, String email, Type role) {
        setLastName(lastName);
        setFirstName(firstName);
        setEmail(email);
        setRole(role);
    }

    public Person(){}

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Type getRole() {
        return role;
    }

    public void setRole(Type role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return String.format("Person[id=%d, firstName='%s', lastName='%s', email='%s', role='%s']", ID, firstName, lastName, email, role);
    }

    @Override
    public int compareTo(Object person) {
        return (int) (this.getID()- ((Person)person).getID());
    }
}

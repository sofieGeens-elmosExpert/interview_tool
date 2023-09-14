package be.elmos.interview_tool_spring.model;


import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "person")
public abstract class Person implements Comparable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private Type role;

    public Person(String firstName, String lastName, String email, String password, Type role) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
        setRole(role);
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Type getRole() {
        return role;
    }

    public void setRole(Type role) {
        this.role = role;
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

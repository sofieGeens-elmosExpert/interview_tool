package be.elmos.interview_tool_spring.model;


import be.elmos.interview_tool_spring.model.enums.PersonType;
import jakarta.persistence.*;


@MappedSuperclass
public abstract class Person implements Comparable {

    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY) // id hoeft niet, is wel oke als overgeërfd door InterPerson en Candidate
    private Long personId;

    @Column(name = "lastname")
    private String lastName;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "email")
    private String email;
    @Column(name = "role")
    private PersonType role;
    @Column(name = "active")
    private Boolean active;

    public Person(String lastName, String firstName, String email, PersonType role) {
        setLastName(lastName);
        setFirstName(firstName);
        setEmail(email);
        setRole(role);
        this.active = true;
    }

    public Person() {
        this.active = true;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

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


    public PersonType getRole() {
        return role;
    }

    public void setRole(PersonType role) {
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
        return String.format("Person[firstName='%s', lastName='%s', email='%s', role='%s']", firstName, lastName, email, role);
    }


}

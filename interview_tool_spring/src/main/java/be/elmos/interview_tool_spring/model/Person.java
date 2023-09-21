package be.elmos.interview_tool_spring.model;


import be.elmos.interview_tool_spring.model.enums.PersonType;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;


@MappedSuperclass
public abstract class Person implements Comparable {

    @Id
//    @GenericGenerator(name = "generator", strategy = "uuid2")
//    @GeneratedValue(generator = "generator") // id hoeft niet, is wel oke als overgeërfd door InterPerson en Candidate
    @GeneratedValue(strategy=GenerationType.SEQUENCE)//(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lastname")
    private String lastName;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "email")
    private String email;
    //@Enumerated(EnumType.STRING)
    @Column(name = "role")
    private String role;
    @Column(name = "active")
    private Boolean active;

    public Person(String lastName, String firstName, String email, String role) {
        setLastName(lastName);
        setFirstName(firstName);
        setEmail(email);
        setRole(role);
        this.active = true;
        System.out.println("CREATED " + role);
    }

    public Person() {
        this.active = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
// JUNIOR('j'), MEDIOR('c'), SENIOR('s'), RECRUITER('r'), MANAGER('m'), ADMIN('a'), EMPTY('e');
    public PersonType getRole() {
        return switch (this.role) {
            case "j" -> PersonType.JUNIOR;
            case "c" -> PersonType.MEDIOR;
            case "s" -> PersonType.SENIOR;
            case "r" -> PersonType.RECRUITER;
            case "m" -> PersonType.MANAGER;
            case "a" -> PersonType.ADMIN;
            default  -> PersonType.EMPTY; // TODO JUNIOR DEFAULT? WAT IS EMPTY DAN?
        };
    }

    public void setRole(String role) {
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
        PersonType roleType = getRole();
        return String.format("Person[firstName='%s', lastName='%s', email='%s', role='%s', id='%d']", firstName, lastName, email, roleType, id);
    }


}

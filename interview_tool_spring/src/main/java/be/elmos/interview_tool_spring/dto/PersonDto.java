package be.elmos.interview_tool_spring.dto;

public abstract class PersonDto {
    private String lastName;
    private String firstName;
    private String email;
    private String role;

    public PersonDto() {
    }

    public PersonDto(String ln, String fn, String mail, String r) {
        setLastName(ln);
        setFirstName(fn);
        setEmail(mail);
        setRole(r);
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "lastname='" + lastName + '\'' +
                ", firstname='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

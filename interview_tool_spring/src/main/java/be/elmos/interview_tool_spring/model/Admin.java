package be.elmos.interview_tool_spring.model;

public class Admin extends InternPerson {
    public Admin(String firstName, String lastName, String email, String password, Type role) {
        super(firstName, lastName, email, password, role);
    }
}

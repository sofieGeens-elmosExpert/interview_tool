package be.elmos.interview_tool_spring.model;

import be.elmos.interview_tool_spring.model.enums.PersonType;

public class Manager extends InternPerson {
    public Manager(String lastName, String firstName, String email, String password, PersonType role) {
        super(lastName, firstName, email, password, role);
    }
}

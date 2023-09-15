package be.elmos.interview_tool_spring.model;

import be.elmos.interview_tool_spring.model.enums.PersonType;

public class Recruiter extends InternPerson {
    public Recruiter(String lastName, String firstName, String email, String password, PersonType role) {
        super(lastName, firstName, email, password, role);
    }
}

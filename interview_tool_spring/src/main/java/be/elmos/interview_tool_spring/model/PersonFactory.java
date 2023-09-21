package be.elmos.interview_tool_spring.model;

import be.elmos.interview_tool_spring.model.enums.PersonType;

public class PersonFactory {
    public Person getPerson(final PersonType type, String lastName, String firstName, String email, String password) {
        switch (type) {
            case JUNIOR:
            case MEDIOR:
            case SENIOR:
                return new Candidate(lastName, firstName, email, String.valueOf(type.getName()));
            case RECRUITER:
            case MANAGER:
            case ADMIN:
                return new InternPerson(lastName, firstName, email, password, String.valueOf(type.getName()));
            default:
                return null;
        }
    }
}

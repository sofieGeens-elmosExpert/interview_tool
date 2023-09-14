package be.elmos.interview_tool_spring.model;

public class PersonFactory {
    public Person getPerson(final Type type, String lastName, String firstName, String email, String password) {
        switch (type) {
            case JUNIOR:
            case MEDIOR:
            case SENIOR:
                return new Candidate(lastName, firstName, email, type);
            case RECRUITER:
                return new Recruiter(lastName, firstName, email, password, type);
            case MANAGER:
                return new Manager(lastName, firstName, email, password, type);
            case ADMIN:
                return new Admin(lastName, firstName, email, password, type);
            default:
                return null;
        }
    }
}

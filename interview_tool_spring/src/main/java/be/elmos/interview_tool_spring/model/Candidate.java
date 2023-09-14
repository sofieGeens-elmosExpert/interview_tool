package be.elmos.interview_tool_spring.model;

public class Candidate extends Person {
    public Candidate(String firstName, String lastName, String email, String password, Type role) {
        super(firstName, lastName, email, password, role);
        // TODO subklasse junior, senior, medior?
    }
}

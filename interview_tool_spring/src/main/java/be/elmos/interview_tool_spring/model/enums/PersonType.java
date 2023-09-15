package be.elmos.interview_tool_spring.model.enums;

public enum PersonType {
    JUNIOR('j'), MEDIOR('c'), SENIOR('s'), RECRUITER('r'), MANAGER('m'), ADMIN('a');

    private char name;

    PersonType(char s) {this.name = s;}

    public char getName() { return this.name; }

    public void setName(char name) {
        this.name = name;
    }

    public PersonType getType(char type) {
        return PersonType.valueOf(String.valueOf(type));
    }
}

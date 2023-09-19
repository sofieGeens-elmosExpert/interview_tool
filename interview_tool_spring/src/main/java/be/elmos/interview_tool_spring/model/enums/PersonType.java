package be.elmos.interview_tool_spring.model.enums;

public enum PersonType {
    //empty is used as a role for a question if a question should be asked to everyone
    //junior, senior, medior and empty are used to ask the correct questions to the correct candidates
    //recruiter, manager, admin are used to define access to certain pages and functionalities
    JUNIOR('j'), MEDIOR('c'), SENIOR('s'), RECRUITER('r'), MANAGER('m'), ADMIN('a'), EMPTY('e');

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

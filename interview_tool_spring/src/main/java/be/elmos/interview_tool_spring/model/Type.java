package be.elmos.interview_tool_spring.model;

public enum Type {
    JUNIOR('j'), MEDIOR('c'), SENIOR('s'), RECRUITER('r'), MANAGER('m'), ADMIN('a');

    private char name;

    Type(char s) {this.name = s;}

    public char getName() { return this.name; }

    public void setName(char name) {
        this.name = name;
    }

    public Type getType(char type) {
        return Type.valueOf(String.valueOf(type));
    }
}

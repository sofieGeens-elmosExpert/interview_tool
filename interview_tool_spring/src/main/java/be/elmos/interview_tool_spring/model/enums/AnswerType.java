package be.elmos.interview_tool_spring.model.enums;

public enum AnswerType {
    BOOL('b'), SCALE('s'), OPEN('o');

    private char name;

    AnswerType(char s) {this.name = s;}

    public char getName() { return this.name; }

    public void setName(char name) {
        this.name = name;
    }

    public AnswerType getType(char type) {
        return AnswerType.valueOf(String.valueOf(type));
    }
}

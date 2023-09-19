package be.elmos.interview_tool_spring.model.enums;

public enum AnswerType {
    //used to know how a recruiter can answer to a question, needed to display correct front-end
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

package be.elmos.interview_tool_spring.model.enums;

public enum QuestionType {
    START('s'), MIDDLE('m'), END('e');

    private char name;

    QuestionType(char s) {this.name = s;}

    public char getName() { return this.name; }

    public void setName(char name) {
        this.name = name;
    }

    public QuestionType getType(char type) {
        return QuestionType.valueOf(String.valueOf(type));
    }
}

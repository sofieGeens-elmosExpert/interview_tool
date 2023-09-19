package be.elmos.interview_tool_spring.model.enums;

public enum Category {
    //Is the question asked in the first interview or in a technical assessment
    RECRUITING('r'), TECHNICAL('t');

    private char name;

    Category(char s) {this.name = s;}

    public char getName() { return this.name; }

    public void setName(char name) {
        this.name = name;
    }

    public Category getType(char type) {
        return Category.valueOf(String.valueOf(type));
    }
}

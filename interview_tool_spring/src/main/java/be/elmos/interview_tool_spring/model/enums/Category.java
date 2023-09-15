package be.elmos.interview_tool_spring.model.enums;

public enum Category {
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

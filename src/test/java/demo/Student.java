package demo;

public class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.marks = marks;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
}
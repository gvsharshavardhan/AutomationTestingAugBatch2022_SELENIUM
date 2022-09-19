package demo;

public class StudentDemo {


    static Student createStudent(String name, int marks) {
        Student stu = new Student(name, marks);
        return stu;
    }

    public static void main(String[] args) {
        Student stu = createStudent("jaun", 100);
        System.out.println(stu.getName());
        System.out.println(stu.getMarks());
    }
}

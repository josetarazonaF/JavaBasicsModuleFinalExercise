package data;

import data.teacher.Teacher;

import java.util.ArrayList;

public class UniversityClass {
    private String name;
    private String assignedClassroom;
    private ArrayList<Student> students;
    private Teacher teacher;

    public UniversityClass(String name, String assignedClassroom, Teacher teacher) {
        this.name = name;
        this.assignedClassroom = assignedClassroom;
        this.students = new ArrayList<>();
        this.teacher = teacher;
    }

    public UniversityClass(String name, String assignedClassroom, ArrayList<Student> students, Teacher teacher) {
        this.name = name;
        this.assignedClassroom = assignedClassroom;
        this.students = students;
        this.teacher = teacher;
    }

    public void enrollStudent(Student student) {
        this.students.add(student);
    }

    public String getName() {
        return name;
    }

    public String getAssignedClassroom() {
        return assignedClassroom;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}

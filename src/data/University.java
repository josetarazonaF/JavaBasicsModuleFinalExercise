package data;

import data.teacher.Teacher;

import java.util.ArrayList;

public class University {
    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;
    private ArrayList<UniversityClass> universityClasses;

    public University() {
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.universityClasses = new ArrayList<>();
    }

    public University(ArrayList<Teacher> teachers, ArrayList<Student> students, ArrayList<UniversityClass> universityClasses) {
        this.teachers = teachers;
        this.students = students;
        this.universityClasses = universityClasses;
    }

    public void hireTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }

    public void enrollStudent(Student student) {
        this.students.add(student);
    }

    public void enrollClass(UniversityClass universityClass) {
        this.universityClasses.add(universityClass);
    }

    public ArrayList<UniversityClass> searchClassesByIncludedStudent(Student student) {
        ArrayList<UniversityClass> results = new ArrayList<>();
        for (UniversityClass uc : this.universityClasses) {
            if (uc.getStudents().contains(student)) {
                results.add(uc);
            }
        }
        return results;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<UniversityClass> getUniversityClasses() {
        return universityClasses;
    }
}

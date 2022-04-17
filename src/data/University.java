package data;

import data.teacher.Teacher;

import java.util.ArrayList;

public class University {
    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;
    private ArrayList<UniversityClass> universityClasses;

    private String name;
    private String acronym;


    public University(String name, String acronym) {
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.universityClasses = new ArrayList<>();

        this.name = name;
        this.acronym = acronym;
    }

    public University(ArrayList<Teacher> teachers, ArrayList<Student> students, ArrayList<UniversityClass> universityClasses,
                      String name, String acronym) {
        this.teachers = teachers;
        this.students = students;
        this.universityClasses = universityClasses;

        this.name = name;
        this.acronym = acronym;
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

            for (Student s : uc.getStudents()) {
                if (s.getId() == student.getId()) {
                    results.add(uc);
                }
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

    public String getName() {
        return name;
    }

    public String getAcronym() {
        return acronym;
    }
}


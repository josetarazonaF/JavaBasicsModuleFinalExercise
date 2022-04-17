package gui;

import data.Student;
import data.University;
import data.UniversityClass;
import data.teacher.FullTimeTeacher;
import data.teacher.PartTimeTeacher;
import data.teacher.Teacher;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        University myUniversity = initializeUniversity();

        NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
        Scanner gui = new Scanner(System.in);
        String option = "";
        while (!option.equalsIgnoreCase("f")) {
            System.out.println("Welcome to " + myUniversity.getName() + " - " + myUniversity.getAcronym());
            System.out.println("a. Print all teachers data");
            System.out.println("b. Print all classes");
            System.out.println("c. Create a new student and add it to an existing class");
            System.out.println("d. Create a new class and add an existing teacher ad existing students");
            System.out.println("e. Search classes by included student");
            System.out.println("f. Exit");

            option = gui.nextLine();

            switch (option) {
                case "a":
                    printAllTeachersData(myUniversity.getTeachers(), defaultFormat);
                    break;

                case "b":
                    printAllUniversityClassesData(myUniversity.getUniversityClasses());

                    System.out.println("Enter class id to view details");
                    System.out.println("or use 'x' to go back");
                    String submenuOption = gui.nextLine();

                    while (!submenuOption.equalsIgnoreCase("x")) {
                        try {
                            int id = Integer.parseInt(submenuOption);
                            printUniversityClassData(myUniversity.getUniversityClasses().get(id - 1));
                        } catch (Exception e) {
                            System.err.println("the id entered is not valid or it does not exist");
                        }
                        System.out.println("");
                        System.out.println("Enter class id to view details");
                        System.out.println("or use 'x' to go back");
                        submenuOption = gui.nextLine();

                    }
                    break;

                case "c":
                    System.out.println("enter student name");
                    String tempName = gui.nextLine();
                    System.out.println("enter student age");
                    int tempAge = Integer.parseInt(gui.nextLine());

                    Student tempStudent = new Student(tempName, (byte) tempAge);

                    myUniversity.enrollStudent(tempStudent);

                    printAllUniversityClassesData(myUniversity.getUniversityClasses());

                    System.out.println("select class id to enroll new student");
                    String classOption = gui.nextLine();

                    try {
                        int id = Integer.parseInt(classOption);
                        myUniversity.getUniversityClasses().get(id - 1).enrollStudent(tempStudent);
                        printUniversityClassData(myUniversity.getUniversityClasses().get(id - 1));
                        System.out.println("the student was successfully enrolled");
                    } catch (Exception e) {
                        System.err.println("the id entered is not valid or it does not exist");
                    }
                    System.out.println("");
                    break;

                case "d":
                    System.out.println("enter class name");
                    String tempClassName = gui.nextLine();

                    System.out.println("enter assigned classroom");
                    String tempAssignedClassroom = gui.nextLine();

                    printAllTeachersData(myUniversity.getTeachers(), defaultFormat);
                    System.out.println("enter teacher id to assign it to the new class");
                    int idTeacher = Integer.parseInt(gui.nextLine());
                    Teacher tempTeacher = myUniversity.getTeachers().get(idTeacher - 1);

                    UniversityClass tempUniversityClass = new UniversityClass(tempClassName, tempAssignedClassroom, tempTeacher);



                    printAllStudents(myUniversity.getStudents());
                    System.out.println("enter student id to enroll in new class");
                    System.out.println("enter 'x' to exit");
                    String studentOption = gui.nextLine();

                    while (!studentOption.equalsIgnoreCase("x")) {

                        try {
                            int tempStudentId = Integer.parseInt(studentOption);
                            tempUniversityClass.enrollStudent(myUniversity.getStudents().get(tempStudentId - 1));

                        } catch (Exception e) {
                            System.err.println("the id entered is not valid or it does not exist");
                        }

                        myUniversity.enrollClass(tempUniversityClass);
                        printUniversityClassData(tempUniversityClass);
                        System.out.println("student was enrolled successfully");
                        System.out.println("");

                        printAllStudents(myUniversity.getStudents());
                        System.out.println("enter student id to enroll in new class");
                        System.out.println("enter 'x' to exit");
                        studentOption = gui.nextLine();
                    }
                    break;

                case "e":
                    printAllStudents(myUniversity.getStudents());
                    System.out.println("enter student id to search given student in classes");

                    try {
                        int studentIdOption = Integer.parseInt(gui.nextLine());

                        printAllUniversityClassesData(
                                myUniversity.searchClassesByIncludedStudent(
                                        myUniversity.getStudents().get(studentIdOption - 1)));
                    } catch (Exception e) {
                        System.err.println("the id entered is not valid or it does not exist");
                    }
                    break;

                case "f":
                    System.out.println("Have a nice day!");
                    System.out.println("");
                    break;
            }

        }

    }

    private static void printAllTeachersData(ArrayList<Teacher> teachers, NumberFormat defaultFormat) {
        int counter = 0;
        for (Teacher t : teachers) {
            System.out.println("id: " + ++counter);
            System.out.println("Name: " + t.getName());
            System.out.println("Base Salary: " + defaultFormat.format(t.getBaseSalary()));
            System.out.println("Type Teacher: " + t.getTypeTeacher());
            System.out.println("Calculated Salary: " + defaultFormat.format(t.calculateSalary()));
            System.out.println("");
        }
    }

    private static void printAllStudents(ArrayList<Student> students) {
        int counter = 0;
        for (Student s : students) {
            System.out.println("id: " + ++counter + " name: " + s.getName());

        }
    }

    private static void printAllUniversityClassesData(ArrayList<UniversityClass> universityClasses) {
        int counter = 0;
        for (UniversityClass uc : universityClasses) {
            ++counter;
            System.out.println("id:" + counter + " - " + "Class: " + uc.getName());
            System.out.println("");
        }
    }

    private static void printUniversityClassData(UniversityClass universityClass) {
        System.out.println("Name: " + universityClass.getName());
        System.out.println("Assigned Classroom: " + universityClass.getAssignedClassroom());
        System.out.println("Students: ");
        for (Student s : universityClass.getStudents()) {
            System.out.println("\t" + s.getName());
        }
        System.out.println("Teacher: " + universityClass.getTeacher().getName());
    }

    private static University initializeUniversity() {

        ArrayList<Teacher> teachers = new ArrayList<>();

        teachers.add(new FullTimeTeacher("Milton Gomez", 5000000F, (byte) 3));
        teachers.add(new FullTimeTeacher("Edgar Perez", 3500000F, (byte) 1));
        teachers.add(new PartTimeTeacher("Matias Contreras", 40000F, (byte) 25));
        teachers.add(new PartTimeTeacher("jeff Rincon", 150000F, (byte) 20));

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Carlos Ramirez", (byte) 21));
        students.add(new Student("Diego Castellanos", (byte) 20));
        students.add(new Student("Camilo Suarez", (byte) 22));
        students.add(new Student("Juan Velez", (byte) 19));
        students.add(new Student("William Rodriguez", (byte) 25));
        students.add(new Student("Manuel Perez", (byte) 18));

        ArrayList<UniversityClass> universityClasses = new ArrayList<>();

        universityClasses.add(new UniversityClass("English", "SA401", teachers.get(0)));
        universityClasses.get(0).enrollStudent(students.get(0));
        universityClasses.get(0).enrollStudent(students.get(1));

        universityClasses.add(new UniversityClass("Politics", "SA321", teachers.get(1)));
        universityClasses.get(1).enrollStudent(students.get(0));
        universityClasses.get(1).enrollStudent(students.get(1));

        universityClasses.add(new UniversityClass("Algorithms", "SA431", teachers.get(2)));
        universityClasses.get(2).enrollStudent(students.get(2));
        universityClasses.get(2).enrollStudent(students.get(3));

        universityClasses.add(new UniversityClass("Spanish", "SA232", teachers.get(3)));
        universityClasses.get(3).enrollStudent(students.get(4));
        universityClasses.get(3).enrollStudent(students.get(5));
        universityClasses.get(3).enrollStudent(students.get(0));

        return new University(teachers, students, universityClasses, "Universidad Francisco de Paula Santander", "UFPS");

    }

}

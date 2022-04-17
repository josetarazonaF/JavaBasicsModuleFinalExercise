package data.teacher;

public abstract class Teacher {
    private String name;
    private double baseSalary;
    private String typeTeacher;

    public Teacher(String name, double baseSalary, String typeTeacher) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.typeTeacher = typeTeacher;
    }

    abstract public double calculateSalary();

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(float baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getTypeTeacher() {
        return typeTeacher;
    }
}

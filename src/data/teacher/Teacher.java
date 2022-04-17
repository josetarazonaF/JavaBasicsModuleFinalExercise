package data.teacher;

public abstract class Teacher {
    private String name;
    private double baseSalary;
    private String type_teacher;

    public Teacher(String name, double baseSalary, String type_teacher) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.type_teacher = type_teacher;
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

    public String getType_teacher() {
        return type_teacher;
    }
}

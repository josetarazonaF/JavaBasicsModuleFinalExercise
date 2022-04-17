package data.teacher;

public class FullTimeTeacher extends Teacher {
    public static final String TYPE_TEACHER = "Full Time Teacher";
    private byte xpYears;

    public FullTimeTeacher(String name, float baseSalary, byte xpYears) {
        super(name, baseSalary);
        this.xpYears = xpYears;
    }

    @Override
    public double calculateSalary() {
        return this.getBaseSalary() * (1.1 * this.xpYears);
    }
}

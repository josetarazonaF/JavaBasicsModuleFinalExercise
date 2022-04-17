package data.teacher;

public class FullTimeTeacher extends Teacher {
    private byte xpYears;

    public FullTimeTeacher(String name, float baseSalary, byte xpYears) {
        super(name, baseSalary, "Full Time Teacher");
        this.xpYears = xpYears;
    }

    @Override
    public double calculateSalary() {
        return this.getBaseSalary() * (1.1 * this.xpYears);
    }
}

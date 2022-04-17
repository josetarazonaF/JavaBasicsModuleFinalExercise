package data.teacher;

public class PartTimeTeacher extends Teacher {
    private byte activeHoursWeek;

    public PartTimeTeacher(String name, double baseSalary, byte activeHoursWeek) {
        super(name, baseSalary, "Part Time Teacher");
        this.activeHoursWeek = activeHoursWeek;
    }

    @Override
    public double calculateSalary() {
        return this.getBaseSalary() * this.activeHoursWeek;
    }
}

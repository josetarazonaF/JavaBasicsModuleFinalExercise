package data.teacher;

public class PartTimeTeacher extends Teacher {
    public static final String TYPE_TEACHER = "Part Time Teacher";
    private byte activeHoursWeek;

    public PartTimeTeacher(String name, double baseSalary, byte activeHoursWeek) {
        super(name, baseSalary);
        this.activeHoursWeek = activeHoursWeek;
    }

    @Override
    public double calculateSalary() {
        return this.getBaseSalary() * this.activeHoursWeek;
    }
}

package data;

public class PartTimeTeacher extends Teacher{
    byte activeHoursWeek;

    public PartTimeTeacher(String name, double baseSalary, byte activeHoursWeek) {
        super(name, baseSalary);
        this.activeHoursWeek = activeHoursWeek;
    }

    @Override
    public double calculateSalary() {
        return this.getBaseSalary()*this.activeHoursWeek;
    }
}

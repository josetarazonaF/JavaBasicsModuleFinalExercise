package data;

public class Student {
    private static int idCount = 0;
    private int id = 0;
    private String name;
    private byte age;

    public Student(String name, byte age) {
        this.id = ++idCount;
        this.name = name;
        this.age = age;

    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public byte getAge() {
        return age;
    }
}

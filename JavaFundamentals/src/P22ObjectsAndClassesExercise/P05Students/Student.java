package P05Students;

public class Student {
    private String firstName;
    private String secondName;
    private double grade;


    public Student(String firstName, String secondName, double grade) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.grade = grade;
    }

    public double getGrade() {
        return this.grade;
    }

    @Override
    public String toString() {
        return String.format("%s %s: %.2f", this.firstName,this.secondName,this.grade);
    }
}

package L12DefiningClassesExercise.P07Google;

public class Child {
    private String childName;
    private String childBirthday;

    public Child(String name, String childBirthday) {
        this.childName = name;
        this.childBirthday = childBirthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s", childName,childBirthday);
    }
}

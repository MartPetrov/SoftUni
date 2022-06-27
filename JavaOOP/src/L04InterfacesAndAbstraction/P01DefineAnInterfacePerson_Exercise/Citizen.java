package L04InterfacesAndAbstraction.P01DefineAnInterfacePerson_Exercise;

public class Citizen implements Person {
    private final String name;
    private final int age;

    public Citizen(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }
}

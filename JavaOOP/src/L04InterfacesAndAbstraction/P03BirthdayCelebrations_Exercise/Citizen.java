package L04InterfacesAndAbstraction.P03BirthdayCelebrations_Exercise;

public class Citizen implements Person,Birthable,Identifiable {
    private final String name;
    private final int age;
    private final String id;
    private final String birthDate;


    public Citizen(String name, int age,String id,String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }

    @Override
    public String getId() {
        return this.id;
    }


}

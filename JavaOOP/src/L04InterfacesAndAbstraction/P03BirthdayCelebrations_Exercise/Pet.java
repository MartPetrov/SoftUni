package L04InterfacesAndAbstraction.P03BirthdayCelebrations_Exercise;

public class Pet implements Birthable{
    private final String name;
    private final String birthDate;

    public Pet(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }

    public String getName() {
        return this.name;
    }
}

package L04InterfacesAndAbstraction.P03BirthdayCelebrations_Exercise;

public class Robot implements Identifiable{
    private String model;
    private String id;

    public Robot( String id,String model) {
        this.model = model;
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }
    public String getModel() {
        return this.model;
    }
}

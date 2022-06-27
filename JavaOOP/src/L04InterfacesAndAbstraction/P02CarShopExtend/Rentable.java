package L04InterfacesAndAbstraction.P02CarShopExtend;

public interface Rentable extends Car {
    Integer getMinRentDay();
    Double getPricePerDay();
}

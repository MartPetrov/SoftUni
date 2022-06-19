package L07Generics.GenericScale;


public class Main {
    public static void main(String[] args) {

       Scale<String> scale = new Scale<>("A","B");
        System.out.println(scale.getHeavier());
    }
}

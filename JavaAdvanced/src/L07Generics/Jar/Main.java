package L07Generics.Jar;

public class Main {
    public static void main(String[] args) {
        Jar jar = new Jar<>();

        jar.add("Blue Cookie");
        jar.add("Red Cookie");
        jar.add("Green Cookie");

        System.out.println(jar.remove());
        System.out.println(jar.remove());
    }
}

package lab02;

public class SimpleTest {
    public String Hello() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        System.out.println(new SimpleTest().Hello());
    }
}
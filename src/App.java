import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        Random rng = new Random();
        rng.nextInt(5);
        System.out.println(rng.nextInt(5));
    }
}

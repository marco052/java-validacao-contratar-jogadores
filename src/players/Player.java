package players;

import java.util.Random;

public class Player {
    private String name;
    private Random rng = new Random();
    private int buyNowPrice;

    public Player (String name){
        this.name = name;
        this.buyNowPrice = rng.nextInt(700, 15000000);
    }

    public String getName() {
        return name;
    }

    public int getBuyNow() {
        return buyNowPrice;
    }
    
}

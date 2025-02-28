package io.github.some_example_name;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;

import java.util.Iterator;
import java.util.Random;

public class Gold {
    private Array<GoldCoin> coins; // Array to store multiple GoldCoin instances
    private Array<Trap> traps; // Array to store multiple Trap instances
    private ShapeRenderer shapeRenderer;
    private Random random;
    public int count = 0;
    private int coinToWin = 10;


    public Gold(int numberOfCoins, int gridSize) {
        this.coins = new Array<>();
        this.traps = new Array<>();
        this.shapeRenderer = new ShapeRenderer();
        this.random = new Random();

        // Generate coins and traps at random positions in the grid
        for (int i = 0; i < numberOfCoins; i++) {
            int gridX = random.nextInt(gridSize); // Random grid X
            int gridY = random.nextInt(gridSize); // Random grid Y
            int coinX = gridX * 50 + 25; // X Position (center of grid box)
            int coinY = gridY * 50 + 25; // Y Position (center of grid box)
            coins.add(new GoldCoin(coinX, coinY, 12)); // Create a GoldCoin with a radius

            // 10% chance to spawn a trap on the same square as a coin
            if (random.nextDouble() < 0.1) {
                traps.add(new Trap(coinX, coinY, 12)); // Create a Trap with the same position and radius
            }
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void draw() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        //shapeRenderer.setColor(0.15f, 0.15f, 0.2f, 1f);
        shapeRenderer.setColor(Color.WHITE);
        for (Trap trap : traps) {
            // Draw traps as circles (invisible in the game but noted for development)
            trap.getBounds().setRadius(0); // Set radius to 0 for invisibility
            shapeRenderer.circle(trap.getBounds().x, trap.getBounds().y, 12); // Draw trap as a circle
        }

        shapeRenderer.setColor(Color.GOLD); // Set color to gold for coins
        for (GoldCoin coin : coins) {
            coin.draw(shapeRenderer); // Draw each coin
        }
        shapeRenderer.end();
    }

    public void collectCoins(Player player) {
        Iterator<GoldCoin> iterator = coins.iterator();
        while (iterator.hasNext()) {
            GoldCoin coin = iterator.next();
            // Check if the player has collected this coin
            if (player.getBounds().overlaps(coin.getBounds())) {
                iterator.remove(); // Remove the coin from the array
                System.out.println("Coin collected!"); // Notify that a coin has been collected
                count = count +1;
                System.out.println(count);
            }
        }
    }

    public void checkTraps(Player player) {
        Iterator<Trap> iterator = traps.iterator();
        while (iterator.hasNext()) {
            Trap trap = iterator.next();
            // Check if the player has stepped on the trap
            if (player.getBounds().overlaps(trap.getBounds())) {
                 // Reset the player if they step on a trap
                //System.out.println("Trap activated! Monster is awake!!"); // Notify that a trap was activated
                trap.activateTrap(player);

            }
        }
    }

    public void win(){
        if (count == coinToWin) {
            System.out.println("Vous etes aussi habile qu'un elephant francais dans le tramway.");
            System.exit(1);
        }
    }

    public void dispose() {
        shapeRenderer.dispose();
        for (GoldCoin coin : coins) {
            coin.dispose();
        }
        for (Trap trap : traps) {

        }
    }
}

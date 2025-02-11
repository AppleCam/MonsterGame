package io.github.some_example_name;

import com.badlogic.gdx.math.Circle;

import java.util.Random;

public class Trap {
    private int x, y;
    private Circle bounds;
    private static final Random random = new Random();

    public Trap(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.bounds = new Circle(x, y, radius); // Initialize bounds for collision detection
    }

    public Circle getBounds() {
        return bounds; // Return the bounds for collision detection

    }

    public void activateTrap(Player player) {
        player.setChased(true); // Activate chasing state
    }

    public void dispose(){

    }


}

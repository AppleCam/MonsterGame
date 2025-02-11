package io.github.some_example_name;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;

public class GoldCoin {
    private int x, y, radius;
    private Circle bounds; // Circle for collision detection

    public GoldCoin(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.bounds = new Circle(x, y, radius); // Initialize bounds
    }

    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.circle(x, y, radius); // Draw the coin
    }

    public Circle getBounds() {
        return bounds; // Return the bounds for collision detection
    }

    public void dispose() {
        // Dispose logic if needed
    }
}

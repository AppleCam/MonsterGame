package io.github.some_example_name;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Monster {
    private ShapeRenderer shapeRenderer;
    private Vector2 position; // Position of the monster
    private int radius; // Radius of the monster
    private float speed = 2.0f; // Speed at which the monster chases the player
    private int x, y;
    private int dx = 50, dy = 50; // Grid cell size
    private boolean canMove = true; // Flag to control monster movement
    private Circle MBounds;

    public Monster(int x, int y, int radius) {
        this.position = new Vector2(x, y); // Initialize monster position
        this.radius = radius; // Set monster radius
        this.shapeRenderer = new ShapeRenderer(); // Create ShapeRenderer for drawing
        this.x = x;
        this.y = y;
        this.MBounds = new Circle(x, y, radius);
    }

    public void attack(Player player) {
        if (player.getBounds().overlaps(getMBounds())){
            System.out.println("Con comme une valise sans poignee!!!");
            System.exit(1);
        }
    }

    public void move(Player player) {
        // Check if the monster should chase the player
        if (player.isChased() && canMove) {
            // 1. Get the player's grid coordinates
            int playerGridX = (int) (player.getX() / dx);
            int playerGridY = (int) (player.getY() / dy);

            // 2. Get the monster's grid coordinates
            int monsterGridX = (int) (position.x / dx);
            int monsterGridY = (int) (position.y / dy);

            // 3. Determine the direction to move (up, down, left, right)
            int directionX = playerGridX - monsterGridX;
            int directionY = playerGridY - monsterGridY;

            // 4. horizontal movement
            if (Math.abs(directionX) >= Math.abs(directionY)) {
                if (directionX > 0) {
                    // Move right
                    position.x += dx;
                    canMove = false;
                } else if (directionX < 0) {
                    // Move left
                    position.x -= dx;
                    canMove = false;
                }
            } else { //vertical movement
                if (directionY > 0) {
                    // Move down
                    position.y += dy;
                    canMove = false;
                } else if (directionY < 0) {
                    // Move up
                    position.y -= dy;
                    canMove = false;
                }
            }

            // Update monster's position
            x = (int) position.x;
            y = (int) position.y;
            MBounds.setPosition(x, y);

            // Prevent the monster from moving again until the player's turn
            canMove = false;
        }
    }

    // Method to allow the monster to move again
    public void allowMovement() {
        canMove = true;
    }

    public void draw() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.RED); // Set color for the monster
        shapeRenderer.circle(position.x, position.y, radius); // Draw monster as a circle
        shapeRenderer.end();
    }

    public void dispose() {
        shapeRenderer.dispose(); // Dispose of ShapeRenderer resources
    }

    public Vector2 getPosition() {
        return position; // Get current position of the monster
    }

    public Circle getMBounds() {
        return MBounds;
    }
}

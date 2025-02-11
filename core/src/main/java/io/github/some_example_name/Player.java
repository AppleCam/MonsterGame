package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Player {
    private ShapeRenderer shapeRenderer;
    private int x, y;
    private int dy = 50; // vertical movement speed
    private int dx = 50; // horizontal movement speed
    private int radius;
    private Circle bounds; // Circle for collision detection
    private boolean chased = false; // Indicates if the player is being chased
    private Vector2 startPosition;
    private boolean canMove = true; // Flag to control movement

    public Player(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.startPosition = new Vector2(x, y);
        this.shapeRenderer = new ShapeRenderer();
        this.bounds = new Circle(x, y, radius); // Initialize bounds
    }

    public void draw() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.FOREST);
        shapeRenderer.circle(x, y, radius);
        shapeRenderer.end();
    }

    public void movement() {
        // Check if the player can move
        if (canMove) {
            // Handle movement input
            if (Gdx.input.isKeyJustPressed(Input.Keys.UP) || Gdx.input.isKeyJustPressed(Input.Keys.W)) {
                y += dy;
            }
            if (y + radius > Gdx.graphics.getHeight()) {
                y = Gdx.graphics.getHeight() - radius - 1;
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN) || Gdx.input.isKeyJustPressed(Input.Keys.S)) {
                y -= dy;
            }
            if (y - radius < 0) {
                y = 1 + radius;
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT) || Gdx.input.isKeyJustPressed(Input.Keys.A)) {
                x -= dx;
            }
            if (x - radius < 0) {
                x = 1 + radius;
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT) || Gdx.input.isKeyJustPressed(Input.Keys.D)) {
                x += dx;
            }
            if (x + radius > Gdx.graphics.getWidth()) {
                x = Gdx.graphics.getWidth() - radius - 1;
            }

            // Update bounds after moving
            bounds.setPosition(x, y);
        }
    }

    // Method to allow the player to move again
    public void allowMovement() {
        canMove = true;
    }

    public Circle getBounds() {
        return bounds; // Return the bounds for collision detection
    }


    public void setChased(boolean chased) {
        this.chased = chased;
    }

    public boolean isChased() {
        return chased;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void dispose() {
        shapeRenderer.dispose();
    }

    public boolean canMove() {
        return canMove;
    }
}

package io.github.some_example_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class MonsterMain extends ApplicationAdapter {
    private Grid grid;
    private Player player;
    private Gold gold;
    private Trap trap;
    private Monster monster;
    private Walls walls;
    private WallGen wallgen;
    private boolean isGoldCollected;
    private boolean playerMoved = false; // Flag to track player movement


    @Override
    public void create() {
        grid = new Grid(10); // 10 by 10 grid
        player = new Player(475, 475, 24);
        gold = new Gold(10,10); // Create 10 coins in a 10x10 grid
        trap = new Trap(25, 25, 24);
        monster = new Monster(25, 25, 24);
        walls = new Walls(50, 50);

    }

    @Override
    public void render() {
        // Handle player input
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT) && player.canMove()) {
            player.movement();
            playerMoved = true;
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT) && player.canMove()) {
            player.movement();
            playerMoved = true;
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.UP) && player.canMove()) {
            player.movement();
            playerMoved = true;
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN) && player.canMove()) {
            player.movement();
            playerMoved = true;
        }

        // Allow monster to move after player's turn
        if (playerMoved) {
            monster.allowMovement();
            playerMoved = false; // Reset the player movement flag
        }

        // Update and draw game elements
        grid.draw();
        player.draw();
        gold.collectCoins(player); // Check for coin collection
        gold.checkTraps(player); // Check for trap activation
        gold.draw(); // Draw all coins and traps
        monster.draw();
        monster.move(player);
        monster.attack(player);
        gold.win();
        walls.draw();
    }

    @Override
    public void dispose() {
        grid.dispose();
        player.dispose();
        gold.dispose();
        monster.dispose();
        trap.dispose();
    }
}

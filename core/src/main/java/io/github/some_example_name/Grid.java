package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

/** Class responsible for drawing the grid. */
public class Grid {
    private int gridSize;
    public float cellWidth, cellHeight;
    private ShapeRenderer shape1;

    public Grid(int gridSize) {
        this.gridSize = gridSize;
        this.shape1 = new ShapeRenderer();
        this.cellWidth = Gdx.graphics.getWidth() / (float) gridSize;
        this.cellHeight = Gdx.graphics.getHeight() / (float) gridSize;
    }

    public void draw() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        shape1.begin(ShapeRenderer.ShapeType.Line);
        shape1.setColor(Color.WHITE);

        // Draw vertical lines
        for (int i = 0; i <= gridSize; i++) {
            float x = i * cellWidth;
            shape1.line(x, 0, x, Gdx.graphics.getHeight());
        }

        // Draw horizontal lines
        for (int i = 0; i <= gridSize; i++) {
            float y = i * cellHeight;
            shape1.line(0, y, Gdx.graphics.getWidth(), y);
        }

        shape1.end();
    }

    public void dispose() {
        shape1.dispose();
    }
}

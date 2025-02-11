package io.github.some_example_name;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/** Base class for game objects. */
public class GameObject {
    protected ShapeRenderer shape;

    public GameObject() {
        shape = new ShapeRenderer();
    }


    public void dispose() {
        shape.dispose();
    }
}

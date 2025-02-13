package io.github.some_example_name;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

public class Walls {
    private int x,y,width,height;
    private Grid grid;
    private ShapeRenderer shapeRenderer;
    private Random random;
    private int count = 20;


    public Walls(int width, int height){
        this.width = width;
        this.height = height;
        this.shapeRenderer = new ShapeRenderer();

    }

    public void draw(){
        shapeRenderer.setColor(Color.FIREBRICK);
        shapeRenderer.rect(x,y,width,height);
    }

    public void dispose(){
        shapeRenderer.dispose();
    }
}

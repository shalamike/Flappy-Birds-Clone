package com.mygdx.game.sprites;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Bird {
    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return bird;
    }

    private static final float GRAVITY = -10;
    private Vector3 position;

    private Texture bird;

    public Bird(float x, float y){
        position = new Vector3(x, y, 0);


        bird = new Texture("bird.png");
    }

    public void update(float dt){

    }
}

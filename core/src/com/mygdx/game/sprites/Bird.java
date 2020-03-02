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
    private Vector3 velocity;
    private Texture bird;

    public Bird(float x, float y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0,0,0);

        bird = new Texture("bird.png");
    }

    public void update(float dt){
        velocity.add(0, GRAVITY, 0);
        velocity.scl(dt);
        position.add(0, velocity.y,0);

        velocity.scl(1/dt);
    }

    public void jump(){
        velocity.y = 250;
    }
}

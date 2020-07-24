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
    private static final int BIRD_MOVEMENT = 5;
    private Vector3 position;
    private Vector3 velocity;
    private Texture bird;

    public Bird(float x, float y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0,0,0);

        bird = new Texture("bird.png");
    }

    public void update(float dt){
        if (position.y > 0) {
            velocity.add(BIRD_MOVEMENT , GRAVITY, 0);
            velocity.scl(dt);
            position.add(BIRD_MOVEMENT, velocity.y, 0);
        }
        else if(position.y < 0){
            position.y = 0;
        }
        velocity.scl(1/dt);
    }

    public void jump(){
        velocity.y = 250;
    }
}

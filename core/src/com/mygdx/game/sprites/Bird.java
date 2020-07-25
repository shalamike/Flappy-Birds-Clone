package com.mygdx.game.sprites;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Bird {
    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getTexture() {
        return birdAnimation.getFrame();
    }

    private static final float GRAVITY = -15;
    private static final int BIRD_MOVEMENT = 100;
    private Vector3 position;
    private Vector3 velocity;
    private Texture bird;
    private Rectangle boundary;
    private Animation birdAnimation;
    private Texture texture;

    public Bird(float x, float y){
        position = new Vector3(x , y, 0);
        velocity = new Vector3(0,0,0);
        // getting the image for the bird
        //bird = new Texture("bird.png");
        //setting the animation textures for the bird
        texture = new Texture("birdanimation.png");
        birdAnimation = new Animation(new TextureRegion(texture), 3, 0.5f);
        // setting the collision boundary for the bird
        boundary = new Rectangle(x, y, texture.getWidth()/3, texture.getHeight()/3);
    }

    public void update(float dt){
        //updating the current frame the bird is animating
        birdAnimation.update(dt);
        //updating the position of the bird
        if (position.y > 0) {
            velocity.add(0 , GRAVITY, 0);
            velocity.scl(dt);
            position.add(BIRD_MOVEMENT * dt, velocity.y, 0);
        }
        else if(position.y < 0){
            position.y = 0;
        }
        velocity.scl(1/dt);

        //updating the birds collision boundary to ensure it stays with the bird
        boundary.setPosition(position.x, position.y);
    }

    public void jump(){
        velocity.y = 250;
    }

    public Rectangle getBoundary() { return boundary; }

    public void dispose(){texture.dispose();}
}

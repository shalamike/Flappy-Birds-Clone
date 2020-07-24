package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.states.GameStateManager;

import java.util.Random;

public class Tube {
    public Texture getTopTube() {
        return TopTube;
    }

    public Texture getBottomTube() {
        return BottomTube;
    }

    public Vector3 getPosTopTube() {
        return posTopTube;
    }

    public Vector3 getPosBottomTube() {
        return posBottomTube;
    }
    //width of the tube determined from measuring the png
    public static final float TUBE_WIDTH = 52;

    private static final float RANDRANGE = 150;
    private static final float GAP = 100;
    private static final float LOWESTOPENING = 120;
    private Texture TopTube, BottomTube;
    private Vector3 posTopTube, posBottomTube;
    private Random rand;


    public Tube(float x){
        //getting the image for the top and bottom tubes
        TopTube = new Texture("toptube.png");
        BottomTube = new Texture("bottomtube.png");
        // creating a random number for randomising positions of the tubes
        rand = new Random();

        // randomising the position of the top tube and bottom tubes
        posTopTube = new Vector3(x, rand.nextFloat()*RANDRANGE + GAP + LOWESTOPENING, 0);
        posBottomTube = new Vector3(x, posTopTube.y - GAP - BottomTube.getHeight(), 0);
    }

    public void reposition(float x){
        // randomly repositioning the top and bottom tubes
        posTopTube.set(x, rand.nextFloat()*RANDRANGE + GAP + LOWESTOPENING, 0);
        posBottomTube.set(x, posTopTube.y - GAP - BottomTube.getHeight(), 0);
    }
}

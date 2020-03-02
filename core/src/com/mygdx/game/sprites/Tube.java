package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;

public class Tube {
    private Texture TopTube, BottomTube;

    public Tube(float x){
        TopTube = new Texture("toptube.png");
        BottomTube = new Texture("bottomtube.png");
    }
}

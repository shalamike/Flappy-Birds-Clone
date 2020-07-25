package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Animation {
    // this array contains all the frames that will be used for the animation
    private Array<TextureRegion> frames;
    // this float determines how long a frame will have to stay in view
    private float maxFrameTime;
    // the current time the current frame has been view
    private float currentTime;
    // number of frames within the animation
    private int frameCount;
    // current frame we are currently viewing
    private int frame;

    /*within the constructor, it will take the:
    * a texture region that contains all frames contained in one image
    * an int framecount which is is the number of frames
    * cycle time is how long it will take to cycle through the entire animation
    * */
    public Animation(TextureRegion region, int frameCount, float cycleTime){
        frames = new Array<TextureRegion>();
        // dividing the texture region by the frame count
        int frameWidth = region.getRegionWidth() / frameCount;
        /*this for loop will loop through the three images in the texture regions
        * first it will take the image its going to spice through
        * second it will start take the x co-ordinate of the region its splicing through
        * so for the first region i will be 0 therefore the x co-ordinate will be 0 but then the
        * next region x will be at 48 and so on.
        * third the y co-ordinate is taken, and in this case it will allways be 0 as we just need
        * the length of the image
        * then last is the hight of the image which in this case we use the method getRegionHeight
        * to get the height of the image */
        for(int i = 0; i < frameCount; i++){
            frames.add(new TextureRegion(region, i * frameWidth, 0,frameWidth, region.getRegionHeight()));
        }
        this.frameCount = frameCount;
        maxFrameTime = cycleTime/frameCount;
        frame = 0;
    }

    // the update method will animate the bird
    public void update(float dt){
        currentTime += dt;
        if(currentTime > maxFrameTime){
            frame++;
            currentTime = 0;
        }
        if(frame >= frameCount)
            frame = 0;
    }

    public TextureRegion getFrame(){
        return frames.get(frame);
    }
}

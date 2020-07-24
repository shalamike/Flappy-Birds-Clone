package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.sprites.Bird;
import com.mygdx.game.sprites.Tube;

import static com.mygdx.game.sprites.Tube.TUBE_WIDTH;

public class PlayState extends State {
    private static final int SPACE_BETWEEN_TUBE = 125;
    private static final int TUBE_COUNT = 3;

    private Texture background;
    private Bird bird;
    private Tube Tube;

    //creating an array of Tubes that is currently empty
    private Array<Tube> tubes;


    public PlayState(GameStateManager gsm) {
        super(gsm);
        bird = new Bird(50,200);
        cam.setToOrtho(false, MyGdxGame.WIDTH/2, MyGdxGame.HEIGHT/2);
        background = new Texture("bg.png");
        Tube = new Tube(100);

        // initiallising the array of tubes
        tubes = new Array<Tube>();
        //creating a for loop to add tubes up to the TUBE _COUTN
        for (int i = 0; i<= TUBE_COUNT; i++){
            tubes.add(new Tube(i * (SPACE_BETWEEN_TUBE + Tube.TUBE_WIDTH)));
        }
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            bird.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);
        cam.position.x = bird.getPosition().x + 80;
        // creating the logic for the tubes so that only 4 tubes will remain at all times, replacing the one behind with the one in front

        for (Tube tube : tubes){
            if (cam.position.x - (cam.viewportWidth/2) > tube.getPosTopTube().x + tube.getTopTube().getWidth()){
                tube.reposition(tube.getPosTopTube().x + ((Tube.TUBE_WIDTH + SPACE_BETWEEN_TUBE) * TUBE_COUNT));
            }
        }
        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, cam.position.x - (cam.viewportWidth /2), 0);
        sb.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
        sb.draw(Tube.getTopTube(), Tube.getPosTopTube().x, Tube.getPosTopTube().y);
        sb.draw(Tube.getBottomTube(), Tube.getPosBottomTube().x, Tube.getPosBottomTube().y);
        sb.end();

    }

    @Override
    public void dispose() {

    }
}

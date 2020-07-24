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
    private static final int TUBE_SPACING = 125;
    private static final int TUBE_COUNT = 4;

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
        //Tube = new Tube(100);

        tubes = new Array<Tube>();

        // initiallising the array of tubes
        for (int i = 1; i <= TUBE_COUNT; i++){
            tubes.add(new Tube(i * (TUBE_SPACING + Tube.TUBE_WIDTH)));
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
        for(Tube tube : tubes){
            if(cam.position.x - (cam.viewportWidth/2) > tube.getPosTopTube().x + tube.getTopTube().getWidth()){
                tube.reposition(tube.getPosTopTube().x + ((tube.TUBE_WIDTH + TUBE_SPACING) * TUBE_COUNT));
            }
            if(tube.colides((bird.getBoundary())))
                gsm.set(new MenuState(gsm));
        }
        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, cam.position.x - (cam.viewportWidth /2), 0);
        sb.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
        for (Tube tube : tubes){
            sb.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
            sb.draw(tube.getBottomTube(), tube.getPosBottomTube().x, tube.getPosBottomTube().y);
        }
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();

    }
}

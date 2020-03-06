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

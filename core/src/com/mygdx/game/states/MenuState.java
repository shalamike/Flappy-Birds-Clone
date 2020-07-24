package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public class MenuState extends State {
    private Texture background;
    private Texture PlayBtn;

    public MenuState(GameStateManager gsm){
        super(gsm);
        background = new Texture("bg.png");
        PlayBtn = new Texture("playbtn.png");
    }

    @Override
    public void handleInput(){
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        sb.draw(PlayBtn, (MyGdxGame.WIDTH - PlayBtn.getWidth())/2, (MyGdxGame.HEIGHT - PlayBtn.getHeight())/2);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        PlayBtn.dispose();
    }
}

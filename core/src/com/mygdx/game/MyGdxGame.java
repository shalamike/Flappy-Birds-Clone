package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.GameStateManager;
import com.mygdx.game.states.MenuState;

import java.awt.Menu;

public class MyGdxGame extends ApplicationAdapter {
	Texture img;

	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	public static final String TITLE = "FLAPPY BIRDS!";

	private GameStateManager gsm;
	private SpriteBatch batch;
	// adding sounds and music to the game
	private Music music;

	@Override
	public void create () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		gsm.push(new MenuState(gsm));
//		img = new Texture("badlogic.jpg");
		// adding the music
		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setLooping(true);
		music.setVolume(0.1f);
		music.play();
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}

		//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();
//	}
	
	@Override
	public void dispose (){
		batch.dispose();
		img.dispose();
		music.dispose();
	}
}

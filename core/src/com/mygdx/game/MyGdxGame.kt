package com.mygdx.game

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.audio.Music
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.mygdx.game.states.GameStateManager
import com.mygdx.game.states.MenuState

class MyGdxGame : ApplicationAdapter() {
    var img: Texture? = null
    private var gsm: GameStateManager? = null
    private var batch: SpriteBatch? = null

    // adding sounds and music to the game
    private var music: Music? = null
    override fun create() {
        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        batch = SpriteBatch()
        gsm = GameStateManager()
        gsm!!.push(MenuState(gsm))
        //		img = new Texture("badlogic.jpg");
        // adding the music
        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"))
        music.setLooping(true)
        music.setVolume(0.1f)
        music.play()
    }

    override fun render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        gsm!!.update(Gdx.graphics.deltaTime)
        gsm!!.render(batch)
    }

    //		batch.begin();
    //		batch.draw(img, 0, 0);
    //		batch.end();
    //	}
    override fun dispose() {
        batch!!.dispose()
        img!!.dispose()
        music!!.dispose()
    }

    companion object {
        const val WIDTH = 480
        const val HEIGHT = 800
        const val TITLE = "FLAPPY BIRDS!"
    }
}
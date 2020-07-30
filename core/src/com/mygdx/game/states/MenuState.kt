package com.mygdx.game.states

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.mygdx.game.MyGdxGame

class MenuState(gsm: GameStateManager?) : State(gsm) {
    private val background: Texture
    private val PlayBtn: Texture
    override fun handleInput() {
        if (Gdx.input.justTouched()) {
            gsm.set(PlayState(gsm))
        }
    }

    override fun update(dt: Float) {
        handleInput()
    }

    override fun render(sb: SpriteBatch) {
        sb.projectionMatrix = cam.combined
        sb.begin()
        sb.draw(background, 0f, 0f)
        sb.draw(PlayBtn, cam.position.x - PlayBtn.height / 2, cam.position.y)
        sb.end()
    }

    override fun dispose() {
        background.dispose()
        PlayBtn.dispose()
        println("Menu state dispose")
    }

    init {
        cam.setToOrtho(false, MyGdxGame.WIDTH / 2.toFloat(), MyGdxGame.HEIGHT / 2.toFloat())
        background = Texture("bg.png")
        PlayBtn = Texture("playbtn.png")
    }
}
package com.mygdx.game.sprites

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector3
import java.util.*

class Tube(x: Float) {

    val topTube: Texture
    val bottomTube: Texture
    val posTopTube: Vector3
    val posBottomTube: Vector3
    private val rand: Random

    // rectangles for collision detection
    private val boundsTop: Rectangle
    private val boundsBot: Rectangle
    fun reposition(x: Float) {
        // randomly repositioning the top and bottom tubes
        posTopTube[x, rand.nextFloat() * RANDRANGE + GAP + LOWESTOPENING] = 0f
        posBottomTube[x, posTopTube.y - GAP - bottomTube.height] = 0f
        // setting rectangle boundaries to share the same positions as the tubes
        boundsTop.setPosition(posTopTube.x, posTopTube.y)
        boundsBot.setPosition(posBottomTube.x, posBottomTube.y)
    }

    fun colides(user: Rectangle): Boolean {
        return user.overlaps(boundsTop) || user.overlaps(boundsBot)
    }

    fun dispose() {
        topTube.dispose()
        bottomTube.dispose()
    }

    companion object {
        //width of the tube determined from measuring the png
        const val TUBE_WIDTH = 52f
        private const val RANDRANGE = 150f
        private const val GAP = 100f
        private const val LOWESTOPENING = 120f
    }

    init {
        //getting the image for the top and bottom tubes
        topTube = Texture("toptube.png")
        bottomTube = Texture("bottomtube.png")
        // creating a random number for randomising positions of the tubes
        rand = Random()

        // randomising the position of the top tube and bottom tubes
        posTopTube = Vector3(x, rand.nextFloat() * RANDRANGE + GAP + LOWESTOPENING, 0f)
        posBottomTube = Vector3(x, posTopTube.y - GAP - bottomTube.height, 0f)

        //creating the collision boundaries for the top and bottom tubes
        boundsTop = Rectangle(posTopTube.x, posTopTube.y, topTube.width.toFloat(), topTube.height.toFloat())
        boundsBot = Rectangle(posBottomTube.x, posBottomTube.y, bottomTube.width.toFloat(), bottomTube.height.toFloat())
    }
}
package de.erik.pokemonfangame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {

    private Texture texture;

    private float x;
    private float y;

    private float speed;


    public Player() {

        texture = new Texture("heart.png");

        x = 100;
        y = 100;

        speed = 1000;
    }


    public void update(float delta) {

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            y += speed * delta;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            y -= speed * delta;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            x -= speed * delta;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            x += speed * delta;
        }

        // Player im Bildschirm halten
        x = Math.max(0, Math.min(x, Gdx.graphics.getWidth() - texture.getWidth()));
        y = Math.max(0, Math.min(y, Gdx.graphics.getHeight() - texture.getHeight()));
    }


    public void draw(SpriteBatch batch) {

        batch.draw(texture, x, y);
    }


    public void dispose() {

        texture.dispose();
    }
}

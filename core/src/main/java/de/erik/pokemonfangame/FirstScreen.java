package de.erik.pokemonfangame;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/** First screen of the application. Displayed after the application is created. */
public class FirstScreen implements Screen {

    private SpriteBatch batch;
    private Player player;

    @Override
    public void show() {
        batch = new SpriteBatch();
        player = new Player();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void render(float delta) {



        // F11 = Fullscreen umschalten
        if (Gdx.input.isKeyJustPressed(Input.Keys.F11)) {
            if (Gdx.graphics.isFullscreen()) {
                Gdx.graphics.setWindowedMode(1280, 720);
            } else {
                Gdx.graphics.setFullscreenMode(
                    Gdx.graphics.getDisplayMode()
                );
            }
        }
        // Bildschirm leeren
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Spieler aktualisieren
        player.update(delta);

        // Spieler zeichnen
        batch.begin();
        player.draw(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        // If the window is minimized on a desktop (LWJGL3) platform, width and height are 0, which causes problems.
        // In that case, we don't resize anything, and wait for the window to be a normal size before updating.
        if(width <= 0 || height <= 0) return;

    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        batch.dispose();
        player.dispose();
        // Destroy screen's assets here.
    }
}

package de.erik.pokemonfangame;

import com.badlogic.gdx.Game;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {

    @Override
    public void create() {


        System.out.print ("Hello World2");
        setScreen(new FirstScreen());
    }



}

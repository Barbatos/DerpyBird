package com.me.DerpyBird;

import com.badlogic.gdx.Game;
import com.me.Screens.GameScreen;

public class DerpyGame extends Game {
	
	@Override
    public void create() {
        System.out.println("DerpyGame created! Heeeerp.");
        setScreen(new GameScreen());
    }
}

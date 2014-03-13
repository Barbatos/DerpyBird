package com.me.DerpyBird;

import com.badlogic.gdx.Game;
import com.me.Helpers.AssetsLoader;
import com.me.Screens.GameScreen;

public class DerpyGame extends Game {
	
	@Override
    public void create() {
		AssetsLoader.load();
        System.out.println("DerpyGame created! Heeeerp.");
        setScreen(new GameScreen());
    }
	
	@Override
    public void dispose() {
        super.dispose();
        AssetsLoader.dispose();
    }
}

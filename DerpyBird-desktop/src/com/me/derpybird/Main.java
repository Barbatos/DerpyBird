package com.me.derpybird;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.me.DerpyBird.DerpyGame;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "DerpyBird";
		cfg.width = 272;
		cfg.height = 408;
		
		new LwjglApplication(new DerpyGame(), cfg);
	}
}

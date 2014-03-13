package com.me.GameRenderer;

import com.me.GameWorld.GameWorld;

public class GameRenderer {
	
	private GameWorld world;
	
	public GameRenderer(GameWorld _world) {
        world = _world;
    }
	
	public void render() {
        System.out.println("GameRenderer - render");
    }
}

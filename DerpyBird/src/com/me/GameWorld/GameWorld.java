package com.me.GameWorld;

import com.badlogic.gdx.math.Rectangle;
import com.me.GameObjects.Bird;

public class GameWorld {
	
	private Bird bird;
	
	public GameWorld(int midPointY) {
		bird = new Bird(33, midPointY - 5, 17, 12);
	}
	
	public void update(float delta) {
        //System.out.println("fps: "+1/delta);
        bird.update(delta);
    }
	
	public Bird getBird() {
		return bird;
	}
}
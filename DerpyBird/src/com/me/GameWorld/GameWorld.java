package com.me.GameWorld;

import com.me.GameObjects.Bird;
import com.me.GameObjects.ScrollHandler;

public class GameWorld {
	
	private Bird bird;
	private ScrollHandler scroller;
	
	int midPointY;
	int floorLevel;
	
	public GameWorld(int midPointY) {
		bird = new Bird(33, midPointY - 5, 17, 12);
		scroller = new ScrollHandler(midPointY + 66);
		this.midPointY = midPointY;
		this.floorLevel = (this.midPointY * 2) - 15;
	}
	
	public void update(float delta) {
        //System.out.println("fps: "+1/delta);
        bird.update(delta);
        scroller.update(delta);
        
        if(bird.getY() > floorLevel) {
        	bird.setY(floorLevel);
        }
    }
	
	public Bird getBird() {
		return bird;
	}
	
	public ScrollHandler getScroller() {
        return scroller;
    }
}
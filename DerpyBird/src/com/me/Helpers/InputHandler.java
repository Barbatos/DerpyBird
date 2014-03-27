package com.me.Helpers;

import com.badlogic.gdx.InputProcessor;
import com.me.GameObjects.Bird;
import com.me.Screens.GameScreen;

public class InputHandler implements InputProcessor {
	
	private Bird bird;
	private GameScreen screen;
	private boolean stopped;
	
	public InputHandler(Bird _bird, GameScreen _screen) {
		this.bird = _bird;
		this.stopped = false;
		this.screen = _screen;
	}
	
	public void stop() {
		this.stopped = true;
	}
	
	public void start() {
		this.stopped = false;
	}
	
	@Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(!stopped) {
			bird.onClick();
		}
		else {
			screen.onClick(screenX, screenY);
		}
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}

package com.me.Helpers;

import com.badlogic.gdx.InputProcessor;
import com.me.GameObjects.Bird;

public class InputHandler implements InputProcessor {
	
	private Bird bird;
	private boolean stopped;
	
	public InputHandler(Bird _bird) {
		this.bird = _bird;
		this.stopped = false;
	}
	
	public void stop() {
		this.stopped = true;
	}
	
	@Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(!stopped) {
			bird.onClick();
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

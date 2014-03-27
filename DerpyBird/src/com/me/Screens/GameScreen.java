package com.me.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.me.GameRenderer.GameRenderer;
import com.me.GameWorld.GameWorld;
import com.me.Helpers.InputHandler;

public class GameScreen implements Screen {
    
	private GameWorld world;
	private GameRenderer renderer;
	private InputHandler input;
	private float runTime = 0;
	
    public GameScreen() {
    	startGame();
    }
    
    public void startGame() {
    	float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        
        // We set a fixed width for the game, so the height
        // will be different depending on the device we use.
        // We need to calculate it.
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        
        // Find the middle point of the screen height.
        int midPointY = (int) (gameHeight / 2);
        
    	world = new GameWorld(midPointY); 
    	renderer = new GameRenderer(world, (int)gameHeight, midPointY); 
    	input = new InputHandler(world.getBird(), this);
    	
    	Gdx.input.setInputProcessor(input);
    	
        System.out.println("GameScreen Attached");
    }
    
    public void onClick(int x, int y) {
		if(!world.isPaused()) {
			return;
		}
		
		// @TODO FIXME AAAAAARGH
		if( (x >= 105) && (x <= (105 + 55)) && (y >= 200) && (y <= 234)) {
			startGame();
		}
	}
    
    @Override
    public void render(float delta) {
    	this.runTime += delta;
    	world.update(delta);
        renderer.render(runTime);
        
        if(world.isPaused()) {
        	input.stop();
        	renderer.setPaused(true);
        }
    }

    @Override
    public void resize(int width, int height) {
        System.out.println("GameScreen - resizing");
    }

    @Override
    public void show() {
        System.out.println("GameScreen - show called");
    }

    @Override
    public void hide() {
        System.out.println("GameScreen - hide called");     
    }

    @Override
    public void pause() {
        System.out.println("GameScreen - pause called");        
    }

    @Override
    public void resume() {
        System.out.println("GameScreen - resume called");       
    }

    @Override
    public void dispose() {
        // Leave blank
    }

}
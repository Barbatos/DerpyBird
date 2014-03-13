package com.me.GameRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.me.GameWorld.GameWorld;

public class GameRenderer {
	
	private GameWorld world;
	private OrthographicCamera camera;
	private ShapeRenderer shapeRenderer;
	
	public GameRenderer(GameWorld _world) {
        world = _world;
        
        camera = new OrthographicCamera();
        camera.setToOrtho(true, 136, 204);
        
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
    }
	
	public void render() {
 
        // Draw a black background to prevent flickering.
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        // TODO
    }
}

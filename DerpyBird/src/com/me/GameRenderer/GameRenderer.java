package com.me.GameRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.me.GameObjects.Bird;
import com.me.GameObjects.Grass;
import com.me.GameObjects.Pipe;
import com.me.GameObjects.ScrollHandler;
import com.me.GameWorld.GameWorld;
import com.me.Helpers.AssetsLoader;

public class GameRenderer {
	
	private GameWorld world;
	private OrthographicCamera camera;
	private ShapeRenderer shapeRenderer;
	private SpriteBatch batch;
	
	private int midPointY;
    private int gameHeight;
    
    private Bird bird;
    private ScrollHandler scroller;
    private Grass frontGrass, backGrass;
    private Pipe pipe1, pipe2, pipe3;
    
    private TextureRegion background, grass;
    private Animation birdAnimation;
    private TextureRegion birdMid, birdDown, birdUp;
    private TextureRegion skullUp, skullDown, bar;
    
	public GameRenderer(GameWorld _world, int gameHeight, int midPointY) {
        world = _world;
        
        this.gameHeight = gameHeight;
        this.midPointY = midPointY;
        
        camera = new OrthographicCamera();
        camera.setToOrtho(true, 136, 204);
        
        batch = new SpriteBatch();
        batch.setProjectionMatrix(camera.combined);
        
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
        
        bird = world.getBird();
        
        initGameObjects();
        initAssets();
    }
	
	public void initGameObjects() {
		bird = world.getBird();
		scroller = world.getScroller();
        frontGrass = scroller.getFrontGrass();
        backGrass = scroller.getBackGrass();
        pipe1 = scroller.getPipe1();
        pipe2 = scroller.getPipe2();
        pipe3 = scroller.getPipe3();
	}
	
	public void initAssets() {
		background = AssetsLoader.bg;
		grass = AssetsLoader.grass;
        birdAnimation = AssetsLoader.birdAnimation;
        birdMid = AssetsLoader.bird;
        birdDown = AssetsLoader.birdDown;
        birdUp = AssetsLoader.birdUp;
        skullUp = AssetsLoader.skullUp;
        skullDown = AssetsLoader.skullDown;
        bar = AssetsLoader.bar;
	}
	
	private void drawGrass() {
        // Draw the grass
		batch.draw(grass, frontGrass.getX(), frontGrass.getY(),
                frontGrass.getWidth(), frontGrass.getHeight());
		batch.draw(grass, backGrass.getX(), backGrass.getY(),
                backGrass.getWidth(), backGrass.getHeight());
    }

    private void drawSkulls() {
        // Temporary code! Sorry about the mess :)
        // We will fix this when we finish the Pipe class.

    	batch.draw(skullUp, pipe1.getX() - 1,
                pipe1.getY() + pipe1.getHeight() - 14, 24, 14);
        batch.draw(skullDown, pipe1.getX() - 1,
                pipe1.getY() + pipe1.getHeight() + 45, 24, 14);

        batch.draw(skullUp, pipe2.getX() - 1,
                pipe2.getY() + pipe2.getHeight() - 14, 24, 14);
        batch.draw(skullDown, pipe2.getX() - 1,
                pipe2.getY() + pipe2.getHeight() + 45, 24, 14);

        batch.draw(skullUp, pipe3.getX() - 1,
                pipe3.getY() + pipe3.getHeight() - 14, 24, 14);
        batch.draw(skullDown, pipe3.getX() - 1,
                pipe3.getY() + pipe3.getHeight() + 45, 24, 14);
    }

    private void drawPipes() {
        // Temporary code! Sorry about the mess :)
        // We will fix this when we finish the Pipe class.
        batch.draw(bar, pipe1.getX(), pipe1.getY(), pipe1.getWidth(),
                pipe1.getHeight());
        batch.draw(bar, pipe1.getX(), pipe1.getY() + pipe1.getHeight() + 45,
                pipe1.getWidth(), midPointY + 66 - (pipe1.getHeight() + 45));

        batch.draw(bar, pipe2.getX(), pipe2.getY(), pipe2.getWidth(),
                pipe2.getHeight());
        batch.draw(bar, pipe2.getX(), pipe2.getY() + pipe2.getHeight() + 45,
                pipe2.getWidth(), midPointY + 66 - (pipe2.getHeight() + 45));

        batch.draw(bar, pipe3.getX(), pipe3.getY(), pipe3.getWidth(),
                pipe3.getHeight());
        batch.draw(bar, pipe3.getX(), pipe3.getY() + pipe3.getHeight() + 45,
                pipe3.getWidth(), midPointY + 66 - (pipe3.getHeight() + 45));
    }

	public void render(float runTime) {

        // Fill the entire screen with black, to prevent potential flickering.
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        // Begin ShapeRenderer
        shapeRenderer.begin(ShapeType.Filled);
        
        // Draw Background color
        shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
        shapeRenderer.rect(0, 0, 136, midPointY + 66);

        // Draw Grass
        shapeRenderer.setColor(111 / 255.0f, 186 / 255.0f, 45 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 66, 136, 11);

        // Draw Dirt
        shapeRenderer.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 77, 136, 52);
        
        // End ShapeRenderer
        shapeRenderer.end();

        // Begin SpriteBatch
        batch.begin();
        
        // Disable transparency 
        // This is good for performance when drawing images that do not require
        // transparency.
        batch.disableBlending();
        batch.draw(this.background, 0, midPointY + 23, 136, 43);

        // The bird needs transparency, so we enable that again.
        batch.enableBlending();
        
        // 1. Draw Grass
        drawGrass();

        // 2. Draw Pipes
        drawPipes();
        batch.enableBlending();

        // 3. Draw Skulls (requires transparency)
        drawSkulls();

        if(bird.isMoving()) {
        	// Draw bird at its coordinates. Retrieve the Animation object from AssetsLoader
            // Pass in the runTime variable to get the current frame.
            batch.draw(this.birdAnimation.getKeyFrame(runTime),
                    bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight());
        }
        
        if (bird.shouldNotFlap()) {
            batch.draw(this.birdMid, bird.getX(), bird.getY(),
                    bird.getWidth() / 2.0f, bird.getHeight() / 2.0f,
                    bird.getWidth(), bird.getHeight(), 1, 1, bird.getRotation());

        } else {
            batch.draw(this.birdAnimation.getKeyFrame(runTime), bird.getX(),
                    bird.getY(), bird.getWidth() / 2.0f,
                    bird.getHeight() / 2.0f, bird.getWidth(), bird.getHeight(),
                    1, 1, bird.getRotation());
        }
        
        // End SpriteBatch
        batch.end();
    }
}

package com.me.GameObjects;

import com.me.GameObjects.Pipe;

public class ScrollHandler {

    private Grass frontGrass, backGrass;
    private Pipe pipe1, pipe2, pipe3;

    // ScrollHandler will use the constants below to determine
    // how fast we need to scroll and also determine
    // the size of the gap between each pair of pipes.

    public static final float SCROLL_SPEED = -59;
    public static final int PIPE_GAP = 51;

    public ScrollHandler(float yPos) {
    	frontGrass = new Grass(0, yPos, 143, 11, SCROLL_SPEED);
        backGrass = new Grass(frontGrass.getTailX(), yPos, 143, 11,
                SCROLL_SPEED);

        pipe1 = new Pipe((float)210, (float)0, 22, 60, SCROLL_SPEED, yPos);
        pipe2 = new Pipe((float)(pipe1.getTailX() + PIPE_GAP), 0, 22, 70, SCROLL_SPEED, yPos);
        pipe3 = new Pipe((float)(pipe2.getTailX() + PIPE_GAP), 0, 22, 60, SCROLL_SPEED, yPos);
    }
    
    public void update(float delta) {
    	// Update our objects
        frontGrass.update(delta);
        backGrass.update(delta);
        movingPipe(pipe1, delta);
        movingPipe(pipe2, delta);
        movingPipe(pipe3, delta);

        // Check if any of the pipes are scrolled left,
        // and reset accordingly
        if (pipe1.isScrolledLeft()) {
            pipe1.reset(pipe3.getTailX() + PIPE_GAP);
        } else if (pipe2.isScrolledLeft()) {
            pipe2.reset(pipe1.getTailX() + PIPE_GAP);

        } else if (pipe3.isScrolledLeft()) {
            pipe3.reset(pipe2.getTailX() + PIPE_GAP);
        }

        // Same with grass
        if (frontGrass.isScrolledLeft()) {
            frontGrass.reset(backGrass.getTailX());

        } else if (backGrass.isScrolledLeft()) {
            backGrass.reset(frontGrass.getTailX());

        }
    }

    public void stop() {
        frontGrass.stop();
        backGrass.stop();
        pipe1.stop();
        pipe2.stop();
        pipe3.stop();   
    }

    public boolean collides(Bird bird) {
	   return (pipe1.collides(bird) || pipe2.collides(bird) || pipe3.collides(bird));
	}
    
    public Grass getFrontGrass() {
        return frontGrass;
    }

    public Grass getBackGrass() {
        return backGrass;
    }

    public Pipe getPipe1() {
        return pipe1;
    }

    public Pipe getPipe2() {
        return pipe2;
    }

    public Pipe getPipe3() {
        return pipe3;
    }

    public void movingPipe(Pipe p, float delta){
        int rand = (int) (Math.random()*30);
        if (rand == 0){
            int rand2 = (int) (Math.random()*2);
            if(rand2 == 0){
                p.height += 5;              
            }
            else{
                p.height -= 5;              
            }
            p.update(delta);    
        }
        else{
            p.update(delta);
        }
    }
}

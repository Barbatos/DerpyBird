package com.me.GameObjects;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Bird {
	private Vector2 position;
	private Vector2 velocity;
	private Vector2 acceleration;

	private float rotation; 
	private int width;
	private int height;
	private int rand=1;
	
	private boolean moving;
	
	private Circle boundingCircle;
	
	 public Bird(float x, float y, int width, int height) {
        this.width = width;
        this.height = height;
        this.position = new Vector2(x, y);
        this.velocity = new Vector2(0, 0);
        this.acceleration = new Vector2(0, 460);
        this.boundingCircle = new Circle();
    }
	 
	 public void update(float delta) {

        velocity.add(acceleration.cpy().scl(delta));

        if (velocity.y > 200) {
            velocity.y = 200;
        }

        position.add(velocity.cpy().scl(delta));
        
        boundingCircle.set(position.x + 9, position.y + 6, 6.7f); 
        
        // Rotate counterclockwise
        if (velocity.y < 0) {
            rotation -= 600 * delta;

            if (rotation < -90) {
                rotation = -90;
            }
        }

        // Rotate clockwise
        if (isFalling()) {
            rotation += 480 * delta;
            if (rotation > 90) {
                rotation = 90;
            }

        }
    }

    public void onClick() {
    	
    	while(rand < 80){
    	 rand = (int) (Math.random()*180);}
    	System.out.println(rand);
        velocity.y = -(rand);
        moving = true;
        rand = 1;
    }
    
    public boolean isFalling() {
        return velocity.y > 110;
    }

    public boolean shouldNotFlap() {
        return velocity.y > 70;
    }
    
    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getRotation() {
        return rotation;
    }
    
    public void setY(float _y) {
    	position.y = _y;
    	moving = false;
    }
    
    public boolean isMoving() {
    	return moving;
    }
    
    public Circle getBoundingCircle() {
    	return boundingCircle;
    }
}

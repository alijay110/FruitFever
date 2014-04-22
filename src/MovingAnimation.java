
/**
 *	MovingAnimation - This class extends Animation, allowing basic moving functionality.
 *
 * @Author Micah Stairs
 *
 **/

import acm.graphics.*;
import java.awt.*;

public class MovingAnimation extends Animation{

	/** Private instance variables **/
	public int xSpeed, ySpeed;

	public MovingAnimation(int x, int y, GImage[] originalImages, boolean reverse, int delay, boolean repeat, int xSpeed, int ySpeed){
		super(x, y, originalImages, reverse, delay, repeat);
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}
	
	// Overrides Animation.animate()
	public void animate(){
		
		moveIt(xSpeed, ySpeed);
		super.animate();
		
	}

	public void moveIt(int xChange, int yChange){
		currentImage.move(xChange, yChange);
	}

}
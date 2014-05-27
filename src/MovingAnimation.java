
/**
 *	MovingAnimation - This class extends Animation, allowing basic moving functionality.
 *
 * @Author Micah Stairs
 *
 **/

import acm.graphics.*;
import java.awt.*;

public class MovingAnimation extends Animation {

	/** Public instance variables **/
	public double xSpeed, ySpeed, xLeftover, yLeftover;

	public MovingAnimation(int x, int y, GImage[] originalImages, boolean reverse, int delay, boolean repeat, double xSpeed, double ySpeed, int type) {
		super(x, y, originalImages, reverse, delay, repeat, type);
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}
	
	public MovingAnimation(int x, int y, GImage[] originalImages, boolean reverse, int delay, boolean repeat, int type) {
		super(x, y, originalImages, reverse, delay, repeat, type);
	}
	
	// Overrides Animation.animate()
	@Override public void animate() {
	
		// Move the image
		moveIt(xSpeed, ySpeed);
		super.animate();
		
		// Move the underlying Rectangle
		setLocation(x, y);
		
	}

	public void moveIt(int xChange, int yChange) {
		imageX += xChange;
		imageY += yChange;
	}
	
	/** Overloaded method add double precision to the object's speed **/
	public void moveIt(double xChange, double yChange) {
		moveIt((int) xChange, (int) yChange);
		
		/** Calculate then check to see if the leftover amounts to at least 1 **/
		
		xLeftover += xChange - (int) xChange;
		
		if (xLeftover >= 1.0){
			imageX++;
			xLeftover--;
		}
		
		yLeftover += yChange - (int) yChange;
		
		if (yLeftover >= 1.0){
			imageY++;
			yLeftover--;
		}
		
	}

}

/**
 *
 *	Button - This class provides the functionality to have a clickable button, with different images for each mode.
 *
 *	@Author Micah Stairs
 *
 *	NOTE: It is assumed that all 3 button images have identical dimensions.
 *
 **/

import acm.graphics.*;
import java.awt.*;

public class Button extends Thing {

	public GImage defaultImage, hoverImage, clickImage;
	public Type type;
	public boolean active = true;
	
	public GImage bar; // Only used for SLIDER button
	public int level; // Only used for LEVEL_BOXES button
	
	public enum Type {
		PLAY,
		CONTROLS,
		OPTIONS,
		MULTIPLAYER,
		LEFT_ARROW,
		RIGHT_ARROW,
		LEVEL_BOXES,
		GEAR,
		REFRESH,
		SLIDER;
	};

	public Button(int x, int y, Type type, GImage defaultImg, GImage hoverImg, GImage clickImg) {
	
		super(x, y, (int) defaultImg.getWidth(), (int) defaultImg.getHeight(), new GImage(defaultImg.getImage()));
		
		// Sets the position of the button images
		animate();
		
		this.type = type;
		this.defaultImage = new GImage(defaultImg.getImage());
		this.hoverImage = new GImage(hoverImg.getImage());
		this.clickImage = new GImage(clickImg.getImage());
	
	}
	
	/** Used for LEVEL_BOXES button **/
	public Button(int x, int y, GImage defaultImg, GImage hoverImg, GImage clickImg, int level) {
		this(x, y, Type.LEVEL_BOXES, defaultImg, hoverImg, clickImg);
		this.level = level;
	}
	
	/** Used for SLIDER button **/
	public Button(int x, int y, GImage defaultImg, GImage hoverImg, GImage clickImg, GImage bar) {
		this(x, y, Type.SLIDER, defaultImg, hoverImg, clickImg);
		this.bar = new GImage(bar.getImage());
		this.bar.setLocation(x, y);
	}

/** Checks to see if the given coordinates are on the button **/
	public boolean checkOverlap(int xPos, int yPos) {
		return contains(xPos, yPos);
	}
	
	public void setDefault() {
		image.setImage(defaultImage.getImage());
	}
	
	public void setHover() {
		image.setImage(hoverImage.getImage());
	}
	
	public void setClick() {
		image.setImage(clickImage.getImage());
	}
	
}
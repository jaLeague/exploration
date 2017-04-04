import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class PlayerGameObject {
	int x;
	int y;
	int width;
	int height;
	boolean isAlive = true;
	private int originalY = 0;
	private BufferedImage playerImage;
	private boolean isJumping = false;
	private int gravity = 3;

	Rectangle collisionBox;
	
	PlayerGameObject (int gX, int gY, int gWidth, int gHeight) {
		x=gX;
		y=gY;
		originalY = y;
		width=gWidth;
		height=gHeight;
		
	try {
			playerImage = ImageIO.read(getClass().getResource("cherries.png"));
			width = playerImage.getWidth();
			height = playerImage.getHeight();
		} catch (Exception e) {
			System.out.println("get image failed");
		}

		collisionBox = new Rectangle(x, y, width, height);
	}
	
	void update() {
		collisionBox.setBounds(x, y, width, height);
	}
	
	Rectangle getPlayerBottom() {
		return new Rectangle(
				(int) this.collisionBox.getX(),
				(int) this.collisionBox.getY()+height-1,
				(int) this.collisionBox.getWidth(),
				1);
				
	}
	
	void draw(Graphics graphics) {
		update();
		graphics.drawImage(playerImage, x, y, width, height, null);
		graphics.drawRect(
				(int) this.collisionBox.getX(),
				(int) this.collisionBox.getY()+height-1,
				(int) this.collisionBox.getWidth(),
				1);
	}
	
	void die() {
		isAlive = false;
	}
	
	void notJumping() {
		isJumping = false;
	}

	void applyGravity() {
		if (isJumping) {
			if (y >= originalY) {
				y = originalY;
				isJumping = false;
			}
			else {
				y = y + gravity;
			}
		}
	}
	void jump(int howHigh) {
		isJumping = true;
		if (y > howHigh) {
		y = y - howHigh;}
		else {y = 0;}
	}
	boolean isJumping() {
		return isJumping;
	}
	boolean isAlive() {
		return isAlive;
	}
}

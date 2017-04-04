import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PlatformGameObject {
	int x;
	private int originalY;
	int y;
	int width;
	int height;
	Rectangle collisionBox;

	PlatformGameObject (int gX, int gY, int gWidth, int gHeight) {
		x=gX;
		y=gY;
		originalY = y;
		width=gWidth;
		height=gHeight;
		collisionBox = new Rectangle(x, y, width, 1);
	}
	void update() {
		collisionBox.setBounds(x, y, width, 1);
	}
	
	Rectangle getPlatformTop() {
		return new Rectangle(
				(int) this.collisionBox.getX(),
				(int) this.collisionBox.getY(),
				(int) this.collisionBox.getWidth(),
				1);
				
	}
	
	void draw(Graphics graphics) {
		update();
		graphics.setColor(Color.black);
		graphics.fillRect(x, y, width, height);
		graphics.drawRect(x, y, width, height);
		graphics.drawRect(
				(int) this.collisionBox.getX(),
				(int) this.collisionBox.getY(),
				(int) this.collisionBox.getWidth(),
				1);
	}
	
	void scroll(int howFar) {
		if (y <= 0) {
			y = originalY;
		}
		else {
			y -= howFar;
		}
	}
	
}

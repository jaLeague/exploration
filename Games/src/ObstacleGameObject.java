import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class ObstacleGameObject {
	int x;
	private int originalX;
	int y;
	int width;
	int height;
	Rectangle collisionBox;

	ObstacleGameObject (int gX, int gY, int gWidth, int gHeight) {
		x=gX;
		originalX = x;
		y=gY;
		width=gWidth;
		height=gHeight;
		collisionBox = new Rectangle(x, y, width, height);

	}
	void update() {
		collisionBox.setBounds(x, y, width, height);
	}
	
	void draw(Graphics graphics) {
		update();
		graphics.setColor(Color.black);
		graphics.fillRect(x, y, width, height);
		graphics.drawRect(x, y, width, height);
	}
	
	void scroll(int howFar) {
		if (x <= 0) {
			x = originalX;
		}
		else {
			x -= howFar;
		}
	}
	
}

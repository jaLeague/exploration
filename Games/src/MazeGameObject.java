import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class MazeGameObject {
	int x;
	int y;
	int width;
	int height;
	private BufferedImage mazeImage;

	Rectangle collisionBox;

	MazeGameObject(BufferedImage mazeImage, int gX, int gY) {
		x = gX;
		y = gY;
		width = mazeImage.getWidth();
		height = mazeImage.getHeight();
		collisionBox = new Rectangle(x, y, width, height);
	}

	void update() {
		collisionBox.setBounds(x, y, width, height);
	}

	void draw(Graphics graphics, BufferedImage mazeImage) {
		graphics.setColor(Color.CYAN);
		graphics.drawImage(mazeImage, x, y, width, height, null);
	}
}

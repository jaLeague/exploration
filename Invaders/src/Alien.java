import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Alien extends GameObject {

	Alien(int aX, int aY, int aWidth, int aHeight) {
		super(aX,aY,aWidth,aHeight);
	}
	void update() {
		super.update();
		int xMove = new Random().nextInt(9);
		if (xMove >4) {x = x-xMove;}
		else {
			x = x + xMove;
		}
		y ++;

	}
	
	void draw(Graphics graphics) {
		graphics.setColor(Color.YELLOW);
		graphics.fillRect(x, y, width, height);
	}
}

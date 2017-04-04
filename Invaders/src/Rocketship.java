import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	int rocketSpeed;
	Rocketship (int rocketX, int rocketY, int rocketW, int rocketH) {
		super(rocketX,rocketY,rocketW,rocketH);
		rocketSpeed = 10;
	}
	void update() {
		super.update();
	}
	
	void draw(Graphics graphics) {
		graphics.setColor(Color.RED);
		graphics.fillRect(x, y, width, height);
	}
}

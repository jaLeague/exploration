import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {

	int projSpeed = 10;

	
	Projectile(int pX, int pY, int pHeight, int pWidth) {
		super(pX,pY,pHeight,pWidth);
	}
	void update() {
		super.update();
		y -= projSpeed;
		if (y<0) {isAlive=false;}
	}
	
	void draw(Graphics graphics) {
		graphics.setColor(Color.BLUE);
		graphics.fillRect(x, y, width, height);
	}
}

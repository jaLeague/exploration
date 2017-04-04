import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PlatformGamePanel extends JPanel implements KeyListener, ActionListener {

	private static final int SCROLL_SPEED = 2;

	private BufferedImage bgImage;
	private int IMAGE_HEIGHT = 0;

	private int frameWidth = 0;
	private int frameHeight = 0;
	
	private int platformWidth = 100;
	private int platformHeight = 30;
	
	private int y1 = 0;
	private int y2;
	
	private Random random = new Random();
	
	private PlayerGameObject player;
	private PlatformGameObject platform; 
	
	PlatformGamePanel(String filename, int fw, int fh) {
		super();
		try {
			bgImage = ImageIO.read(getClass().getResource(filename));
			IMAGE_HEIGHT = bgImage.getHeight();
		} catch (Exception e) {

		}
		frameWidth = PlatformGame.frameWidth;
		frameHeight = PlatformGame.frameHeight;
		initImagePoints();
		player = new  PlayerGameObject(frameWidth/2, frameHeight-50, 50	, 50);
		platform = getNewPlatform();		
		Timer timer = new Timer(40, this);
		timer.start();
	}
	
	public void actionPerformed(ActionEvent e) {
		//collisionCheck();
		moveBackground();
		movePlatforms();
		//playerGravityCheck();
		repaint();
	}

	public void paintComponent(Graphics g) {
		//if (player.isAlive) {
		//super.paintComponent(g);

		g.drawImage(bgImage, 0, 0, frameWidth, frameHeight, 0, y1, frameWidth, y2, this);
		platform.draw(g);
		//player.draw(g);
	
		//}
		//else {
		//	drawEndState(g);
		//}
	}

	
	void platformLandCheck() {
		if (player.getPlayerBottom().intersects(platform.getPlatformTop())) {
			player.notJumping();
		}
	}
	
	void collisionCheck() {
		if (player.collisionBox.intersects(platform.collisionBox)) {
			player.die();
		}
	}
	
	void drawEndState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, frameWidth, frameHeight);
		g.setColor(Color.RED);
		g.drawString("GAME OVER", 10, 100);

	}
	
	private void initImagePoints() {
		//Initialize the points on the background where the frame will start
		y1 = 0;
		y2 = frameWidth;
	}

	private void moveBackground() {
		//Increment the x values of the source rectangle until it exceeds the right limits
		//Then start again from the left side of the image.
			if ((y1) >= IMAGE_HEIGHT - frameHeight) {
				y1 = 0;
				y2 = frameHeight;
			} else {
				y1 += SCROLL_SPEED;
				y2 += SCROLL_SPEED;
			}
		
	}
	private PlatformGameObject getNewPlatform() {
		int platformX = random.nextInt(frameWidth-platformWidth);
		int platformY = frameHeight;
		return (new PlatformGameObject(platformX,platformY,platformWidth,platformHeight));
	}
	private void movePlatform() {
		 platform.scroll(SCROLL_SPEED);
	}
	
	private void movePlatforms() {
		movePlatform();
	}
	
	private void playerGravityCheck() {
		player.applyGravity();
	}
	
	public Image getBgImage() {
		return bgImage;
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			//playerJump();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}
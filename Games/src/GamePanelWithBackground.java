import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanelWithBackground extends JPanel implements KeyListener, ActionListener {

	private static final int JUMP_HEIGHT = 100;
	private static final int SCROLL_SPEED = 10;

	private BufferedImage bgImage;
	private int IMAGE_WIDTH = 0;

	private int frameWidth = 0;
	private int frameHeight = 0;
	
	private int srcx1 = 0;
	private int srcx2 = frameWidth;
	
	private PlayerGameObject player;
	private ObstacleGameObject obstacle; 
	
	GamePanelWithBackground(String filename, int fw, int fh) {
		super();
		try {
			bgImage = ImageIO.read(getClass().getResource(filename));
			IMAGE_WIDTH = bgImage.getWidth();
		} catch (Exception e) {

		}
		frameWidth = fw;
		frameHeight = fh;
	
		initImagePoints();
		player = new  PlayerGameObject(frameWidth/2, frameHeight-50, 50	, 50);
		obstacle = new ObstacleGameObject(frameWidth,frameHeight-70,50,50);
		
		
		Timer timer = new Timer(40, this);
		timer.start();
	}
	
	public void actionPerformed(ActionEvent e) {
		collisionCheck();
		moveBackground();
		moveObstacles();
		playerGravityCheck();
		repaint();
	}

	public void paintComponent(Graphics g) {
		if (player.isAlive) {
		super.paintComponent(g);

		g.drawImage(bgImage, 0, 0, frameWidth, frameHeight, srcx1, 0, srcx2, frameHeight, this);
	
		player.draw(g);
		obstacle.draw(g);
		}
		else {
			drawEndState(g);
		}
	}

	
	void collisionCheck() {
		if (player.collisionBox.intersects(obstacle.collisionBox)) {
			player.die();
		}
	}
	
	void drawEndState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, frameWidth, frameHeight);
		g.setColor(Color.RED);
		g.drawString("GAME OVER", 10, 100);

	}
	
	private void playerJump() {
		player.jump(JUMP_HEIGHT);
	}
	
	private void initImagePoints() {
		//Initialize the points on the background where the frame will start
		srcx1 = 0;
		srcx2 = frameWidth;
	}

	private void moveBackground() {
		//Increment the x values of the source rectangle until it exceeds the right limits
		//Then start again from the left side of the image.
			if ((srcx1) >= IMAGE_WIDTH - frameWidth) {
				srcx1 = 0;
				srcx2 = frameWidth;
			} else {
				srcx1 += SCROLL_SPEED;
				srcx2 += SCROLL_SPEED;
			}
		
	}
	
	private void moveObstacles() {
		obstacle.scroll(SCROLL_SPEED);
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
			playerJump();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}
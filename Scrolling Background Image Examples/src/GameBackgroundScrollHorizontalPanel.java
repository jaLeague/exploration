import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameBackgroundScrollHorizontalPanel extends JPanel implements ActionListener {

	private int frameWidth = 0;
	private int frameHeight = 0;

	private BufferedImage backgroundImage;
	private int backgroundImageWidth = 0;

	private int scrollXleft = 0;
	private int scrollXright = 0;
	private int scrollSpeed = 10;

	GameBackgroundScrollHorizontalPanel(String filename, int width, int height) {
		try {
			backgroundImage = ImageIO.read(getClass().getResource(filename));
			backgroundImageWidth = backgroundImage.getWidth();
		} catch (Exception e) {
			System.out.println("Could not get background image.");
		}

		// These variables hold the size of the game window
		frameWidth = width;
		frameHeight = height;

		// Initialize the x values for the left and right sides of the scroll
		// area
		// This example starts at the left side of the background image
		scrollXleft = 0;
		scrollXright = frameWidth;

		// Start the game timer (refresh rate of the game)
		Timer timer = new Timer(40, this);
		timer.start();
	}

	public void paintComponent(Graphics g) {
		if (backgroundImage != null) {
			
			// Draw the part of the background image that is visible in the game window
			g.drawImage(backgroundImage, 0, 0, frameWidth, frameHeight, scrollXleft, 0, scrollXright, frameHeight,
					this);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (backgroundImage != null) {
			moveBackground();
			repaint();
		}
	}

	private void moveBackground() {

		// If the game window has reached the right edge of the background image
		// reset it to the left edge.....
		if ((scrollXleft) >= backgroundImageWidth - frameWidth) {
			scrollXleft = 0;
			scrollXright = frameWidth;
		} else {
			// .... otherwise, just scroll the game window to the right
			scrollXleft += scrollSpeed;
			scrollXright += scrollSpeed;
		}

	}
}
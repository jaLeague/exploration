import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameBackgroundScrollVerticalPanel extends JPanel implements ActionListener {

	private int frameWidth = 0;
	private int frameHeight = 0;

	private BufferedImage backgroundImage;
	private int backgroundImageHeight = 0;

	private int scrollYTop = 0;
	private int scrollYBottom = 0;
	private int scrollSpeed = 10;

	GameBackgroundScrollVerticalPanel(String filename, int width, int height) {
		try {
			backgroundImage = ImageIO.read(getClass().getResource(filename));
			backgroundImageHeight = backgroundImage.getHeight();
		} catch (Exception e) {
			System.out.println("Could not get background image.");
		}

		// These variables hold the size of the game window
		frameWidth = width;
		frameHeight = height;

		// Initialize the y values for the top and bottom of the scroll
		// area.
		// This example starts at the bottom of the background image
		scrollYTop = backgroundImageHeight - frameHeight;
		scrollYBottom = backgroundImageHeight;

		// Start the game timer (refresh rate of the game)
		Timer timer = new Timer(40, this);
		timer.start();
	}

	public void paintComponent(Graphics g) {
		if (backgroundImage != null) {
			
			// Draw the part of the background image that is visible in the game window		
			g.drawImage(backgroundImage, 0, 0, frameWidth, frameHeight, 0, scrollYTop, frameWidth, scrollYBottom,
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

		// If the game window has reached the top edge of the background image
		// reset it to the bottom.....
		if (scrollYTop <=0) {
			scrollYTop = backgroundImageHeight - frameHeight;
			scrollYBottom = backgroundImageHeight;
		} else {
			// .... otherwise, just scroll the game window down
			scrollYTop -= scrollSpeed;
			scrollYBottom -= scrollSpeed;
		}

	}
}
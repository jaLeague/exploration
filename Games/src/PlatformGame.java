import java.awt.Image;

import javax.swing.JFrame;

public class PlatformGame {
	JFrame frame = new JFrame();
	PlatformGamePanel panel;
	String bgImageFilename = "doodleBackground.png";
	public static int frameWidth = 400;
	public static int frameHeight = 600;
	
	
	public static void main(String[] args) {

		PlatformGame game;
		game = new PlatformGame();
		game.init();

	}

	void init() {
		frame.setSize(frameWidth, frameHeight);
		setBackground(bgImageFilename);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(panel);
		frame.add(panel);
		frame.setVisible(true);
	}

	void setBackground(String filename) {
			panel = new PlatformGamePanel(filename, frameWidth, frameHeight);
	}

}
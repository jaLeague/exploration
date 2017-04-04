import java.awt.Image;

import javax.swing.JFrame;

public class GameWithMovingBackground {
	JFrame frame = new JFrame();
	GamePanelWithBackground panel;
	String bgImageFilename = "CartoonSky.jpg";
	private static int frameWidth = 400;
	private static int frameHeight = 400;
	
	
	public static void main(String[] args) {

		GameWithMovingBackground game;
		game = new GameWithMovingBackground();

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
			panel = new GamePanelWithBackground(filename, frameWidth, frameHeight);
	}

}
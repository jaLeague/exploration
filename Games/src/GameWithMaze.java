import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class GameWithMaze {

	JFrame frame;
	GamePanelWithMaze panel;
	
	public GameWithMaze() {
		frame = new JFrame();
		panel = new GamePanelWithMaze();
		frame.addKeyListener(panel);
	}

	public static void main(String[] args) {
		GameWithMaze game;
		game = new GameWithMaze();

		game.init();

	}

	void init() {
		int mazeWidth = 400;
		int mazeHeight = 300;

		frame.setSize(mazeWidth, mazeHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setVisible(true);
	}
}

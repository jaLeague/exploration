import javax.swing.JButton;
import javax.swing.JFrame;

public class GameWithFlashingBackground {

	JFrame frame;
	static int gameWidth = 800;
	static int gameHeight = 500;

	ColorfulGamePanel panel;

	
	public GameWithFlashingBackground() {
		frame = new JFrame();
		panel = new ColorfulGamePanel();
	}

	public static void main(String[] args) {
		GameWithFlashingBackground game;
		game = new GameWithFlashingBackground();
		game.init();
	}

	void init() {
		frame.setSize(gameWidth, gameHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setVisible(true);
	}
}

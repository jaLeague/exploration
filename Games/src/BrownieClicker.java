import javax.swing.JFrame;

public class BrownieClicker {

	JFrame frame;
	static int gameWidth = 800;
	static int gameHeight = 500;

	BrownieClickerPanel panel;

	
	public BrownieClicker() {
		frame = new JFrame();

		frame.setSize(gameWidth, gameHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new BrownieClickerPanel();
		
		frame.add(panel);
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		BrownieClicker game;
		game = new BrownieClicker();
	}

}



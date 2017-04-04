import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame gameFrame;
	final static int WIDTH=500;
	final static int HEIGHT=500;
	GamePanel gamePanel;
	
public static void main(String[] args) {
	LeagueInvaders game = new LeagueInvaders();
}
LeagueInvaders() {
	gameFrame = new JFrame();
	gamePanel = new GamePanel();
	setup();
}
void setup() {
	gameFrame.add(gamePanel);
	gameFrame.setVisible(true);
	gameFrame.setSize(WIDTH, HEIGHT);
	gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	gameFrame.addKeyListener(gamePanel);
	gamePanel.startGame();
}
}

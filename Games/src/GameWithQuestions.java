import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class GameWithQuestions {
JFrame frame;
GamePanelWithQuestions panel;

public GameWithQuestions() {
	frame = new JFrame();
	panel = new GamePanelWithQuestions(frame);

}
public static void main(String[] args) {
	GameWithQuestions game;
	game = new GameWithQuestions();
}
}

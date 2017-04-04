import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JButton;

public class QuizQuestion {

	private BufferedImage questionImage;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	
	QuizQuestion(BufferedImage qi, String label1, String label2, String label3) {
		questionImage = qi;
		button1 = new JButton(label1);
		button2 = new JButton(label2);
		button3  = new JButton(label3);
	}

	public JButton getButton1 () {return button1;}
	public JButton getButton2 () {return button2;}	
	public JButton getButton3 () {return button3;}
	public BufferedImage getImage () {return questionImage;}
	
	void update() {
	
	}

	void draw(Graphics graphics) {
	}
	
}

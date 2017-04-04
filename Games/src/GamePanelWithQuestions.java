import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GamePanelWithQuestions extends JPanel implements KeyListener, MouseListener, ActionListener {

	boolean gameOver = false;

	QuestionManager questionManager = new QuestionManager();
	QuizQuestion currentQuestion;
	JFrame frame;

	public GamePanelWithQuestions(JFrame f) {
		frame = f;
		addQuestions();
		showQuestion();

		// Timer timer = new Timer(1000 / 60, this);
		// timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (!gameOver) {
			g.drawImage(currentQuestion.getImage(), 0, 0, this);
		} else {
			refreshFrame();
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
			
			//g.setFont(titleFont);
			g.setColor(Color.RED);
			g.drawString("GAME OVER", 10, 100);
			g.drawString(Integer.toString(questionManager.getScore()), 100, 100);

		}
		// draw the components of the UI here
	}

	private void addQuestions() {
		QuizQuestion question;
		try {
			BufferedImage i = ImageIO.read(getClass().getResource("maze.png"));
			question = new QuizQuestion(i, "Choice 1", "Choice 2", "Choice 3");

		} catch (Exception e) {
			System.out.println("image not found");
			question = new QuizQuestion(null, "Choice 1", "Choice 2", "Choice 3");
		}
		questionManager.addQuestion(question);
		try {
			BufferedImage i = ImageIO.read(getClass().getResource("CartoonSky.jpg"));
			question = new QuizQuestion(i, "Choice 4", "Choice 5", "Choice 6");
		} catch (Exception e) {
			System.out.println("image not found");
			question = new QuizQuestion(null, "Choice 00", "Choice 00", "Choice 00");
		}
		questionManager.addQuestion(question);
	}

	public void showQuestion() {
		this.removeAll();
		if (!gameOver) {
			currentQuestion = questionManager.nextQuestion();
			if (currentQuestion == null) {
				System.out.println("There are no questions");
			} else {
				currentQuestion.getButton1().addMouseListener(this);
				currentQuestion.getButton2().addMouseListener(this);
				currentQuestion.getButton3().addMouseListener(this);

				this.add(currentQuestion.getButton1());
				this.add(currentQuestion.getButton2());
				this.add(currentQuestion.getButton3());
			}
		}
		refreshFrame();
	}

	private void gameOver() {
		System.exit(0);

	}
	
	void refreshFrame() {
		frame.dispose();
		frame = new JFrame();
		frame.setSize(800, 800);
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.addKeyListener(this);

		frame.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// DO NOT USE THIS ONE

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// Check answer?

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == currentQuestion.getButton1()) {
			questionManager.increaseScore();
		} else if (e.getSource() == currentQuestion.getButton2()) {
			System.out.println("Button 2");
		} else if (e.getSource() == currentQuestion.getButton3()) {
			System.out.println("Button 3");
		}
		if (!questionManager.moreQuestions()) {
			gameOver = true;
		}
		showQuestion();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

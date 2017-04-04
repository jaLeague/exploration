import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ColorfulGamePanel extends JPanel implements ActionListener, MouseListener {
	
	Timer timer;
	int red, green, blue = 0;
	Color bgColor;
	int imageX, imageY = 0;
	private BufferedImage questionImage;
	boolean questionAdded = false;
	JButton button1;
	JButton button2;
	JButton button3;
	
	ColorfulGamePanel() {
		setLayout(null);
		addButtons();
		timer = new Timer(0, this);
		timer.setDelay(1000);
		timer.start();
	}
	
	private void addButtons() {

		int buttonHeight = 100;
		int buttonWidth = GameWithFlashingBackground.gameWidth/6;
		
		button1 = new JButton("x");
		button2 = new JButton("x");
		button3 = new JButton("x");
	
		button1.addMouseListener(this);
		button2.addMouseListener(this);
		button3.addMouseListener(this);
	
		button1.setBounds(GameWithFlashingBackground.gameWidth/6,
				GameWithFlashingBackground.gameHeight - buttonHeight,
				buttonWidth,
				buttonHeight);
		
		button2.setBounds(GameWithFlashingBackground.gameWidth/2 - buttonWidth/2,
				GameWithFlashingBackground.gameHeight - buttonHeight,
				buttonWidth,
				buttonHeight);

		button3.setBounds(GameWithFlashingBackground.gameWidth - buttonWidth*2,
				GameWithFlashingBackground.gameHeight - buttonHeight,
				buttonWidth,
				buttonHeight);

		add(button1);
		add(button2);
		add(button3);
	

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	public void paintComponent(Graphics g){
		
		 red = new Random().nextInt(255);
		 green = new Random().nextInt(255);
		 blue = new Random().nextInt(255);
		
		
		//flash the background
		bgColor = new Color(red, green, blue);
		g.setColor(bgColor);
		g.fillRect(0, 0, GameWithFlashingBackground.gameWidth, GameWithFlashingBackground.gameHeight);
		
		//draw the picture
		if (questionImage == null) {		getFirstQuestion(); }

		imageX = GameWithFlashingBackground.gameWidth/2 - questionImage.getWidth()/2;
		imageY =  GameWithFlashingBackground.gameHeight/2 - questionImage.getHeight()/2;	
		g.drawImage(questionImage, imageX, imageY, this);
	
		this.setVisible(true);
	}
	
	private void getFirstQuestion() {
		try {
			questionImage = ImageIO.read(getClass().getResource("record.jpg"));
		} catch (Exception e) {
			System.out.println("get record image failed");
		}
		button1.setText("Record 1");
		button2.setText("Record 2");
		button3.setText("Record 3");
		questionAdded = true;
	
	}
	private void getNextQuestion() {
		try {
			questionImage = ImageIO.read(getClass().getResource("cherries.png"));
		} catch (Exception e) {
			System.out.println("get cherry image failed");
		}
		button1.setText("Cherry 1");
		button2.setText("Cherry 2");
		button3.setText("Cherry 3");
		questionAdded = true;
	
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (e.getSource()==button1) {
			System.out.println("mouse clicked button1");
			getNextQuestion();
			repaint();
		}
		
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

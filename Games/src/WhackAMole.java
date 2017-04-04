import java.applet.AudioClip;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhackAMole implements MouseListener {

	int moleHits = 0;
	int moleMisses = 0;
	boolean userClickedButton = false;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
//	Image bgImage;
	Date timeAtStart = new Date();

	public static void main(String[] args) {
		WhackAMole b = new WhackAMole();

		b.initMoleHits();
		b.refreshFrame();
	}

	void setBackground(String filename) {
		try {
			panel = new JPanel();
		} catch (Exception e) {
			System.out.println("cannot find the background image");
		}
	}

	void refreshFrame(){
		frame.dispose();
		frame = new JFrame();
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	//	setBackground("cartoonSky.jpg");
		
		frame.add(panel);
		showButtons(panel, 30);
	}

	void addMoleHit() {
		moleHits += 1;
		playSound("r2d2-eureka.wav");
		if (moleHits >= 10) {
			endGame(timeAtStart, moleHits);
			System.exit(0);
		} else {
			refreshFrame();
		}

	}

	int getMoleHits() {
		return moleHits;
	}

	void initMoleHits() {
		moleHits = 0;
	}

	private void showButtons(JPanel quizPanel, int numButtons) {
		String buttonName = "  ";
		int random = new Random().nextInt(numButtons);
		JButton button;

		for (int i = 0; i < numButtons; i++) {
			button = new JButton(buttonName);
			if (i == random) {
/*				try {
					Image img = ImageIO.read(getClass().getResource("gamePiece.jpg"));
					button.setIcon(new ImageIcon(img));

				} catch (Exception ex) {
					System.out.println(ex);
				}
*/				button.setName("mole");
			} else {
				button.setName("not mole");
			}
			button.addMouseListener(this);
			quizPanel.add(button);

		}
		frame.add(quizPanel);
		frame.setVisible(true);
	}

	void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void playSound(String fileName) {
		try {
			AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
			sound.play();
		} catch (Exception e) {
			System.out.println("Cannot find audio clip");
		}
	}

	private void endGame(Date timeAtStart, int molesWhacked) {
		Date timeAtEnd = new Date();
		JOptionPane.showMessageDialog(null, "Your whack rate is "
				+ ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked) + " moles per second.");
		JOptionPane.showMessageDialog(null, "You missed " + moleMisses + " moles.");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		userClickedButton = true;
		String name = e.getComponent().getName();
		if (name.equals("mole")) {
			this.addMoleHit();
		} else {
			moleMisses += 1;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

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
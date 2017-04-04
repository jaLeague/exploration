import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BrownieClickerPanel extends JPanel implements  MouseListener {

	BrownieStoreManager manager = new BrownieStoreManager();
	BrownieStore store;
	int totalScore = 0;
	JButton brownieButton;
	
	
	BrownieClickerPanel() {
		setLayout(null);
		brownieButton = new JButton();
		brownieButton.setText("Brownie");
		brownieButton.setBounds(10,10,200,200);
		brownieButton.setBackground(new Color(147,91,34));  //Brown
		brownieButton.setOpaque(true);
		brownieButton.setBorderPainted(false);
		brownieButton.addMouseListener(this);
		this.add(brownieButton);
		addButtons();
	}

	private void addToTotal(int cookieCount) {
		totalScore += cookieCount;
	}
	
	private void addButtons() {
		// for all stores in store manager, add a JButton
		int buttonX,buttonY = 0;
		int buttonWidth=100;
		int buttonHeight= 50;
		JButton button;
		int buttonSpacing = 20;
		
		store = manager.getNextStore();
		
		//For every store in the store manager, add a button to the right of the window
		buttonX = BrownieClicker.gameWidth - buttonWidth - 10;
	
		while (store != null) {
			//Make a button for the store
			button = new JButton();
			button.setText(store.name);
			button.setBounds(buttonX,buttonY,buttonWidth,buttonHeight);
			button.setBackground(new Color(147,91,34));  //Brown
			button.setOpaque(true);
			button.setBorderPainted(false);
			button.addMouseListener(this);
			add(button);
			//Get the next store
			store = manager.getNextStore();
			buttonY = buttonY + buttonHeight + buttonSpacing;
		}
	}
	
	public void paintComponent(Graphics g){
		//background color
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, BrownieClicker.gameWidth, BrownieClicker.gameHeight);
		//total score tally
		g.setFont(new Font("Arial",Font.PLAIN,48));
		g.setColor(Color.YELLOW);	
		g.drawString("Total cookies: "+Integer.toString(totalScore), 200, 400);

		this.setVisible(true);
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton clicked = (JButton) e.getSource();
			if (clicked==brownieButton) {
				totalScore++ ;
			} else {
			 store = manager.getStoreWithName(clicked.getText());
			 totalScore += store.getCookies();
			}
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

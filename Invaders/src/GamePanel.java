import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	
	int currentState = MENU_STATE;
	Timer timer;
	GameObject gameObject;
	ObjectManager objectManager = new ObjectManager(); 
	Font titleFont;
	Rocketship ship = new Rocketship(LeagueInvaders.WIDTH/2,LeagueInvaders.HEIGHT-50,50,50);

	GamePanel() {
		timer = new Timer(1000/60,this);
		gameObject = new GameObject(0,0,0,0);
		titleFont = new Font("Arial",Font.PLAIN,48);
		objectManager.addObject(ship);
	}
	
	void startGame() {
		timer.start();
	}
	
	void updateMenuState() {}
	void updateEndState() {}
	void updateGameState() {
		objectManager.update();
		objectManager.manageEnemies();
		objectManager.checkCollision();
		if (!ship.isAlive) {
			currentState=END_STATE;
		}
	}
	void drawMenuState(Graphics g) {
		
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 10, 100);

	}
	void drawEndState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		
		g.setFont(titleFont);
		g.setColor(Color.RED);
		g.drawString("GAME OVER", 10, 100);

	}
	void drawGameState(Graphics g) {
		objectManager.draw(g);
	}
	
	public void paintComponent(Graphics g){
		if(currentState == MENU_STATE){
			drawMenuState(g);
		}else if(currentState == GAME_STATE){
			drawGameState(g);
		}else if(currentState == END_STATE){
			drawEndState(g);
		}

		gameObject.draw(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		
		if(currentState == MENU_STATE){
			updateMenuState();
		}else if(currentState == GAME_STATE){
			updateGameState();
		}else if(currentState == END_STATE){
			updateEndState();
		}
//		gameObject.update();
	}
	@Override
	public void keyTyped(KeyEvent e) {	}
	
	@Override
	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END_STATE){
				currentState = MENU_STATE;
			} else if (currentState == MENU_STATE){
				currentState = GAME_STATE;
			} else {currentState = END_STATE;}
		} 
		// move right arrow
		else if (e.getKeyCode()==KeyEvent.VK_RIGHT){
			if (ship.x <= (LeagueInvaders.WIDTH-ship.rocketSpeed - (ship.width))) {
			ship.x += ship.rocketSpeed;
			}
			else {ship.x = LeagueInvaders.WIDTH-ship.width;}
		} 
		// move left arrow
		else if (e.getKeyCode()==KeyEvent.VK_LEFT){
			if (ship.x >= ship.rocketSpeed) {
				ship.x -= ship.rocketSpeed;
			} else {ship.x = 0;}
		}
		//move up arrow
		else if (e.getKeyCode()==KeyEvent.VK_UP) {
			if (ship.y >= ship.rocketSpeed) {
				ship.y -= ship.rocketSpeed;
			} else {ship.y = 0;}
		}
		//move down arrow (VK_DOWN)
		else if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			if ((ship.y+ship.rocketSpeed) <= (LeagueInvaders.HEIGHT-(ship.height))) {
				ship.y += ship.rocketSpeed; 
			} else {ship.y = (LeagueInvaders.HEIGHT-(ship.height));}
		}
		//space bar fires projectiles
		else if (e.getKeyCode()==KeyEvent.VK_SPACE) {
			objectManager.addObject(new Projectile((ship.x+(ship.width/2)),ship.y+10,10,10));
		}
		updateGameState();
	}
	@Override
	public void keyReleased(KeyEvent e) {}

}

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
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanelWithMaze extends JPanel implements KeyListener, ActionListener {

	private MazeGameObject maze;
	private PlayerGameObject player;
	private int gameSpeed = 5;
	private BufferedImage mazeImage;
	private int mazeBgColor = Color.white.getRGB();

	public GamePanelWithMaze() {
		try {
			setMazeImage(ImageIO.read(getClass().getResource("maze.png")));
		} catch (Exception e) {
			System.out.println("get maze image failed");
		}

		setMaze(new MazeGameObject(getMazeImage(), 0, 0));
		setPlayer(new PlayerGameObject(10, 0, 20, 20));

		Timer timer = new Timer(1000 / 60, this);
		timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		getMaze().draw(g, getMazeImage());
		getPlayer().draw(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public int getMazeColor(int x, int y) {
		return (this.getMazeImage().getRGB(x, y));
	}

	public boolean playerCanMoveRight() {
		int newX, newY, color;
		newX = getPlayer().x + getPlayer().width + getGameSpeed();
		newY = getPlayer().y + (getPlayer().height / 2);
		if (newX > getMazeImage().getWidth()) {
			return false;
		}
		color = getMazeColor(newX, newY);

		if (color == getMazeBgColor()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean playerCanMoveLeft() {
		int newX, newY, color;
		newX = getPlayer().x - getGameSpeed();
		newY = getPlayer().y + (getPlayer().height / 2);
		if (newX < 0) {
			return false;
		}
		color = getMazeColor(newX, newY);

		if (color == getMazeBgColor()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean playerCanMoveUp() {
		int newX, newY, color;
		newY = getPlayer().y - getGameSpeed();
		if (newY <= 0) {
			return false;
		}
		newX = getPlayer().x + (getPlayer().width / 2);
		color = getMazeColor(newX, newY);
		if (color == getMazeBgColor()) {
			return true;
		} else {
			return false;
		}
	}
	public boolean playerCanMoveDown() {
		int newX, newY, color;
		newY = getPlayer().y + getPlayer().height + getGameSpeed();
		if (newY >= getMaze().height) {
			return false;
		}
		newX = getPlayer().x + (getPlayer().width / 2);
		color = getMazeColor(newX, newY);
		if (color == getMazeBgColor()) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (playerCanMoveRight()) {
				getPlayer().x += getGameSpeed();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (playerCanMoveLeft()) {
				getPlayer().x -= getGameSpeed();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (playerCanMoveUp()) {
				getPlayer().y -= getGameSpeed();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (playerCanMoveDown()) {
				getPlayer().y += getGameSpeed();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public int getMazeBgColor() {
		return mazeBgColor;
	}

	public void setMazeBgColor(int mazeBgColor) {
		this.mazeBgColor = mazeBgColor;
	}

	public BufferedImage getMazeImage() {
		return mazeImage;
	}

	public void setMazeImage(BufferedImage mazeImage) {
		this.mazeImage = mazeImage;
	}

	public int getGameSpeed() {
		return gameSpeed;
	}

	public void setGameSpeed(int gameSpeed) {
		this.gameSpeed = gameSpeed;
	}

	public PlayerGameObject getPlayer() {
		return player;
	}

	public void setPlayer(PlayerGameObject player) {
		this.player = player;
	}

	public MazeGameObject getMaze() {
		return maze;
	}

	public void setMaze(MazeGameObject maze) {
		this.maze = maze;
	}

}

	
	import javax.swing.JFrame;
	
	public class GameBackgroundScrollHorizontal {

		JFrame frame = new JFrame();
		GameBackgroundScrollHorizontalPanel panel;
		String imageFilename = "WideImage.png";
		
		//These variables set the dimensions of the visible area of game window
		private static int frameWidth = 800;
		private static int frameHeight = 600;
		
		public static void main(String[] args) {

			GameBackgroundScrollHorizontal game;
			game = new GameBackgroundScrollHorizontal();

			game.init();

		}

		void init() {
			frame.setSize(frameWidth, frameHeight);
			
			setBackground(imageFilename);
			frame.add(panel);
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}

		void setBackground(String filename) {
				panel = new GameBackgroundScrollHorizontalPanel(filename, frameWidth, frameHeight);
		}

	}


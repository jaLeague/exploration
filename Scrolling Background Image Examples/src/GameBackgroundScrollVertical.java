

	import javax.swing.JFrame;
	
	public class GameBackgroundScrollVertical {

		JFrame frame = new JFrame();
		GameBackgroundScrollVerticalPanel panel;
		String imageFilename = "TallImage.png";
		
		//These variables set the dimensions of the visible area of game window
		private static int frameWidth = 600;
		private static int frameHeight = 800;
		
		public static void main(String[] args) {

			GameBackgroundScrollVertical game;
			game = new GameBackgroundScrollVertical();

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
				panel = new GameBackgroundScrollVerticalPanel(filename, frameWidth, frameHeight);
		}

	}




import javax.swing.JFrame;
public class Mainclass {

	public static void main(String[] args) {
		
		MainMenu menu= new MainMenu("Frogger");
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    menu.setVisible(true);
	}

}

package aufgabe4;
/**
 * author: Sarah Ganter
 */
import javax.swing.JFrame;

public class TicTacToe {

	/*
	 * Hier wird ein Objekt von TicTacToeGUI erzeugt
	 */
	public static void main(String[] args) {
		TicTacToeGUI spiel=new TicTacToeGUI();
		spiel.setSize(300,300);
		spiel.setVisible(true);
		spiel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

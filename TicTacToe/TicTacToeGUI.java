package aufgabe4;

/**
 * author: Sarah Ganter
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TicTacToeGUI extends JFrame implements ActionListener {

	private JPanel panel1;
	private JPanel panel2;
	private JPanel textpanel;
	private JLabel reihenfolge;
	JButton[][] spielfeld = new JButton[3][3];
	boolean rotdran = true;
	boolean spielbeendet = false;
	boolean start = true;

	
	// Hier erstelle ich meine GUI und f�ge 3 verschiedene Panel hinzu
	public TicTacToeGUI() {
		super();
		setTitle("Tic Tac Toe");

		// Mein erstes Panel beinhaltet ein Label, auf dem der aktuelle Spieltext ausgegeben wird.
		textpanel = new JPanel();
		reihenfolge = new JLabel();
		textpanel.add(reihenfolge);
		reihenfolge.setForeground(Color.RED);
		reihenfolge.setText("Rot ist dran");
		add(textpanel, BorderLayout.NORTH);

		// Ich erzeuge ein zweites Panel, auf dem ich die Buttons (mit Hilfe eines Arrays) platziere.
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(3, 3));
		spielfeld = new JButton[3][3];
		add(panel1, BorderLayout.CENTER);
		
/*
 *  Ich bef�lle mein zweidimensionales Array mit Hilfe einer for-Schleife.
 *  Ich f�ge jeden Button direkt dem Panel hinzu
 *  und melde es am ActionListener an.
 */
		for (int i = 0; i < spielfeld.length; i++) {
			for (int j = 0; j < spielfeld.length; j++) {
				spielfeld[i][j] = new JButton();
				panel1.add(spielfeld[i][j]);
				spielfeld[i][j].addActionListener(this);

			}

		}
		// Das untere Panel beinhaltet zwei Buttons, die man vor Spielbeginn ausw�hlen kann.
		panel2 = new JPanel();
		JButton rot = new JButton("Rot beginnt");
		panel2.add(rot);
		rot.addActionListener(this);
		JButton schwarz = new JButton("Schwarz beginnt");
		panel2.add(schwarz);
		schwarz.addActionListener(this);
		add(panel2, BorderLayout.SOUTH);

	}

	/*
	 * Methode, die alle M�glichkeiten abfragt, nach denen Rot gewonnen haben kann,
	 * wenn gewonnen, gibt sie ein true zur�ck.
	 */
	public boolean rotgewonnen() {

		return (spielfeld[0][0].getText() == "x"
				&& spielfeld[1][0].getText() == "x"
				&& spielfeld[2][0].getText() == "x"
				|| spielfeld[0][0].getText() == "x"
				&& spielfeld[0][1].getText() == "x"
				&& spielfeld[0][2].getText() == "x"
				|| spielfeld[0][1].getText() == "x"
				&& spielfeld[1][1].getText() == "x"
				&& spielfeld[2][1].getText() == "x"
				|| spielfeld[0][2].getText() == "x"
				&& spielfeld[1][2].getText() == "x"
				&& spielfeld[2][2].getText() == "x"
				|| spielfeld[1][0].getText() == "x"
				&& spielfeld[1][1].getText() == "x"
				&& spielfeld[1][2].getText() == "x"
				|| spielfeld[2][0].getText() == "x"
				&& spielfeld[2][1].getText() == "x"
				&& spielfeld[2][2].getText() == "x"
				|| spielfeld[0][0].getText() == "x"
				&& spielfeld[1][1].getText() == "x"
				&& spielfeld[2][2].getText() == "x" || spielfeld[2][0]
				.getText() == "x"
				&& spielfeld[1][1].getText() == "x"
				&& spielfeld[0][2].getText() == "x");
	}

	/*
	 * Methode, die alle M�glichkeiten abfragt, nach denen Schwarz gewonnen haben kann,
	 * wenn gewonnen, gibt sie ein true zur�ck.
	 */
	public boolean schwarzgewonnen() {

		return (spielfeld[0][0].getText() == "o"
				&& spielfeld[1][0].getText() == "o"
				&& spielfeld[2][0].getText() == "o"
				|| spielfeld[0][0].getText() == "o"
				&& spielfeld[0][1].getText() == "o"
				&& spielfeld[0][2].getText() == "o"
				|| spielfeld[0][1].getText() == "o"
				&& spielfeld[1][1].getText() == "o"
				&& spielfeld[2][1].getText() == "o"
				|| spielfeld[0][2].getText() == "o"
				&& spielfeld[1][2].getText() == "o"
				&& spielfeld[2][2].getText() == "o"
				|| spielfeld[1][0].getText() == "o"
				&& spielfeld[1][1].getText() == "o"
				&& spielfeld[1][2].getText() == "o"
				|| spielfeld[2][0].getText() == "o"
				&& spielfeld[2][1].getText() == "o"
				&& spielfeld[2][2].getText() == "o"
				|| spielfeld[0][0].getText() == "o"
				&& spielfeld[1][1].getText() == "o"
				&& spielfeld[2][2].getText() == "o" || spielfeld[2][0]
				.getText() == "o"
				&& spielfeld[1][1].getText() == "o"
				&& spielfeld[0][2].getText() == "o");
	}

	
	/*
	 * Methode die pr�ft, ob ein Unentschieden vorliegt,
	 * wenn ja, gibt sie ein true zur�ck.
	 */
	public boolean unentschieden() {

		return (spielfeld[0][0].getText() == "o"
				^ spielfeld[0][0].getText() == "x"
				&& spielfeld[1][0].getText() == "o"
				^ spielfeld[1][0].getText() == "x"
				&& spielfeld[2][0].getText() == "o"
				^ spielfeld[2][0].getText() == "x"
				&& spielfeld[0][1].getText() == "o"
				^ spielfeld[0][1].getText() == "x"
				&& spielfeld[1][1].getText() == "o"
				^ spielfeld[1][1].getText() == "x"
				&& spielfeld[2][1].getText() == "o"
				^ spielfeld[2][1].getText() == "x"
				&& spielfeld[0][2].getText() == "o"
				^ spielfeld[0][2].getText() == "x"
				&& spielfeld[1][2].getText() == "o"
				^ spielfeld[1][2].getText() == "x" && spielfeld[2][2].getText() == "o"
				^ spielfeld[2][2].getText() == "x");
	}

	// Hier wird gepr�ft, ob es sich um einen Buttondruck handelt
	@Override
	public void actionPerformed(ActionEvent e) {
		Object quelle = e.getSource();
		if (quelle instanceof JButton) {
			String buttonText = ((JButton) quelle).getActionCommand();

			/*
			 * Wenn die Buttons "Rot/Schwarz beginnt" gedr�ckt werden
			 * und das Spiel noch nicht gestartet wurde,
			 * wird der jeweilige Text auf dem oberen Panel angezeigt
			 */
			if ((buttonText == "Rot beginnt" || buttonText == "Schwarz beginnt")
					&& start == true) {
				if (buttonText == "Rot beginnt") {
					reihenfolge.setText("Rot ist dran");
					reihenfolge.setForeground(Color.red);
					rotdran = true;
					start = false;
				}
				if (buttonText == "Schwarz beginnt") {
					reihenfolge.setText("Schwarz ist dran");
					reihenfolge.setForeground(Color.black);
					rotdran = false;
					start = false;
				}

				/*
				 * Wenn es sich um einen Spielfeld-Button handelt
				 * und das Spiel noch nicht beendet wurde,
				 * wechselt das Spiel zwischen den Mitspielern hin und her
				 * und gibt das jeweilge Spielzeichen ("x" und "o") auf dem Button aus.
				 */
			} else {
				if (buttonText == ("") && !spielbeendet) {
					if (rotdran == true) {
						((JButton) quelle).setForeground(Color.RED);
						((JButton) quelle).setText("x");

						reihenfolge.setText("Schwarz ist dran");
						reihenfolge.setForeground(Color.black);

						rotdran = false;
					} else {
						((JButton) quelle).setText("o");
						reihenfolge.setText("Rot ist dran");
						reihenfolge.setForeground(Color.red);
						rotdran = true;
					}

				}

			}
			/*
			 * Wenn das Spiel zu Ende ist, wird der jeweilige Text:
			 * gewonnen/unentschieden angezeigt.
			 * Alle Buttons werden inaktiv, Das Spiel ist nur �ber das ernuete Starten
			 * erneut spielbar.
			 */
			if (rotgewonnen()) {
				reihenfolge.setText("Rot hat gewonnen");
				reihenfolge.setForeground(Color.red);
				spielbeendet = true;
			} else if (schwarzgewonnen()) {
				reihenfolge.setText("Schwarz hat gewonnen");
				reihenfolge.setForeground(Color.black);
				spielbeendet = true;
			} else if (unentschieden() && !rotgewonnen() && !schwarzgewonnen()) {
				reihenfolge.setText("Unentschieden");
				reihenfolge.setForeground(Color.gray);
				spielbeendet = true;

			}

		}

	}
}

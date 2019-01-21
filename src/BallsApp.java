import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
import javax.swing.Timer;

public class BallsApp {

	private JFrame frm = new JFrame("Bouncing Balls");
//	private JPanel pnl = new JPanel();

	
	public BallsApp() {

		frm.setSize(600, 600);
		frm.setVisible(true);
		
		frm.addMouseListener (new MouseAdapter()
		{
			public void mousePressed(MouseEvent e) {
				int xPosition = e.getX();
				int yPosition = e.getY();
				
				Thread t = new Thread(new BallThread(xPosition, yPosition, frm));
				t.start();
			}
		});
		
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		
		BallsApp app = new BallsApp();
	}

}

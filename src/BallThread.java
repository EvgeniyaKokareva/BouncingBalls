import javax.swing.JFrame;
import javax.swing.JPanel;

class BallThread implements Runnable{

	private int xPosition, yPosition;
	public JFrame frm;
	
	BallThread(int x, int y, JFrame frm){
		this.xPosition = x;
		this.yPosition = y;
		this.frm = frm;
	}
	
	@Override
	public void run() {
		
		System.out.println(xPosition + ", " + yPosition);
		BallGUIComponent ball = new BallGUIComponent(xPosition, yPosition);
		frm.add(ball);
		frm.revalidate();
		//frm.repaint();
	}
}
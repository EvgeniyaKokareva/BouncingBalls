import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

class BallGUIComponent extends JPanel implements ActionListener {
		
	private int width = 50;
	private int hight = 50;
	private int x;
	private int y;
	Timer t = new Timer(3, this);
	Random random = new Random();
	private Color color;
	private int velX = random.nextInt(6)+1;
	private int velY = random.nextInt(6)+1;
	
	
	BallGUIComponent(int xPosition, int yPosition){
		
		this.x = xPosition;
		this.y = yPosition;
		this.color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
		
		this.setOpaque(false);
		
		t.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color); 
		Ellipse2D ball = new Ellipse2D.Double(x, y, width, hight);
		g2.fill(ball);
	}
	
	public void actionPerformed (ActionEvent e) {
		
		int maxXPosition = 580 - width;
		int maxYPosition = 550 - hight;
		
		if(x <= 0 || x >= maxXPosition) {
			velX = -velX;
			newSpeed();
		}
		
		if(y <= 0 || y >= maxYPosition) {
			velY = -velY;
			newSpeed();
		}
		
		x += velX;   
		y += velY;
		
		if (x < 0) {
			x = 0;
		}
		
		if (x > maxXPosition) {
			x = maxXPosition;
		}
		
		if (y < 0) {
			y = 0;
		}
		
		if (y > maxYPosition) {
			y = maxYPosition;
		}
		
		repaint();
	}
	
	public void newSpeed() {
		int direction = velX / Math.abs(velX);
		velX = (random.nextInt(6)+1) * direction;
		
		direction = velY / Math.abs(velY);
		velY = (random.nextInt(6)+1) * direction;
	}
}

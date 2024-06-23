import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class MyApplet extends Applet implements Runnable
{
	Thread th;
	Font f;
	int c;
	
	public void init()
	{
		th=new Thread(this);
		setBackground(Color.cyan);
		setForeground(Color.BLUE);
		f=new Font("Arial",Font.BOLD+Font.ITALIC,40);
		setFont(f);
		th.start();
	}
	
	public void run()
	{
		while(true)
		{
			c+=3;
			if(c>1300)
			{
				c=-250;
			}
			repaint();
			try
			{
				Thread.sleep(30);
			}
			catch(Exception e) { }
		}
	}

	public void paint(Graphics g)
	{
		g.drawString("COMPACT",c,200);
	}	
}

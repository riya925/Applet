import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Windmill extends Applet implements Runnable , ActionListener
{
	Thread th;
	int a;
	boolean bool;
	Button b1;
	
	public void init()
	{
		th=new Thread(this);
		setLayout(null);
		
		a=45;
		b1=new Button("START");
		b1.setBounds(750,400,120,60);
		
		b1.addActionListener(this);
		
		add(b1);
		bool=false;
		th.start();
	}
	
	public void run()
	{
		while(true)
		{
			if(bool)
			{
				a++;
				repaint();
			}
			try { Thread.sleep(100); }
			catch(Exception e) { }
		}
	}
	
	public void paint(Graphics g)
	{
		g.fillRect(400,600,300,40);
		g.fillRect(525, 350, 50, 250);
		
		g.setColor(Color.red);
		g.fillArc(400,200,300,300,a,30);
		
		g.setColor(Color.blue);
		g.fillArc(400,200,300,300,a+120,30);
		
		g.setColor(Color.green);
		g.fillArc(400,200,300,300,a+240,30);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String s=ae.getActionCommand();
		
		if(s.equals("START"))
		{
			bool=true;
			b1.setLabel("STOP");
		}
		else
		{
			bool=false;
			b1.setLabel("START");
		}
	}
}



import javax.swing.*;

@SuppressWarnings("serial")
public class ScoreFrame extends JFrame{
	public int width=660;
	public int height=600;
	
	public ScoreFrame(String title)
	{
		super(title);
		setSize(width,height);
		setLocationRelativeTo(null);
		ScorePanel s= new ScorePanel();
		s.setBounds(0,0,width,height);
		add(s);
	}
}


import javax.swing.*;

@SuppressWarnings("serial")
public class OptionWindow extends JFrame{

	public int width=660,height=600;
	
	public OptionWindow(String title)
	{
		super(title);
		setSize(width,height);
		setLocationRelativeTo(null);
		OptionPanel o= new OptionPanel();
		o.setBounds(0,0,width,height);
		add(o);
	}
}

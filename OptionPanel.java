import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class OptionPanel extends JPanel implements ActionListener{
	private JButton wasd,udlr,back;
	public static boolean LEFT=false;
	Icon w= new ImageIcon("images/wasd.png");
	Icon u= new ImageIcon("images/udlr.png");
	Icon b= new ImageIcon("images/back.png");
	public OptionPanel()
	{
		setLayout(null);
		JLabel scheme = new JLabel("CHOOSE CONTROL SCHEME", JLabel.CENTER);
        scheme.setBounds(0, 0, 600, 100);
        scheme.setLocation(640 / 2 - scheme.getWidth() / 2, 45);
        scheme.setForeground(new Color(251, 102, 8));
        add(scheme);
        wasd= new JButton(w);
        wasd.addActionListener(this);
        wasd.setBounds(0,0,200,95);
        wasd.setLocation(50,300);
        add(wasd);
        udlr= new JButton(u);
        udlr.addActionListener(this);
        udlr.setBounds(0,0,200,95);
        udlr.setLocation(380,300);
        add(udlr);
        back= new JButton(b);
        back.addActionListener(this);
        back.setBounds(0,0,190,60);
        back.setLocation(220,450);
        add(back);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==wasd)
		{
			LEFT=true;
			SwingUtilities.getWindowAncestor(this).dispose();
		}
		else if(e.getSource()==udlr)
		{
			LEFT=false;
			SwingUtilities.getWindowAncestor(this).dispose();
		}
		else if (e.getSource()==back)
		{
			SwingUtilities.getWindowAncestor(this).dispose();
		}
	}

}



import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import javax.swing.*;


@SuppressWarnings("serial")
public class GOPanel extends JPanel implements ActionListener{
	int index;
	JButton exit;
	Icon b,go;
	JLabel g;
	public GOPanel(int index) {
        this.setVisible(true);
        this.setLayout((LayoutManager) null);
        this.index = index;
        this.b=new ImageIcon("images/exit_button.png");
        this.exit=new JButton(b);
		this.exit.addActionListener(this);
		this.exit.setBorder(BorderFactory.createEmptyBorder());
		this.exit.setBounds(0,0, 190, 60);
		this.exit.setLocation(GamePanel.Width/2-exit.getWidth()/2,GamePanel.Height/2-exit.getHeight()/2+150);
        this.add(exit); 
        this.go= new ImageIcon("images/gameover.png");
        this.g=new JLabel(go);
        this.g.setBounds(0,0,GamePanel.Width,GamePanel.Height);
        
        this.add(g);
    }

    public void actionPerformed(ActionEvent e)
    {
    	if(e.getSource()==exit)
    	{
    		MainMenu menu= new MainMenu("Frogger");
    		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	    menu.setVisible(true);
    	}
    }
}

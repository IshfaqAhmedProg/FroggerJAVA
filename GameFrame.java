

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class GameFrame extends JFrame{
	
	public GameFrame()
	{
		super("Frogger");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(GamePanel.Width,GamePanel.Height);
		setLocationRelativeTo(null);
		pack();
		GamePanel p = new GamePanel();
		
		Insets frameInsets = getInsets();
        
        int frameWidth = p.getWidth()
                + (frameInsets.left + frameInsets.right);
        int frameHeight = p.getHeight()
                + (frameInsets.top + frameInsets.bottom);
		setPreferredSize(new Dimension(frameWidth,frameHeight));
		setLayout(null);
		add(p);
		pack();
		setVisible(true);
	}
}

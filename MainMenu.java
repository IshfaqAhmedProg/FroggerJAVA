import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;


@SuppressWarnings("serial")
public class MainMenu extends JFrame implements ActionListener{
	private JButton newGame,options,exit,scores;
	private Image bg;
	private int width,height;
	Icon ng,o,e,s;
	
	public MainMenu(String title)
	{
		super(title);
		width=660;
		height=410;
		setSize(width,height);
		setLocationRelativeTo(null);
		setLayout(null);
		try {
			this.bg=ImageIO.read(new File("images/menu_bg.jpg"));
			this.ng= new ImageIcon("images/start_button.png");
			this.o= new ImageIcon("images/option_button.png");
			this.e= new ImageIcon("images/exit_button.png");
			this.s= new ImageIcon("images/score.png"); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.newGame=new JButton(ng);	
		this.newGame.addActionListener(this);
		this.newGame.setBorder(BorderFactory.createEmptyBorder());
		this.newGame.setBounds(75,135,190,60);
		add(this.newGame);
		
		this.options=new JButton(o);
		this.options.addActionListener(this);
		this.options.setBorder(BorderFactory.createEmptyBorder());
		this.options.setBounds(75,200,190,60);
		add(this.options);
		
		this.exit=new JButton(e);
		this.exit.addActionListener(this);
		this.exit.setBorder(BorderFactory.createEmptyBorder());
		this.exit.setBounds(75, 265, 190, 60);
		add(this.exit);
		
		this.scores=new JButton(s);
		this.scores.addActionListener(this);
		this.scores.setBorder(BorderFactory.createEmptyBorder());
		this.scores.setBounds(500, 300, 60, 60);
		add(this.scores);
		
		JLabel background=new JLabel(new ImageIcon(this.bg));
		background.setBounds(28, getHeight() - 438, 400, 438);
	    background.setBounds(0, 0, width, height);
	    add(background);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==this.exit)
		{
			System.exit(0);
		}
		else if (e.getSource()==this.newGame)
		{
			new GameFrame();
		}
		else if (e.getSource()==this.options)
		{
			OptionWindow ow=new OptionWindow("OPTIONS");
			ow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ow.setVisible(true);
		}
		else if (e.getSource()==this.scores)
		{
			ScoreFrame sf=new ScoreFrame("SCORES");
			sf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			sf.setVisible(true);
		}
	}
}

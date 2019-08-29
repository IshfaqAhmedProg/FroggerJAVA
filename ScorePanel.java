

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

import java.util.*;

import javax.swing.*;

@SuppressWarnings({ "serial", "unused" })
public class ScorePanel extends JPanel implements ActionListener{
	private JButton exit;
    ArrayList<String> allScores = new ArrayList<>();
    ArrayList<String> allNames = new ArrayList<>();
    ArrayList<JLabel> lables = new ArrayList<>();
	public ScorePanel()
	{
		setLayout(null);
		JLabel team = new JLabel("High Scores", JLabel.CENTER);
        team.setBounds(0, 0, 500, 40);
        team.setLocation(640 / 2 - team.getWidth() / 2 + 50, 45);
        team.setForeground(new Color(251, 102, 8));
        add(team);

        /*try {
        	Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/highscores","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from scores");
			while(rs.next())
			{
				this.allNames.add(rs.getString("name"));
			}
			rs = stmt.executeQuery("select score from scores");
			while(rs.next())
			{
				this.allScores.add(rs.getString(1));
			}
			con.close();
        }
        catch(Exception e){
        	e.printStackTrace();
        }*/
        try {
            FileReader fr = new FileReader("images/scores.txt");
            BufferedReader br = new BufferedReader(fr);
            FileReader frNames = new FileReader("images/names.txt");
            BufferedReader brNames = new BufferedReader(frNames);
            for (int i = 0; i < 5; i++) {
                this.allScores.add(br.readLine());
            }

            for (int i = 0; i < 5; i++) {
                this.allNames.add(brNames.readLine());
            }

            frNames.close();
            brNames.close();
            br.close();
            fr.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        //adding JLabels to labels array
        for(int i=0;i<allNames.size();i++)
        {
        	lables.add(new JLabel(allNames.get(i), JLabel.LEFT));
        }
        for(int i=0;i<allNames.size();i++)
        {
        	lables.add(new JLabel(allScores.get(i), JLabel.LEFT));
        }
        //setting the x and y axis of the labels
        for (int i = 0; i < lables.size(); i++) {
            JLabel jl = lables.get(i);
            int X = 140;
            int Y = (198 + i * 70);
            if (i >= allNames.size()) {
                X = 400;
                Y = (198+(i-allNames.size())*70);
            }


            jl.setBounds(0, 0, 400, 22);
            jl.setLocation(X, Y);

            add(jl);
        }
        exit= new JButton("exit");
        exit.addActionListener(this);
        exit.setBounds(0,0,120,40);
        exit.setLocation(640/2,400/2+60);
        add(exit);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==exit)
		{
			System.exit(0);
		}
	}
}





import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

@SuppressWarnings({ "serial", "unused" })
public class GWPanel extends JPanel implements ActionListener{
	public static JTextField playerName;
	JButton accept;
	JLabel enterName;
	ArrayList<String> Names =new ArrayList<>();
	int index;
	BufferedImage v;
	
	public GWPanel(boolean showinput,int index)
	{
		this.setVisible(true);
		this.setLayout(null);
		this.index=index;
		
		if(showinput)
		{
			playerName =new JTextField();
			playerName.setBounds(0, 0, 260, 35);
			playerName.setLocation(GamePanel.Width/2-playerName.getWidth()/2,GamePanel.Height/2-playerName.getHeight()/2+40 );
			enterName= new JLabel("Enter Name");
			enterName.setBounds(0, 0 , 300, 35);
			enterName.setLocation(GamePanel.Width/2-playerName.getWidth()/2-320,GamePanel.Height/2-playerName.getHeight()/2+40 );
			this.add(playerName);
			this.add(enterName);
			
			this.accept= new JButton("Accept");
			this.accept.addActionListener((ActionListener) this);
			this.accept.setBounds(0,0,100,40);
			this.accept.setLocation(GamePanel.Width/2-accept.getWidth()/2,GamePanel.Height/2 -accept.getHeight()/2+150);
			this.add(accept);
			try {
				v= ImageIO.read(new File("images/victory.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.create();
		g.setColor(Color.black);
		g.drawImage(v, GamePanel.Width/2-160, GamePanel.Height/2-130,null);
	}
	public void actionPerformed(ActionEvent e)
	{
		String names=playerName.getText();
		int score=1000-RunVehicle.scoreh;
		System.out.println("Score "+score);
		if (names.equals(null))
		{
			names="No Name";
		}
		/*try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driverloaded");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/highscores","root","");
			System.out.println("comloaded");
			String sql="INSERT INTO scores (name,score) VALUES ('"+names+"','"+score+"')";
			System.out.println(sql);

			Statement stmt = con.createStatement();
			System.out.println("driloaded");

			@SuppressWarnings("unused")
			int rs = stmt.executeUpdate(sql);
			System.out.println("drived");
			
			con.close();
		}
		catch(Exception a)
		{
			a.printStackTrace();
		}*/
		try {
            FileReader fReader = new FileReader("images/names.txt");
            BufferedReader bReader = new BufferedReader(fReader);
            for (int i = 0; i < 5; i++) {
                this.Names.add(bReader.readLine());
            }
            this.Names.add(index, names);
            bReader.close();
            fReader.close();

            FileWriter fileWriter = new FileWriter("images/names.txt");
            PrintWriter write = new PrintWriter(fileWriter);
            for (int i = 0; i < 5; i++) {
                write.printf("%s%n", this.Names.get(i));
            }
            fileWriter.close();
            write.close();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
		ScoreFrame s= new ScoreFrame("Scores");
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s.setVisible(true);
	}

}

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class c1 extends JFrame implements ActionListener
{
	Connection con;
	Statement st;
	ResultSet  rs;
	JLabel l1=new JLabel(new ImageIcon("C:\\Users\\hp\\Pictures\\camp_kids.jpg"));
	JLabel l2=new JLabel("KIDS CAMP");
	JLabel l3=new JLabel("Sand and Sun, Summer has Begun");
	JLabel l4=new JLabel("Art & Craft");
	JLabel l5=new JLabel("Dance");
	JLabel l6=new JLabel("Cooking");
	JLabel l7=new JLabel("Games and Puzzles");
	JLabel l8=new JLabel("Yoga");
	JLabel l9=new JLabel("Mask Making");
	JLabel l10=new JLabel("Abacus");
	JLabel l11=new JLabel("Greeting Cards");
	JLabel l12=new JLabel("Pencil Sketch");
	JButton b1=new JButton("Click Here");
	JButton b2=new JButton("View Courses");
	public c1()
	{ 
		add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);add(l7);add(l8);add(b1);add(b2);
		add(l9);add(l10);add(l11);add(l12);
		b1.addActionListener(this);
		b2.addActionListener(this);
		this.setVisible(true);
		this.setSize(600,500);
		this.setLayout(null);
		l1.setBounds(500,100,288,190);
		l2.setForeground(Color.RED);
		l2.setFont(new Font("Showcard Gothic",Font.BOLD,50));
		l2.setBounds(500,30,500,70);
		l3.setForeground(Color.DARK_GRAY);
		l3.setFont(new Font("Monotype Corsiva",Font.BOLD,30));
		l3.setBounds(450,200,550,70);
		l4.setForeground(Color.BLUE);
		l4.setBounds(200,350,200,70);
		l5.setForeground(Color.BLUE);
		l5.setBounds(200,400,200,70);
		l6.setForeground(Color.BLUE);
		l6.setBounds(200,450,200,70);
		l7.setForeground(Color.BLUE);
		l7.setBounds(500,400,200,70);
		l8.setForeground(Color.BLUE);
		l8.setBounds(500,350,200,70);
		l9.setForeground(Color.BLUE);
		l9.setBounds(500,450,200,70);
		l10.setForeground(Color.BLUE);
		l10.setBounds(800,350,200,70);
		l11.setForeground(Color.BLUE);
		l11.setBounds(800,450,200,70);
		l12.setForeground(Color.BLUE);
		l12.setBounds(800,400,200,70);
		b1.setBounds(450,550,150,30);
		b2.setBounds(800,550,150,30);
	}
	public static void main(String[] args) 
	{
		new c1();
	}
	public void actionPerformed(ActionEvent ar) 
	{
		if(ar.getSource().equals(b1))
		{
			new c2();
			this.hide();
		}
		if(ar.getSource().equals(b2))
		{
			new c3();
			this.hide();
		}
	}

}
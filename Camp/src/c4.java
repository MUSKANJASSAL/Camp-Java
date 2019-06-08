import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
public class c4 extends JFrame implements ActionListener
{
	Connection con;
	Statement st;
	ResultSet  rs;
	JLabel l1=new JLabel("List of Courses");
	JLabel l2=new JLabel(new ImageIcon("C:\\Users\\hp\\Pictures\\yoga.jpg"));
	JLabel l3=new JLabel(new ImageIcon("C:\\Users\\hp\\Pictures\\math.jpg"));
	JButton b1=new JButton("Fees");
	JComboBox c=new JComboBox();
	JTextField t1=new JTextField();
	public c4()
	{
		add(c);add(l1);add(b1);add(t1);add(l2);add(l3);
		this.setVisible(true);
		this.setSize(600,600);
		this.setLayout(null);
		b1.addActionListener(this);
		l2.setBounds(100,50,104,97);
		l3.setBounds(250,60,69,88);
		l1.setBounds(100,200,150,40);
		c.setBounds(300,200,150,40);
		b1.setBounds(100,270,150,40);
		t1.setBounds(300,270,150,40);
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/camp","root","riccs");
		st=con.createStatement();
	}
	catch(Exception ex)
	{
		JOptionPane.showMessageDialog(null,ex.getMessage());
	}
	try
	{
		rs=st.executeQuery("select * from hobby");
		while(rs.next())
		{
			c.addItem(rs.getString(2));
		}
	}
	catch(Exception ex)
	{
		JOptionPane.showMessageDialog(null,ex.getMessage());
	}
}

	public static void main(String[] args) 
	{
		new c4();
	}
	public void actionPerformed(ActionEvent ar) 
	{
		if(ar.getSource().equals(b1))
		{
			try
			{
				rs=st.executeQuery("select * from hobby where courses='"+c.getSelectedItem()+"'");
				while(rs.next())
				{
					t1.setText(rs.getString(3));
				}
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage());
			}
		}
	
	}
}
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
public class c3 extends JFrame implements ActionListener
{
	Connection con;
	Statement st;
	ResultSet rs;
	JLabel l0=new JLabel("Select Course");
	JComboBox cb=new JComboBox();
	JLabel l1=new JLabel("Courses");
	JLabel l2=new JLabel("Name of the course");
	JLabel l3=new JLabel("Fees");
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JButton b1=new JButton("ADD");
	JButton b2=new JButton("DELETE");
	JButton b3=new JButton("UPDATE");
	JButton b4=new JButton("SELECT");
	JButton b5=new JButton("CLEAR");
	JButton b6=new JButton("VIEW LIST");
	public c3()
	{
		add(l1);add(l2);add(l3);add(t1);add(t2);add(b1);add(b2);add(b3);add(l0);add(cb);
		add(b4);add(b5);add(b6);
		this.setVisible(true);
		this.setSize(600,600);
		this.setLayout(null);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		l0.setBounds(100,200,150,40);
		cb.setBounds(250,200,150,30);
		l1.setBounds(30,100,200,40);
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("Copper Black",Font.BOLD,40));
		l2.setBounds(100,250,150,40);
		t1.setBounds(250,250,150,30);
		l3.setBounds(100,300,150,40);
		t2.setBounds(250,300,150,30);
		b1.setBounds(50,400,100,30);
		b2.setBounds(200,400,100,30);
		b3.setBounds(350,400,100,30);
		b4.setBounds(50,450,100,30);
		b5.setBounds(200,450,100,30);
		b6.setBounds(350,450,100,30);
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
				cb.addItem(rs.getString(2));
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
	}
	public static void main(String[] args)
	{
		new c3();
	}
	public void actionPerformed(ActionEvent ar)
	{
		if(ar.getSource().equals(b1))
		{
			try
			{
				st.executeUpdate("Insert into hobby values(0,'"+t1.getText()+"','"+t2.getText()+"')");
				JOptionPane.showMessageDialog(null,"Record inserted");
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage());
			}
		}
		if(ar.getSource().equals(b2))
		{
			try
			{
				st.executeUpdate("delete from hobby where courses='"+cb.getSelectedItem()+"'");
				JOptionPane.showMessageDialog(null,"record deleted");
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage());
			}
		}
		if(ar.getSource().equals(b3))
		{
			try
			{
				st.executeUpdate("update hobby set courses='"+t1.getText()+"',feess='"+t2.getText()+"'where courses='"+cb.getSelectedItem()+"'");
				
				JOptionPane.showMessageDialog(null,"record updated");
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage());
			}
		}
		if(ar.getSource().equals(b4))
		{
			try
			{
				rs=st.executeQuery("select * from hobby where courses='"+cb.getSelectedItem()+"'");
				while(rs.next())
				{
					t1.setText(rs.getString(2));
					t2.setText(rs.getString(3));
				}
			}
			catch(Exception ex)
			
			{
				JOptionPane.showMessageDialog(null,ex.getMessage());
			}
		}
		if(ar.getSource().equals(b5))
		{
			t1.setText("");
			t2.setText("");
		}
		if(ar.getSource().equals(b6))
		{
			new c5();
			this.hide();
		}
	}
}
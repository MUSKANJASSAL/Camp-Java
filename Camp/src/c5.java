import java.awt.Container;
import java.awt.FlowLayout;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class c5 extends JFrame  
{
	Connection con;
	Statement st;
	ResultSet rs;
	DefaultTableModel model=new DefaultTableModel();
	Container c=this.getContentPane();
	JTable t=new JTable(model);
	public c5()
	{
		c.setLayout(new FlowLayout(FlowLayout.CENTER));
		model.addColumn("Sno");
		model.addColumn("Courses");
		model.addColumn("Fees");
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
				model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
		JScrollPane s=new JScrollPane(t);
		c.add(s);
		this.setTitle("DETAILS");
		this.setSize(675,300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public static void main(String[] args) 
	{
		new c5();
	}

}
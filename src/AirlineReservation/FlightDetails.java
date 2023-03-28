package AirlineReservation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class FlightDetails extends JFrame {

	private JPanel contentPane;
	private JTextField textcode;
	private JTextField textname;
	private JTextField textcapacity;
	private JTextField textamount;
	private JTextField textat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightDetails frame = new FlightDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FlightDetails() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\JAVA\\Project\\imagesonline\\airicon.jpg"));
		setTitle("MY TRIP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 469);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Flights details");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNewLabel.setBounds(315, 29, 217, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Code:");
		lblNewLabel_1.setBounds(337, 92, 49, 14);
		contentPane.add(lblNewLabel_1);
		
		textcode = new JTextField();
		textcode.setBounds(396, 89, 136, 20);
		contentPane.add(textcode);
		textcode.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setBounds(337, 140, 49, 14);
		contentPane.add(lblNewLabel_2);
		
		textname = new JTextField();
		textname.setBounds(396, 137, 136, 20);
		contentPane.add(textname);
		textname.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Source:");
		lblNewLabel_3.setBounds(323, 188, 49, 14);
		contentPane.add(lblNewLabel_3);
		
		String[] src= {"Chennai","Coimbatore","Madurai","Tiruchy","Tuticorin","Salem","Puducherry"};
		final JComboBox comboBoxsrc = new JComboBox(src);
		comboBoxsrc.setBounds(396, 184, 136, 22);
		contentPane.add(comboBoxsrc);
		
		JLabel lblNewLabel_4 = new JLabel("Destination:");
		lblNewLabel_4.setBounds(312, 221, 74, 14);
		contentPane.add(lblNewLabel_4);
		
		textcapacity = new JTextField();
		textcapacity.setBounds(406, 256, 137, 20);
		contentPane.add(textcapacity);
		textcapacity.setColumns(10);
		
		String[] des= {"Chennai","Coimbatore","Madurai","Tiruchy","Tuticorin","Salem","Puducherry"};
		final JComboBox comboBoxdes = new JComboBox(des);
		comboBoxdes.setBounds(396, 217, 136, 22);
		contentPane.add(comboBoxdes);
		
		JLabel lblNewLabel_5 = new JLabel("Capacity:");
		lblNewLabel_5.setBounds(315, 259, 65, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Class:");
		lblNewLabel_6.setBounds(321, 291, 65, 14);
		contentPane.add(lblNewLabel_6);
		
		String[] s1= {"Economy","Business","Premium Economy"};
		final JComboBox comboclass = new JComboBox(s1);
		comboclass.setBounds(397, 287, 135, 22);
		contentPane.add(comboclass);
		
		JLabel lblNewLabel_7 = new JLabel("Amount:");
		lblNewLabel_7.setBounds(312, 335, 60, 14);
		contentPane.add(lblNewLabel_7);
		
		textamount = new JTextField();
		textamount.setBounds(409, 332, 134, 20);
		contentPane.add(textamount);
		textamount.setColumns(10);
		
		ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("images/flight2.jpg"));
		JLabel lblimage = new JLabel(i2);
		lblimage.setBounds(20, 29, 264, 247);
		contentPane.add(lblimage);
		
		final JButton btnNewButton = new JButton("Add Flight");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code=textcode.getText();
				String name=textname.getText();
				String src = (String) comboBoxsrc.getSelectedItem();
				 String des = (String) comboBoxdes.getSelectedItem();
				 String capacity=textcapacity.getText();
				 String c = (String) comboclass.getSelectedItem();
				 String amount=textamount.getText();
				 String t=textat.getText();
				try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newuser", "root", "12345");
						String query = "INSERT INTO flights values('" +code+ "','" +name+ "','"+src+"','"+des+"','"+capacity+ "','" +
			                        c + "','" +amount+"','"+t+"')";
						Statement sta = connection.createStatement();
			                    int x = sta.executeUpdate(query);
			                    if (x == 0) {
			                        JOptionPane.showMessageDialog(btnNewButton , "This is alredy exist");
						}
			                    else {
			                        JOptionPane.showMessageDialog( btnNewButton, "flignt is sucessfully added");
			                    }
			                    connection.close();
		                } catch (Exception exception) {
		                    exception.printStackTrace();
		                }
				 
		            }
				 });
		btnNewButton.setBounds(78, 305, 121, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_8 = new JLabel("Arrival time:");
		lblNewLabel_8.setBounds(291, 376, 95, 14);
		contentPane.add(lblNewLabel_8);
		
		textat = new JTextField();
		textat.setBounds(406, 373, 136, 20);
		contentPane.add(textat);
		textat.setColumns(10);
	}
}

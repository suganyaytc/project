package AirlineReservation;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

public class Payment extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JTextField textname;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment frame = new Payment();
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
	public Payment() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\JAVA\\Project\\imagesonline\\airicon.jpg"));
		setTitle("MY TRIP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 828, 514);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Payment details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
	                   Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newuser","root", "12345");
	                    String str = "select * from payment";
	                    PreparedStatement st = (PreparedStatement) connection
	                            .prepareStatement(str);
	                        ResultSet rs = st.executeQuery();
	                        table.setModel(DbUtils.resultSetToTableModel(rs));

			}catch(Exception E) {
			}
			}
			
		});
		btnNewButton.setBounds(346, 11, 140, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 108, 794, 318);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("pnr_no:");
		lblNewLabel.setBounds(243, 64, 49, 14);
		contentPane.add(lblNewLabel);
		
		textname = new JTextField();
		textname.setBounds(284, 61, 121, 20);
		contentPane.add(textname);
		textname.setColumns(10);
		
		btnNewButton_1 = new JButton("Details");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name=textname.getText();
				try{
	                   Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newuser","root", "12345");
	                    String str = "select * from payment where pnr_no=?";
	                    PreparedStatement st = (PreparedStatement) connection
	                            .prepareStatement(str);
	                        st.setString(1, Name);
	                         ResultSet rs = st.executeQuery();
	                        table.setModel(DbUtils.resultSetToTableModel(rs));

			}catch(Exception E) {
			}
			}
			});
		btnNewButton_1.setBounds(453, 60, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}

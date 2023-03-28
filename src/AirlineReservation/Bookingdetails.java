package AirlineReservation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Bookingdetails extends JFrame {

	private JPanel contentPane;
	private JTextField textFc;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bookingdetails frame = new Bookingdetails();
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
	public Bookingdetails() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\JAVA\\Project\\imagesonline\\airicon.jpg"));
		setTitle("MY TRIP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 596);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Booking Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		                   Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newuser","root", "12345");
		                    String str = "select * from booking";
		                    PreparedStatement st = (PreparedStatement) connection
		                            .prepareStatement(str);
		                        ResultSet rs = st.executeQuery();
		                        table.setModel(DbUtils.resultSetToTableModel(rs));

				}catch(Exception E) {
				}
				}
			});
		
		btnNewButton.setBounds(346, 28, 150, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(177, 88, 69, 14);
		contentPane.add(lblNewLabel);
		
		textFc = new JTextField();
		textFc.setBounds(256, 85, 127, 20);
		contentPane.add(textFc);
		textFc.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 140, 737, 318);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Details");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textFc.getText();
				try{
	                   Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newuser","root", "12345");
	                    String str = "select * from booking  where name=?";
	                    PreparedStatement st = (PreparedStatement) connection
	                            .prepareStatement(str);
	                        st.setString(1,name);
	                         ResultSet rs = st.executeQuery();
	                        table.setModel(DbUtils.resultSetToTableModel(rs));

			}catch(Exception E) {
			}
			}
			});
		btnNewButton_1.setBounds(393, 84, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancel");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Cancellation().setVisible(true);
			}
		});
		btnNewButton_2.setBounds(592, 492, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}

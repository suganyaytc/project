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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Cancellation extends JFrame {

	private JPanel contentPane;
	private JTextField textpn;
	private JTextField textcn;
	private JTextField textcd;
	private JTextField textfc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cancellation frame = new Cancellation();
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
	public Cancellation() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\JAVA\\Project\\imagesonline\\airicon.jpg"));
		setTitle("MY TRIP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 368);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cancel Tickes");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(166, 35, 114, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Passenger Name:");
		lblNewLabel_1.setBounds(44, 79, 114, 25);
		contentPane.add(lblNewLabel_1);
		
		textpn = new JTextField();
		textpn.setText("");
		textpn.setBounds(176, 81, 132, 20);
		contentPane.add(textpn);
		textpn.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cancellation no:");
		lblNewLabel_2.setBounds(66, 128, 104, 14);
		contentPane.add(lblNewLabel_2);
		
		textcn = new JTextField();
		textcn.setBounds(176, 125, 132, 20);
		contentPane.add(textcn);
		textcn.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Cancellation Date:");
		lblNewLabel_3.setBounds(44, 172, 114, 14);
		contentPane.add(lblNewLabel_3);
		
		textcd = new JTextField();
		textcd.setBounds(176, 169, 132, 20);
		contentPane.add(textcd);
		textcd.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Flight Code:");
		lblNewLabel_4.setBounds(82, 223, 82, 14);
		contentPane.add(lblNewLabel_4);
		
		textfc = new JTextField();
		textfc.setBounds(184, 220, 124, 20);
		contentPane.add(textfc);
		textfc.setColumns(10);
		
		final JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Passengername=textpn.getText();
				String cancellationno=textcn.getText();
				String cancellationdate=textcd.getText();
				String flightcode=textfc.getText();
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newuser", "root", "12345");
					String query = "INSERT INTO cancellation values('" +Passengername+ "','" +cancellationno+ "','"+cancellationdate+"','"+flightcode+"')";
					Statement sta = connection.createStatement();
		                    int x = sta.executeUpdate(query);
		                    if (x == 0) {
		                        JOptionPane.showMessageDialog(btnNewButton , "This is alredy exist");
					}
		                    else {
		                        JOptionPane.showMessageDialog(btnNewButton , "Ticket Cancelled");
		                    }
		                    connection.close();
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton.setBounds(378, 272, 89, 23);
		contentPane.add(btnNewButton);
		
		ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("images/cancel1.jpg"));
		JLabel lblNewLabel_5 = new JLabel(i3);
		lblNewLabel_5.setBounds(372, 35, 146, 136);
		contentPane.add(lblNewLabel_5);
	}

}

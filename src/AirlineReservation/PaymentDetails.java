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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class PaymentDetails extends JFrame {

	private JPanel contentPane;
	private JTextField textpnrno;
	private JTextField textpa;
	private JTextField textpd;
	private JTextField textcardno;
	private JTextField textphno;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentDetails frame = new PaymentDetails();
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
	public PaymentDetails() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\JAVA\\Project\\imagesonline\\airicon.jpg"));
		setTitle("MY TRIP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 410);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MAKE PAYMENT");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel.setBounds(215, 33, 146, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pnr_no:");
		lblNewLabel_1.setBounds(148, 86, 75, 14);
		contentPane.add(lblNewLabel_1);
		
		textpnrno = new JTextField();
		textpnrno.setText("");
		textpnrno.setBounds(226, 83, 108, 20);
		contentPane.add(textpnrno);
		textpnrno.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Paid Amount:");
		lblNewLabel_2.setBounds(110, 122, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		textpa = new JTextField();
		textpa.setBounds(225, 119, 108, 20);
		contentPane.add(textpa);
		textpa.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Paid Date:");
		lblNewLabel_3.setBounds(129, 172, 70, 14);
		contentPane.add(lblNewLabel_3);
		
		textpd = new JTextField();
		textpd.setBounds(226, 169, 108, 20);
		contentPane.add(textpd);
		textpd.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Card No:");
		lblNewLabel_4.setBounds(110, 220, 74, 14);
		contentPane.add(lblNewLabel_4);
		
		textcardno = new JTextField();
		textcardno.setBounds(226, 217, 108, 20);
		contentPane.add(textcardno);
		textcardno.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Phone no");
		lblNewLabel_5.setBounds(110, 269, 74, 14);
		contentPane.add(lblNewLabel_5);
		
		textphno = new JTextField();
		textphno.setBounds(226, 266, 108, 20);
		contentPane.add(textphno);
		textphno.setColumns(10);
		
		final JButton btnNewButton = new JButton("Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String Pnr_no=textpnrno.getText();
				 String PaidAmount=textpa.getText();
				 String PaidDate=textpd.getText();
				 String cardno=textcardno.getText();
				 String Ph_no=textphno.getText();
				
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newuser", "root", "12345");
					String query = "INSERT INTO payment values('" +Pnr_no+ "','" +PaidAmount+ "','"+PaidDate+"','"+cardno+"','"+Ph_no+"')";
					Statement sta = connection.createStatement();
		                    int x = sta.executeUpdate(query);
		                    if (x == 0) {
		                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
					}
		                    else {
		                        JOptionPane.showMessageDialog(btnNewButton , "Booking Sucessfull");
		                    }
		                    connection.close();
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
				new CustomerHome().setVisible(true);
			  }
			 });
			btnNewButton.setBounds(419, 334, 89, 23);
		contentPane.add(btnNewButton);
	}

}

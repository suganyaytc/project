package AirlineReservation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Booking extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Booking frame = new Booking();
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
	public Booking() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\JAVA\\Project\\imagesonline\\airicon.jpg"));
		setTitle("MY TRIP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 396);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 35)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnManageBooking = new JButton("Manage Booking");
		btnManageBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Cancellation().setVisible(true);
			}
		});
		btnManageBooking.setBounds(407, 218, 203, 48);
		contentPane.add(btnManageBooking);
		
		JButton btnFlights = new JButton("Flights");
		btnFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Flight().setVisible(true);
			}
		});
		btnFlights.setBounds(407, 146, 203, 41);
		contentPane.add(btnFlights);
		
		JButton btnlogin = new JButton("Login/Signup");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login().setVisible(true);
			}
		});
		btnlogin.setBounds(407, 62, 203, 41);
		contentPane.add(btnlogin);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/airicon3.jpg"));
		JLabel lblImage = new JLabel(i1);
		lblImage.setBounds(10, 11, 387, 337);
		contentPane.add(lblImage);
		
		
	}
}

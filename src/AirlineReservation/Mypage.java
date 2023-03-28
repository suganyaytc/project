package AirlineReservation;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mypage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mypage frame = new Mypage();
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
	public Mypage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\JAVA\\Project\\imagesonline\\airicon.jpg"));
		setTitle("MY TRIP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 763, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 763, 400));

		setContentPane(contentPane);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/air2.jpg"));
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel(i1);
		lblNewLabel.setBounds(0, 0, 749, 363);
		lblNewLabel.setBackground(SystemColor.desktop);
		lblNewLabel.setLabelFor(lblNewLabel);
		contentPane.add(lblNewLabel);
		
		JButton btnBooking = new JButton("DOMESTIC FLIGHTS BOOKING");
		btnBooking.setBounds(75, 58, 298, 33);
		btnBooking.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new Booking().setVisible(true); 
			       }
			});
		contentPane.add(btnBooking);
	}
}

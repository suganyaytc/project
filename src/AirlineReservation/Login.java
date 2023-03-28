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
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\JAVA\\Project\\imagesonline\\airicon.jpg"));
		setTitle("MY TRIP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 424);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblUserName = new JLabel("username:");
		lblUserName.setBounds(302, 67, 77, 30);
		lblUserName.setFont(new Font("Arial Black", Font.BOLD, 12));
		contentPane.add(lblUserName);
		
		JLabel lblpassword = new JLabel("password:");
		lblpassword.setBounds(302, 143, 77, 21);
		lblpassword.setFont(new Font("Arial Black", Font.BOLD, 12));
		contentPane.add(lblpassword);
		
		final JTextArea textuser = new JTextArea();
		textuser.setBounds(389, 73, 162, 30);
		textuser.setFont(new Font("Arial", Font.BOLD, 13));
		contentPane.add(textuser);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(389, 142, 162, 30);
		contentPane.add(passwordField);
		
		final JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String userName = textuser.getText();
                String password = passwordField.getText();
                try {
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newuser","root", "12345");

                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select username, password from signup where username=? and password=?");
                    st.setString(1, userName);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        dispose();
                        new  CustomerHome().setVisible(true);
                        JOptionPane.showMessageDialog(btnLogin, "You have successfully logged in");
                    }
                    else {
                        JOptionPane.showMessageDialog(btnLogin, "Wrong Username & Password");
                    }
                }
                catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
			
		});
		btnLogin.setBounds(324, 224, 99, 21);
		btnLogin.setFont(new Font("Arial Black", Font.BOLD, 12));
		contentPane.add(btnLogin);
		
		JButton btnSignup = new JButton("Signup");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Signup().setVisible(true);
			}
		});
		btnSignup.setBounds(462, 223, 89, 23);
		btnSignup.setFont(new Font("Arial Black", Font.BOLD, 12));
		contentPane.add(btnSignup);
		
		ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("images/airicon3.jpg"));
		JLabel lblNewLabel = new JLabel(i2);
		lblNewLabel.setBounds(22, 37, 270, 326);
		contentPane.add(lblNewLabel);
		
		
		
}
}

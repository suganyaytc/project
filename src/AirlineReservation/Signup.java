package AirlineReservation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class Signup extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textAge;
	private JTextField textAddress;
	private JTextField textUsername;
	private JTextField textPassword;
	private JTextField textNationality;
	private JTextField textCity;
	private JTextField textMobileno;
	private JTextField textEmailid;
	private JComboBox combobox_1;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Signup() {
		setTitle("MY TRIP");
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\JAVA\\Project\\imagesonline\\airicon.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 504);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewuserregistration = new JLabel("New User Registration");
		lblNewuserregistration.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewuserregistration.setBounds(270, 28, 208, 26);
		contentPane.add(lblNewuserregistration);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(38, 97, 49, 14);
		contentPane.add(lblName);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(38, 144, 49, 14);
		contentPane.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(27, 195, 49, 14);
		contentPane.add(lblGender);
		
		JLabel lblMaritalsatus = new JLabel("MaritalStatus:");
		lblMaritalsatus.setBounds(27, 245, 85, 19);
		contentPane.add(lblMaritalsatus);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(27, 306, 60, 40);
		contentPane.add(lblAddress);
		
		textName = new JTextField();
		textName.setBounds(81, 94, 208, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textAge = new JTextField();
		textAge.setBounds(81, 141, 208, 20);
		contentPane.add(textAge);
		textAge.setColumns(10);
		
		final JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(82, 191, 54, 23);
		contentPane.add(rdbtnMale);
		
		final JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.setBounds(138, 191, 71, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		final JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Transgender");
		rdbtnNewRadioButton_2.setBounds(211, 191, 108, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		final JRadioButton rdbtnMarried = new JRadioButton("Married");
		rdbtnMarried.setBounds(132, 243, 77, 23);
		contentPane.add(rdbtnMarried);
		
		final JRadioButton rdbtnUnmarried = new JRadioButton("Unmarried");
		rdbtnUnmarried.setBounds(227, 243, 92, 23);
		contentPane.add(rdbtnUnmarried);
		
		textAddress = new JTextField();
		textAddress.setHorizontalAlignment(SwingConstants.LEFT);
		textAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAddress.setBounds(97, 292, 222, 67);
		contentPane.add(textAddress);
		textAddress.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(379, 97, 67, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(379, 144, 77, 14);
		contentPane.add(lblPassword);
		
		textUsername = new JTextField();
		textUsername.setBounds(442, 94, 170, 20);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setBounds(442, 141, 170, 20);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		JLabel lblNationality = new JLabel("Nationality:");
		lblNationality.setBounds(361, 195, 67, 14);
		contentPane.add(lblNationality);
		
		textNationality = new JTextField();
		textNationality.setBounds(442, 192, 170, 20);
		contentPane.add(textNationality);
		textNationality.setColumns(10);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setBounds(397, 245, 49, 14);
		contentPane.add(lblCity);
		
		textCity = new JTextField();
		textCity.setBounds(442, 242, 170, 20);
		contentPane.add(textCity);
		textCity.setColumns(10);
		
		JLabel lblIDproof = new JLabel("IDproof:");
		lblIDproof.setBounds(379, 292, 49, 14);
		contentPane.add(lblIDproof);
		
		JLabel lblMobileno = new JLabel("MobileNo:");
		lblMobileno.setBounds(361, 346, 67, 14);
		contentPane.add(lblMobileno);
		
		textMobileno = new JTextField();
		textMobileno.setBounds(442, 343, 170, 20);
		contentPane.add(textMobileno);
		textMobileno.setColumns(10);
		
		JLabel lblEmailid = new JLabel("Emailid:");
		lblEmailid.setBounds(27, 416, 49, 14);
		contentPane.add(lblEmailid);
		
		textEmailid = new JTextField();
		textEmailid.setBounds(86, 413, 217, 20);
		contentPane.add(textEmailid);
		textEmailid.setColumns(10);
		
		String[] s1={"Passport", "Aadhar Card", "Voter Id", "Driving license"};
		final JComboBox combobox_1 = new JComboBox(s1);
		combobox_1.setBounds(432, 288, 180, 22);
		contentPane.add(combobox_1);
		
		
		
		final JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textName.getText();
				String age=textAge.getText();
				String gender="";
				String maritalstatus="";
				String address=textAddress.getText();
				String username=textUsername.getText();
				String password=textPassword.getText();
				String nationality=textNationality.getText();
				String city=textCity.getText();
				String mobileno=textMobileno.getText();
				String emailid=textEmailid.getText();
			    String idproof=(String) combobox_1.getSelectedItem();
				if(rdbtnMale.isSelected()) {
					gender="Male";
					
				}else if(rdbtnNewRadioButton_1.isSelected()) {
					gender="Female";
					
				}
				else if(rdbtnNewRadioButton_2.isSelected()) {
					gender="Transgender";
				}
				if(rdbtnMarried.isSelected()) {
					maritalstatus="Married";
				}
				else if(rdbtnUnmarried.isSelected()){
					maritalstatus="Unmarried";
				}
				int len = mobileno.length();
				if (len != 10) {
                    JOptionPane.showMessageDialog( btnSubmit,"Enter a valid mobile number");
                }
				try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newuser", "root", "12345");
				

	                    String query = "INSERT INTO signup values('" + name+ "','" + age + "','"+gender+"','"+maritalstatus+"','"+ address + "','" +
	                        username + "','" + password + "','" + nationality +"','"+city+"','"+mobileno+"','"+emailid+"','"+idproof+"')";

	                    Statement sta = connection.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(btnSubmit, "This is alredy exist");
				}
	                    else {
	                        JOptionPane.showMessageDialog(btnSubmit, "Your account is sucessfully created");
	                    }
	                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
				
				});
		btnSubmit.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnSubmit.setBounds(473, 412, 125, 23);
		contentPane.add(btnSubmit);
		
		
		
		
	}
}

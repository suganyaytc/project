package AirlineReservation;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JMenuBar;

public class CustomerHome extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textFieldTime;
	private JTable table;
	private JTextField textFc;
	private JTextField textname;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerHome frame = new CustomerHome();
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
	public CustomerHome() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\JAVA\\Project\\imagesonline\\airicon.jpg"));
		setTitle("MY TRIP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 514);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128)));

		setContentPane(contentPane);
		
		ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("images/usericon4.jpg"));
		contentPane.setLayout(null);
		JLabel lblImage = new JLabel(i2);
		lblImage.setBounds(22, 48, 275, 190);
		lblImage.setBackground(new Color(100, 149, 237));
		contentPane.add(lblImage);
	
		JLabel lblsource = new JLabel("Source:");
		lblsource.setBounds(383, 79, 56, 14);
		contentPane.add(lblsource);
		
		JLabel lblDestination = new JLabel("Destination:");
		lblDestination.setBounds(361, 116, 78, 19);
		contentPane.add(lblDestination);
		
		String[] src= {"Chennai","Coimbatore","Madurai","Tiruchy","Tuticorin","Salem","Puducherry"};
		final JComboBox comboSource = new JComboBox(src);
		comboSource.setBounds(449, 77, 169, 19);
		contentPane.add(comboSource);
		
		String[] des= {"Chennai","Coimbatore","Madurai","Tiruchy","Tuticorin","Salem","Puducherry"};
		final JComboBox comboDes = new JComboBox(des);
		comboDes.setBounds(449, 114, 173, 22);
		contentPane.add(comboDes);
		
		JLabel lblNewLabel = new JLabel("Date Of Journey:");
		lblNewLabel.setBounds(351, 168, 106, 22);
		contentPane.add(lblNewLabel);
		
		String[] date= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		String[] month= {"January", "February", "March","April","May","June","July","August","September","October","November","December"};
		String[] year= {"2023","2024","2025"};
		final JComboBox comboDate = new JComboBox(date);
		comboDate.setBounds(453, 168, 49, 22);
		contentPane.add(comboDate);
		
		final JComboBox comboMonth = new JComboBox(month);
		comboMonth.setBounds(500, 168, 68, 22);
		contentPane.add(comboMonth);
		
		final JComboBox comboYear = new JComboBox(year);
		comboYear.setBounds(566, 168, 56, 22);
		contentPane.add(comboYear);
		
		JLabel lblArrivalTime = new JLabel("Arrival Time:");
		lblArrivalTime.setBounds(383, 211, 78, 22);
		contentPane.add(lblArrivalTime);
		
		textFieldTime = new JTextField();
		textFieldTime.setBounds(463, 206, 155, 32);
		contentPane.add(textFieldTime);
		textFieldTime.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Passengers:");
		lblNewLabel_1.setBounds(361, 257, 90, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Class:");
		lblNewLabel_2.setBounds(417, 338, 49, 14);
		contentPane.add(lblNewLabel_2);
		
		String[] s1= {"Economy","Business","Premium Economy"};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final
		JComboBox comboClass = new JComboBox(s1);
		comboClass.setBounds(479, 334, 152, 22);
		contentPane.add(comboClass);
		
		String[] s2= {"1","2","3","4","5","6"};
		final JComboBox comboNo = new JComboBox(s2);
		comboNo.setBounds(479, 302, 146, 22);
		contentPane.add(comboNo);
		
		String[] s3= {"Adult","Child","Infant","Senior Citizen"};
		final JComboBox comboSl = new JComboBox(s3);
		comboSl.setBounds(473, 257, 149, 22);
		contentPane.add(comboSl);
		
		JLabel lblNewLabel_3 = new JLabel("No of Passengers:");
		lblNewLabel_3.setBounds(336, 310, 116, 17);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Name:");
		lblNewLabel_5.setBounds(377, 37, 49, 14);
		contentPane.add(lblNewLabel_5);
		
		textname = new JTextField();
		textname.setBounds(444, 34, 173, 20);
		contentPane.add(textname);
		textname.setColumns(10);
		
		final JButton btnBookNow = new JButton("Book Now");
		btnBookNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String name=textname.getText();
				 String src  = (String) comboSource.getSelectedItem();
				 String dst  = (String) comboDes.getSelectedItem();
				 String date = (String) comboDate.getSelectedItem();
				 String month  = (String) comboMonth.getSelectedItem();
				 String year = (String) comboYear.getSelectedItem();
				 String ArrivalTime=textFieldTime.getText();
				 String s3 = (String) comboSl.getSelectedItem();
				 String s2  = (String) comboNo.getSelectedItem();
				 String s1 = (String) comboClass.getSelectedItem();
				 String flightcode=textFc.getText();
				 try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newuser", "root", "12345");
						String query = "INSERT INTO booking values('" + src+ "','" + dst + "','"+date+"','"+month+"','"+year+ "','" +
			                        ArrivalTime + "','" +s3+ "','" +s2 +"','"+s1+"','"+flightcode+"','"+name+"')";
						Statement sta = connection.createStatement();
			                    int x = sta.executeUpdate(query);
			                    if (x == 0) {
			                        JOptionPane.showMessageDialog(btnBookNow , "This is alredy exist");
						}
			                    else {
			                        JOptionPane.showMessageDialog(btnBookNow , "Make a Payment");
			                    }
			                    connection.close();
		                } catch (Exception exception) {
		                    exception.printStackTrace();
		                }
				 new PaymentDetails().setVisible(true);
		            }
				 });
		btnBookNow.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnBookNow.setBounds(604, 443, 125, 23);
		contentPane.add(btnBookNow);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(62, 380, 179, -140);
		contentPane.add(table);
			
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Home().setVisible(true);
			}
		});
		btnHome.setFont(new Font("Arial", Font.BOLD, 13));
		btnHome.setBounds(72, 249, 169, 23);
		contentPane.add(btnHome);
		
		JButton btnNewButton = new JButton("BookingDetails");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Bookingdetails().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton.setBounds(72, 283, 169, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Payment Details");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Payment().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton_1.setBounds(72, 330, 169, 31);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancel Details");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CancelDetails().setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton_2.setBounds(72, 368, 169, 32);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Find Flights");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FindFlights().setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton_3.setBounds(82, 411, 169, 25);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("Flight code:");
		lblNewLabel_4.setBounds(383, 377, 65, 14);
		contentPane.add(lblNewLabel_4);
		
		textFc = new JTextField();
		textFc.setBounds(472, 374, 159, 20);
		contentPane.add(textFc);
		textFc.setColumns(10);
		
		
		}
	}

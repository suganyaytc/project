package AirlineReservation;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import javax.swing.border.LineBorder;

import com.mysql.cj.jdbc.JdbcPreparedStatement;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import net.proteanit.sql.DbUtils;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;


public  class FindFlights extends JFrame{

	
 JPanel contentPane;
private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindFlights frame = new FindFlights();
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
	public FindFlights() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\JAVA\\Project\\imagesonline\\airicon.jpg"));
		setTitle("MY TRIP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 492);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FLIGHTS INFORMATION");
		lblNewLabel.setBounds(330, 26, 287, 32);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 18));
		contentPane.add(lblNewLabel);
		
		JLabel lblsource = new JLabel("Source:");
		lblsource.setBounds(338, 106, 56, 23);
		lblsource.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(lblsource);
		
		
		String[] src= {"Chennai","Coimbatore","Madurai","Tiruchy","Tuticorin","Salem","Puducherry"};
		final JComboBox comboBox = new JComboBox(src);
		comboBox.setBounds(426, 107, 153, 22);
		contentPane.add(comboBox);
		
		String[] dst= {"Chennai","Coimbatore","Madurai","Tiruchy","Tuticorin","Salem","Puducherry"};
		final JComboBox comboBox_1 = new JComboBox(dst);
		comboBox_1.setBounds(426, 159, 153, 22);
		contentPane.add(comboBox_1);
		
		JLabel lbldestination = new JLabel("Destination:");
		lbldestination.setBounds(321, 158, 104, 23);
		lbldestination.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(lbldestination);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 257, 658, 129);
		scrollPane.setBackground(Color.WHITE);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		table.setBounds(77, 297, 580, 110);
		
		JButton btnSearch= new JButton("SEARCH");
		btnSearch.setBounds(415, 192, 89, 23);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				String src  = (String) comboBox.getSelectedItem();
                 String dst  = (String) comboBox_1.getSelectedItem();
		try{
                   Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newuser","root", "12345");
                    String str = "select * from flights where source=? and destination=?";
                    PreparedStatement st = (PreparedStatement) connection
                            .prepareStatement(str);
                        st.setString(1, src);
                        st.setString(2, dst);
                        ResultSet rs = st.executeQuery();
                        table.setModel(DbUtils.resultSetToTableModel(rs));

		}catch(Exception E) {
		}
		}
	});

		contentPane.add(btnSearch);
		JButton btnBook = new JButton("BOOK");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login().setVisible(true);
			}
		});
		btnBook.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnBook.setBounds(608, 408, 89, 23);
		contentPane.add(btnBook);
		
		ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("images/airicon24.jpg"));
		JLabel lblImage = new JLabel(i2);
		lblImage.setBounds(118, 66, 175, 149);
		contentPane.add(lblImage);
		
	}
}

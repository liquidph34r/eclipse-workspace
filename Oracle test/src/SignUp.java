import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;

public class SignUp extends JFrame{
	
	
	private JPanel contentPane;
	private JTextField FName;
	private JTextField LName;
	private JTextField Email;
	private JTextField Password;
	private JTextField Address;
	private JTextField City;
	private JTextField C_Country;
	private JTextField State;
	private JTextField PostCode;
	private JTextField MiddleI;
	private final JLabel lblsignup = new JLabel("");
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public SignUp() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(212, 11, 126, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 159, 45, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(10, 191, 68, 21);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("First Name:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(10, 68, 68, 21);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Last Name:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(10, 132, 68, 21);
		contentPane.add(lblNewLabel_1_2_1);
		
		FName = new JTextField();
		FName.setBounds(88, 69, 142, 20);
		contentPane.add(FName);
		FName.setColumns(10);
		
		LName = new JTextField();
		LName.setColumns(10);
		LName.setBounds(88, 133, 142, 20);
		contentPane.add(LName);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(54, 160, 142, 20);
		contentPane.add(Email);
		
		Password = new JTextField();
		Password.setColumns(10);
		Password.setBounds(88, 192, 142, 20);
		contentPane.add(Password);
		
		lblsignup.setForeground(Color.RED);
		lblsignup.setBounds(248, 223, 46, 14);
		
		contentPane.add(lblsignup);
		
		JButton SignUp = new JButton("Sign Up!");
		SignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if( (FName.getText().trim().length() != 0) && (LName.getText().trim().length() != 0) && (MiddleI.getText().trim().length() != 0) && (Email.getText().trim().length() != 0) && (Password.getText().trim().length() != 0) && (Address.getText().trim().length() != 0) && (City.getText().trim().length() != 0) && (C_Country.getText().trim().length() != 0) && (State.getText().trim().length() != 0) && (PostCode.getText().trim().length() != 0)) {
					Connection connection;
					try {
						connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook","root","");
						Statement statement = connection.createStatement();
			            statement.executeUpdate("INSERT INTO customer(FirstName, LastName, MiddleInitial, Email, Password, Address, City, State, PostalCode) VALUES('"+(FName.getText().trim())+"','"+(LName.getText().trim())+","+(MiddleI.getText().trim())+"','"+(Email.getText().trim())+"','"+(Password.getText().trim())+"','"+(Address.getText().trim())+"','"+(City.getText().trim())+"','"+(C_Country.getText().trim())+"','"+(State.getText().trim())+"','"+(PostCode.getText().trim()));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Startup startup1 = new Startup();
					startup1.setVisible(true);
					dispose();
				}else {
					lblsignup.setText("Please fill in all fields.");
				}
				
			}
		});
		SignUp.setBounds(231, 261, 89, 23);
		contentPane.add(SignUp);
		
		JLabel lblNewLabel_2 = new JLabel("Basic Information");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(74, 43, 122, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel Country = new JLabel("Country:");
		Country.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Country.setBounds(281, 127, 57, 21);
		contentPane.add(Country);
		
		JLabel s = new JLabel("State:");
		s.setFont(new Font("Tahoma", Font.PLAIN, 13));
		s.setBounds(281, 159, 39, 21);
		contentPane.add(s);
		
		JLabel AddressLine1 = new JLabel("Address Line 1:");
		AddressLine1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		AddressLine1.setBounds(281, 68, 89, 21);
		contentPane.add(AddressLine1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("City:");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1.setBounds(282, 100, 38, 21);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		Address = new JTextField();
		Address.setColumns(10);
		Address.setBounds(380, 69, 142, 20);
		contentPane.add(Address);
		
		City = new JTextField();
		City.setColumns(10);
		City.setBounds(315, 101, 142, 20);
		contentPane.add(City);
		
		C_Country = new JTextField();
		C_Country.setColumns(10);
		C_Country.setBounds(339, 128, 142, 20);
		contentPane.add(C_Country);
		
		State = new JTextField();
		State.setColumns(10);
		State.setBounds(325, 160, 142, 20);
		contentPane.add(State);
		
		JLabel lblNewLabel_2_1 = new JLabel("Shipping Information");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(364, 43, 154, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel p = new JLabel("Postcode/ ZIP:");
		p.setFont(new Font("Tahoma", Font.PLAIN, 13));
		p.setBounds(281, 191, 89, 21);
		contentPane.add(p);
		
		PostCode = new JTextField();
		PostCode.setColumns(10);
		PostCode.setBounds(380, 192, 142, 20);
		contentPane.add(PostCode);
		
		JLabel lblNewLabel_3 = new JLabel("Middle Initial:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(9, 100, 89, 21);
		contentPane.add(lblNewLabel_3);
		
		MiddleI = new JTextField();
		MiddleI.setBounds(98, 100, 25, 20);
		contentPane.add(MiddleI);
		MiddleI.setColumns(10);
		
	
		lblsignup.setForeground(Color.RED);
		lblsignup.setBounds(248, 223, 46, 14);
		
		contentPane.add(lblsignup);
		
}
}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowStateListener;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class CusLogin extends JFrame {

	private JPanel contentPane;
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenuItem mntmHome = new JMenuItem("Home");
	private final JMenuItem mntmOrders = new JMenuItem("Orders");
	private final JMenuItem mntmLogOut = new JMenuItem("LogOut");
	jdbc_test hello = new jdbc_test();
	private final JLabel lblNewLabel_1 = new JLabel("Email:");
	private final JLabel lblNewLabel_1_1 = new JLabel("Password:");
	private final JLabel lblNewLabel_1_2 = new JLabel("First Name:");
	private final JLabel lblNewLabel_1_2_1 = new JLabel("Last Name:");
	private final JTextField lblFName = new JTextField();
	private final JTextField lblLName = new JTextField();
	private final JTextField Email = new JTextField();
	private final JTextField lblPassword = new JTextField();
	private final JLabel lblNewLabel_2 = new JLabel("Basic Information");
	private final JLabel Country = new JLabel("Country:");
	private final JLabel s = new JLabel("State:");
	private final JLabel AddressLine1 = new JLabel("Address Line 1:");
	private final JLabel lblNewLabel_1_2_1_1 = new JLabel("City:");
	private final JTextField Address = new JTextField();
	private final JTextField City = new JTextField();
	private final JTextField C_Country = new JTextField();
	private final JTextField State = new JTextField();
	private final JLabel lblNewLabel_2_1 = new JLabel("Shipping Information");
	private final JLabel p = new JLabel("Postcode/ ZIP:");
	private final JTextField PostalCode = new JTextField();
	private final JLabel lblNewLabel_3 = new JLabel("Middle Initial:");
	private final JTextField MiddleInitial = new JTextField();
	private final JLabel lblNewLabel = new JLabel("User ID:");
	private final JTextField UserID = new JTextField();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CusLogin frame = new CusLogin();
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
	public CusLogin() {
		UserID.setEditable(false);
		UserID.setBounds(62, 221, 86, 20);
		UserID.setColumns(10);
		initGUI();
	}
	private void initGUI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 362);
		
		setJMenuBar(menuBar);
		mntmHome.setBackground(Color.WHITE);
		mntmHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mntmHome.setBackground(Color.LIGHT_GRAY);
			}
			public void mouseExited(MouseEvent e) {
				mntmHome.setBackground(Color.white);
			}
		});
		
		menuBar.add(mntmHome);
		mntmOrders.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mntmOrders.setBackground(Color.LIGHT_GRAY);
			}
			public void mouseExited(MouseEvent e) {
				mntmOrders.setBackground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				new Orders().setVisible(true);
				
			}
		});
		mntmOrders.setBackground(Color.WHITE);
		
		menuBar.add(mntmOrders);
		mntmLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mntmLogOut.setBackground(Color.LIGHT_GRAY);
			}
			public void mouseExited(MouseEvent e) {
				mntmLogOut.setBackground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Startup startup1 = new Startup();
				startup1.setVisible(true);
				dispose();
			}
		});
		mntmLogOut.setBackground(Color.WHITE);
		
		menuBar.add(mntmLogOut);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(11, 152, 45, 21);
		
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(11, 184, 68, 21);
		
		contentPane.add(lblNewLabel_1_1);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(11, 61, 68, 21);
		
		contentPane.add(lblNewLabel_1_2);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(11, 125, 68, 21);
		
		contentPane.add(lblNewLabel_1_2_1);
		lblFName.setEditable(false);
		lblFName.setColumns(10);
		lblFName.setBounds(86, 62, 142, 20);
		
		contentPane.add(lblFName);
		lblLName.setEditable(false);
		lblLName.setColumns(10);
		lblLName.setBounds(86, 126, 142, 20);
		
		contentPane.add(lblLName);
		Email.setEditable(false);
		Email.setColumns(10);
		Email.setBounds(52, 153, 142, 20);
		
		contentPane.add(Email);
		lblPassword.setEditable(false);
		lblPassword.setColumns(10);
		lblPassword.setBounds(86, 185, 142, 20);
		
		contentPane.add(lblPassword);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(62, 36, 122, 14);
		
		contentPane.add(lblNewLabel_2);
		Country.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Country.setBounds(279, 120, 57, 21);
		
		contentPane.add(Country);
		s.setFont(new Font("Tahoma", Font.PLAIN, 13));
		s.setBounds(279, 152, 39, 21);
		
		contentPane.add(s);
		AddressLine1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		AddressLine1.setBounds(279, 61, 89, 21);
		
		contentPane.add(AddressLine1);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1.setBounds(280, 93, 38, 21);
		
		contentPane.add(lblNewLabel_1_2_1_1);
		Address.setEditable(false);
		Address.setColumns(10);
		Address.setBounds(378, 62, 142, 20);
		
		contentPane.add(Address);
		City.setEditable(false);
		City.setColumns(10);
		City.setBounds(313, 94, 142, 20);
		
		contentPane.add(City);
		C_Country.setEditable(false);
		C_Country.setColumns(10);
		C_Country.setBounds(337, 121, 142, 20);
		
		contentPane.add(C_Country);
		State.setEditable(false);
		State.setColumns(10);
		State.setBounds(323, 153, 142, 20);
		
		contentPane.add(State);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(352, 36, 154, 14);
		
		contentPane.add(lblNewLabel_2_1);
		p.setFont(new Font("Tahoma", Font.PLAIN, 13));
		p.setBounds(279, 184, 89, 21);
		
		contentPane.add(p);
		PostalCode.setEditable(false);
		PostalCode.setColumns(10);
		PostalCode.setBounds(378, 185, 142, 20);
		
		contentPane.add(PostalCode);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 93, 89, 21);
		
		contentPane.add(lblNewLabel_3);
		MiddleInitial.setEditable(false);
		MiddleInitial.setColumns(10);
		MiddleInitial.setBounds(96, 93, 25, 20);
		
		contentPane.add(MiddleInitial);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(11, 216, 62, 29);
		
		contentPane.add(lblNewLabel);
		
		contentPane.add(UserID);
		
		
		 System.out.println("Connect to DB");
	       try {
	//step1 load the driver class
	           Class.forName("oracle.jdbc.driver.OracleDriver");

	//step2 create  the connection object
	           Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ORCL", "HR", "oracle");
	           	System.out.println("Database successfully connected");
	           
	//step3 create the statement object
	           
	           PreparedStatement st = conn.prepareStatement("select * from ACCOUNT where email = ? and password = ?");
	           st.setString(1,new Startup().Email);
	           st.setString(2, new Startup().Password);
	           ResultSet rs = st.executeQuery();
	           
	           while(rs.next())
	           {
	        	   Email.setText(rs.getString("Email"));
	        	   lblFName.setText(rs.getString("First_name"));
	        	   lblLName.setText(rs.getString("Last_Name"));
	        	   MiddleInitial.setText(rs.getString("Middle_init"));
	        	   UserID.setText(rs.getString("Account_ID"));
	        	   Address.setText(rs.getString("Default_Shipping_adress"));
	        	   City.setText(rs.getString("Default_Shipping_city"));
	        	   PostalCode.setText(rs.getString("Default_SHipping_zip"));
	        	   C_Country.setText(rs.getString("Default_shipping_country"));
	        	   State.setText(rs.getString("Default_shipping_state"));
	        	  
	        	   
	           }
	         //step5 close the connection object
	           st.close();
	       	conn.close();
	     
	       }catch(Exception e){System.out.println(e); }
			
		
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(11, 152, 45, 21);
		
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(11, 184, 68, 21);
		
		contentPane.add(lblNewLabel_1_1);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(11, 61, 68, 21);
		
		contentPane.add(lblNewLabel_1_2);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(11, 125, 68, 21);
		
		contentPane.add(lblNewLabel_1_2_1);
		lblFName.setColumns(10);
		lblFName.setBounds(86, 62, 142, 20);
		
		contentPane.add(lblFName);
		lblLName.setColumns(10);
		lblLName.setBounds(86, 126, 142, 20);
		
		contentPane.add(lblLName);
		Email.setColumns(10);
		Email.setBounds(52, 153, 142, 20);
		
		contentPane.add(Email);
		lblPassword.setColumns(10);
		lblPassword.setBounds(86, 185, 142, 20);
		
		contentPane.add(lblPassword);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(62, 36, 122, 14);
		
		contentPane.add(lblNewLabel_2);
		Country.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Country.setBounds(279, 120, 57, 21);
		
		contentPane.add(Country);
		s.setFont(new Font("Tahoma", Font.PLAIN, 13));
		s.setBounds(279, 152, 39, 21);
		
		contentPane.add(s);
		AddressLine1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		AddressLine1.setBounds(279, 61, 89, 21);
		
		contentPane.add(AddressLine1);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1.setBounds(280, 93, 38, 21);
		
		contentPane.add(lblNewLabel_1_2_1_1);
		Address.setColumns(10);
		Address.setBounds(378, 62, 142, 20);
		
		contentPane.add(Address);
		City.setColumns(10);
		City.setBounds(313, 94, 142, 20);
		
		contentPane.add(City);
		C_Country.setColumns(10);
		C_Country.setBounds(337, 121, 142, 20);
		
		contentPane.add(C_Country);
		State.setColumns(10);
		State.setBounds(323, 153, 142, 20);
		
		contentPane.add(State);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(352, 36, 154, 14);
		
		contentPane.add(lblNewLabel_2_1);
		p.setFont(new Font("Tahoma", Font.PLAIN, 13));
		p.setBounds(279, 184, 89, 21);
		
		contentPane.add(p);
		PostalCode.setColumns(10);
		PostalCode.setBounds(378, 185, 142, 20);
		
		contentPane.add(PostalCode);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 93, 89, 21);
		
		contentPane.add(lblNewLabel_3);
		MiddleInitial.setColumns(10);
		MiddleInitial.setBounds(96, 93, 25, 20);
		
		contentPane.add(MiddleInitial);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(11, 216, 62, 29);
		
		contentPane.add(lblNewLabel);
		
		contentPane.add(UserID);
		
		
	}

}

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Startup extends JFrame {

	private JPanel contentPane;
	private final JTextField cUser = new JTextField();
	private final JButton btnCustLogin = new JButton("Login!");
	private final JTextField cPass = new JTextField();
	jdbc_test hello = new jdbc_test();
	private final JLabel lblNewLabel = new JLabel("Email:");
	private final JLabel lblNewLabel_1 = new JLabel("Password");
	private final JLabel lblNewLabel_2 = new JLabel("Customer Login");
	private final JLabel lblpassword = new JLabel("");
	CusLogin c1 = new CusLogin();
	public static String Email = "";
	public static String Password = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Startup frame = new Startup();
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
	public Startup() {
		cPass.setBounds(67, 116, 153, 20);
		cPass.setColumns(10);
		cUser.setBounds(67, 78, 153, 20);
		cUser.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.add(cUser);
		btnCustLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		btnCustLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean res = hello.user_login(cUser.getText(),cPass.getText());
				if(res == false) {
					lblpassword.setText("Incorrect Password");
				} else {
					Email = cUser.getText();
					Password = cPass.getText();

					}
			}
		});
		
		
		btnCustLogin.setBounds(91, 174, 89, 23);
		
		contentPane.add(btnCustLogin);
		
		contentPane.add(cPass);
		lblNewLabel.setBounds(11, 81, 46, 14);
		
		contentPane.add(lblNewLabel);
		lblNewLabel_1.setBounds(11, 119, 46, 14);
		
		contentPane.add(lblNewLabel_1);
		lblNewLabel_2.setBounds(106, 11, 74, 14);
		
		contentPane.add(lblNewLabel_2);
		lblpassword.setForeground(Color.RED);
		lblpassword.setBounds(69, 147, 151, 14);
		
		contentPane.add(lblpassword);
	}
}

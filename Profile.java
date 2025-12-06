import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Profile extends JFrame implements ActionListener{
	private JButton logoutButton;
  	private JButton backButton;
  	private JButton exitButton;

  	public Profile(){
    	setResizable(false);
    	setTitle("Hotel Management System");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setBounds(100, 100, 903, 554);
    	setLocationRelativeTo(null);

    	setLayout(new BorderLayout());
    	JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setLayout(null);

        JLabel fullName = new JLabel(Login.fullName);
    	fullName.setBounds(10, 100, 350, 50);
    	fullName.setFont(new Font("Times New Roman", Font.PLAIN, 22));
    	contentPane.add(fullName);
    	
    	JLabel userName = new JLabel("User Name : " + Login.USERNAME);
    	userName.setBounds(10, 150, 300, 50);
    	userName.setFont(new Font("Times New Roman", Font.PLAIN, 22));
    	contentPane.add(userName);
    	
    	JLabel phoneNumber = new JLabel(Login.phoneNumber);
    	phoneNumber.setBounds(10, 200, 300, 50);
    	phoneNumber.setFont(new Font("Times New Roman", Font.PLAIN, 22));  
    	contentPane.add(phoneNumber);
    	
    	JLabel ProfileInformationLbl = new JLabel("Profile Information");
    	ProfileInformationLbl.setHorizontalAlignment(SwingConstants.CENTER);
    	ProfileInformationLbl.setFont(new Font("Pristina", Font.BOLD, 40));
    	ProfileInformationLbl.setBounds(303, 10, 297, 81);
    	contentPane.add(ProfileInformationLbl);

    	exitButton = new JButton("Exit");
    	exitButton.setBounds(809, 486, 70, 21);
    	contentPane.add(exitButton);

    	backButton = new JButton("Back");
    	backButton.setFont(new Font("Tahoma", Font.BOLD, 10));
    	backButton.setBounds(10, 486, 70, 21);
    	contentPane.add(backButton);

    	logoutButton = new JButton("logout");
    	logoutButton.setBounds(809, 10, 70, 21);
    	logoutButton.setFont(new Font("Tahoma", Font.BOLD, 10));
    	contentPane.add(logoutButton);

    	logoutButton.addActionListener(this);
    	backButton.addActionListener(this);
    	exitButton.addActionListener(this);

    	add(contentPane, BorderLayout.CENTER);
    	setVisible(true);
  	}

  	public void actionPerformed(ActionEvent event){
  		if (event.getSource() == logoutButton) {
      			int yesORno =JOptionPane.showConfirmDialog(null, "Are you sure ?", "Alert!", JOptionPane.YES_NO_OPTION);

      		if (yesORno == JOptionPane.YES_OPTION) {
        		this.setVisible(false);
        		new Login();
      		}
    	}

    	else if (event.getSource() == backButton) {
      		this.setVisible(false);
      		new UserDashBoard();
    	}

    	else if (event.getSource() == exitButton) {
      		int yesORno =JOptionPane.showConfirmDialog(null, "Do you want to exit ?", "Alert!", JOptionPane.YES_NO_OPTION);

      		if (yesORno == 0) {
        		System.exit(1);
      		}
    	}
  	}
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminDashBoard extends JFrame implements ActionListener{
	private JButton checkIn_button;
	private JButton checkOut_button;
	private JButton chat_button;
	private JButton logout_button;

	public AdminDashBoard(){
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hotel Management System");
		setBounds(100, 100, 927, 533);
		setLocationRelativeTo(null);

		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setLayout(null);

		JLabel welcomelb = new JLabel("Welcome");
		welcomelb.setFont(new Font("Lucida Handwriting", Font.PLAIN, 35));
		welcomelb.setHorizontalAlignment(SwingConstants.CENTER);
		welcomelb.setBounds(254, 11, 389, 78);
		contentPane.add(welcomelb);

		checkIn_button = new JButton("Check-In");
		checkIn_button.setBounds(109, 162, 120, 40);
		contentPane.add(checkIn_button);

		checkOut_button = new JButton("Check-Out");
		checkOut_button.setBounds(695, 162, 120, 40);
		contentPane.add(checkOut_button);

		chat_button = new JButton("Chat");
		chat_button.setBounds(408, 162, 85, 40);
		contentPane.add(chat_button);

		logout_button = new JButton("Logout");
		logout_button.setBounds(780, 440, 85, 31);
		contentPane.add(logout_button);

		logout_button.addActionListener(this);
		chat_button.addActionListener(this);
		checkIn_button.addActionListener(this);
		checkOut_button.addActionListener(this);

		add(contentPane);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent event){
		if(event.getSource() == logout_button){
			int yesORno =JOptionPane.showConfirmDialog( null, "Are you sure ?", "Alert!", JOptionPane.YES_NO_OPTION);
    
          	if (yesORno == JOptionPane.YES_OPTION) {
            	setVisible(false);
           		new Login();
          	}
		}

		else if(event.getSource() == checkIn_button){
			setVisible(false);
			new CheckIn();
		}

		else if(event.getSource() == checkOut_button){
			setVisible(false);
			new CheckOut();
		}

		else if(event.getSource() == chat_button){
			setVisible(false);
			new Help_Desk();
		}
	}
}
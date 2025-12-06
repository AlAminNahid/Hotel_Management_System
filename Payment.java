import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Payment extends JFrame implements ActionListener{
	JLabel bikash_lbl;
	JButton back_button;
	JButton next_button;
	JTextField number_fld;
	JPasswordField password_fld;
	protected static boolean pay=false;

	public Payment(){
		setTitle("Payment");
		setResizable(false);
		setBounds(100, 100, 903, 554);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon img = new ImageIcon("./images/BkashPayment.png");
    	Image i = img.getImage();
    	Image new_img = i.getScaledInstance(854, 580, Image.SCALE_SMOOTH);
    	img = new ImageIcon(new_img);

    	bikash_lbl = new JLabel("", img, JLabel.CENTER);
    	bikash_lbl.setBounds(-190, -220, 854, 580);

    	number_fld = new JTextField();
    	number_fld.setBounds(260, 250, 300, 25);

    	password_fld = new JPasswordField();
    	password_fld.setBounds(260, 380, 300, 25);

    	back_button = new JButton("Back");
    	back_button.setFont(new Font("Abadi", Font.BOLD, 15));
    	back_button.setBackground(Color.BLACK);
    	// back_button.setForeground(Color.WHITE);
    	back_button.setBounds(720, 460, 80, 25);

    	next_button = new JButton("Next");
		next_button.setFont(new Font("Abadi", Font.BOLD, 15));
		next_button.setBackground(Color.BLACK);
		// next_button.setForeground(Color.WHITE);
		next_button.setBounds(620, 460, 80, 25);
		
		back_button.addActionListener(this);
		next_button.addActionListener(this);
		
		this.add(number_fld);
		this.add(password_fld);
		this.add(back_button);
		this.add(next_button);
		this.add(bikash_lbl);

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent event){
		
		if(event.getSource() == back_button){
			this.setVisible(false);
			new CheckOut();
		}

		else if(event.getSource() == next_button){
			pay=true;
			JOptionPane.showMessageDialog(null, "Payment Confirmed \n Thank You For Staying With Us");
			JOptionPane.showMessageDialog(null, "Check Out Successful");
			

			if(!Login.isAdmin){
				this.setVisible(false);
				new UserDashBoard();
			}
			else{
				this.setVisible(false);
				// new AdminDashBoard();
			}
		}
	}
}
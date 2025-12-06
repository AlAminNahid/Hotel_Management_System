import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmployeeDashboard extends JFrame implements ActionListener {
    private JButton profile_button;
    private JButton chat_button;
    private JButton logout_button;

    public EmployeeDashboard() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Employee Dashboard");
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

        profile_button = new JButton("Profile");
        profile_button.setBounds(780, 50, 85, 31);
        contentPane.add(profile_button);

        chat_button = new JButton("Chat");
        chat_button.setBounds(408, 162, 85, 40);
        contentPane.add(chat_button);

        logout_button = new JButton("Logout");
        logout_button.setBounds(780, 440, 85, 31);
        contentPane.add(logout_button);

        logout_button.addActionListener(this);
        chat_button.addActionListener(this);
        profile_button.addActionListener(this);

        add(contentPane);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == logout_button) {
            int yesORno = JOptionPane.showConfirmDialog(null, "Are you sure?", "Alert!", JOptionPane.YES_NO_OPTION);

            if (yesORno == JOptionPane.YES_OPTION) {
                setVisible(false);
                new Login();
            }
        } else if (event.getSource() == profile_button) {
            setVisible(false);
            new EmployeeProfile();
        } else if (event.getSource() == chat_button) {
            setVisible(false);
            new Chat();
        }
    }

    public static void main(String[] args) {
        new EmployeeDashboard();
    }
}

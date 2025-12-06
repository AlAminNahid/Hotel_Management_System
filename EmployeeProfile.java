import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class EmployeeProfile extends JFrame implements ActionListener {
    private JButton logoutButton;
    private JButton backButton;

    public EmployeeProfile() {
        // System.out.println("Currently in Profile class");
        setTitle("Employee Profile");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        nameLabel.setBounds(100, 40, 100, 20);
        contentPane.add(nameLabel);

        JLabel mobileLabel = new JLabel("Mobile:");
        mobileLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        mobileLabel.setBounds(100, 80, 100, 20);
        contentPane.add(mobileLabel);

        JLabel nationalityLabel = new JLabel("Nationality:");
        nationalityLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        nationalityLabel.setBounds(100, 120, 120, 20);
        contentPane.add(nationalityLabel);
        JLabel salaryLabel = new JLabel("Salary:");
        salaryLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        salaryLabel.setBounds(100, 160, 100, 20);
        contentPane.add(salaryLabel);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        ageLabel.setBounds(100, 200, 100, 20);
        contentPane.add(ageLabel);

        JLabel designationLabel = new JLabel("Designation:");
        designationLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        designationLabel.setBounds(100, 240, 120, 20);
        contentPane.add(designationLabel);

        JLabel nidLabel = new JLabel("NID:");
        nidLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        nidLabel.setBounds(100, 280, 100, 20);
        contentPane.add(nidLabel);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        genderLabel.setBounds(100, 320, 100, 20);
        contentPane.add(genderLabel);

        // Add labels to display values for the additional fields
        JLabel salaryValueLabel = new JLabel();
        salaryValueLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        salaryValueLabel.setBounds(270, 160, 300, 20);
        contentPane.add(salaryValueLabel);
        JLabel ageValueLabel = new JLabel();
        ageValueLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        ageValueLabel.setBounds(270, 200, 300, 20);
        contentPane.add(ageValueLabel);

        JLabel designationValueLabel = new JLabel();
        designationValueLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        designationValueLabel.setBounds(270, 240, 300, 20);
        contentPane.add(designationValueLabel);

        JLabel nidValueLabel = new JLabel();
        nidValueLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        nidValueLabel.setBounds(270, 280, 300, 20);
        contentPane.add(nidValueLabel);

        JLabel genderValueLabel = new JLabel();
        genderValueLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        genderValueLabel.setBounds(270, 320, 300, 20);
        contentPane.add(genderValueLabel);


        // Add other labels for the additional fields (Salary, Age, Designation, NID, Gender)

        JLabel nameValueLabel = new JLabel();
        nameValueLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        nameValueLabel.setBounds(270, 40, 300, 20);
        contentPane.add(nameValueLabel);

        JLabel mobileValueLabel = new JLabel();
        mobileValueLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        mobileValueLabel.setBounds(270, 80, 300, 20);
        contentPane.add(mobileValueLabel);

        JLabel nationalityValueLabel = new JLabel();
        nationalityValueLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        nationalityValueLabel.setBounds(270, 120, 300, 20);
        contentPane.add(nationalityValueLabel);

        // Add other labels for the additional field values

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(690, 20, 80, 30);
        logoutButton.addActionListener(this);
        contentPane.add(logoutButton);

        backButton = new JButton("Back");
        backButton.setBounds(20, 530, 80, 30);
        backButton.addActionListener(this);
        contentPane.add(backButton);

        try {
            FileReader fileReader = new FileReader("./data/employee_records.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(":"); // Split by colon
                if (parts.length >= 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
        
                    switch (key) {
                        case "Name":
                            nameValueLabel.setText(value);
                            break;
                        case "Mobile":
                            mobileValueLabel.setText(value);
                            break;
                        case "Nationality":
                            nationalityValueLabel.setText(value);
                            break;
                        case "Salary":
                            salaryValueLabel.setText(value);
                            break;
                        case "Age":
                            ageValueLabel.setText(value);
                            break;
                        case "Designation":
                            designationValueLabel.setText(value);
                            break;
                        case "NID":
                            nidValueLabel.setText(value);
                            break;
                        case "Gender":
                            genderValueLabel.setText(value);
                            break;
                        
                    }
                }
            }
            bufferedReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        setContentPane(contentPane);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == logoutButton) {
            int yesORno = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Alert", JOptionPane.YES_NO_OPTION);
            if (yesORno == JOptionPane.YES_OPTION) {
                this.setVisible(false);
                // System.out.println("Exited from Profile class");
                new Login();
            }
        } else if (event.getSource() == backButton) {
            this.setVisible(false);
            // System.out.println("Exited from Profile class");
            // Assuming you have a class named EmployeeDashboard for the employee dashboard
            new EmployeeDashboard(); // Replace with the actual class name
        }
    }

    public static void main(String[] args) {
        new EmployeeProfile();
    }
}

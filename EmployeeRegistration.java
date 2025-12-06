import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class EmployeeRegistration extends JPanel implements ActionListener {

    private JFrame frame;
    private JTextField nameField;
    private JTextField mobileField;
    private JTextField nationalityField;
    private JTextField salaryField;
    private JTextField ageField;
    private JTextField designationField;
    private JTextField nidField;

    private JComboBox<String> genderBox;

    private JButton registerButton;
    private JButton backButton;

    public EmployeeRegistration() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 500, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setTitle("Employee Registration");

        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 50, 80, 20);
        contentPane.add(nameLabel);
        nameField = new JTextField();
        nameField.setBounds(100, 50, 150, 20);
        contentPane.add(nameField);

        JLabel mobileLabel = new JLabel("Mobile:");
        mobileLabel.setBounds(10, 80, 80, 20);
        contentPane.add(mobileLabel);
        mobileField = new JTextField();
        mobileField.setBounds(100, 80, 150, 20);
        contentPane.add(mobileField);

        JLabel nationalityLabel = new JLabel("Nationality:");
        nationalityLabel.setBounds(10, 110, 80, 20);
        contentPane.add(nationalityLabel);
        nationalityField = new JTextField();
        nationalityField.setBounds(100, 110, 150, 20);
        contentPane.add(nationalityField);

        JLabel salaryLabel = new JLabel("Salary:");
        salaryLabel.setBounds(10, 140, 80, 20);
        contentPane.add(salaryLabel);
        salaryField = new JTextField();
        salaryField.setBounds(100, 140, 150, 20);
        contentPane.add(salaryField);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(10, 170, 80, 20);
        contentPane.add(ageLabel);
        ageField = new JTextField();
        ageField.setBounds(100, 170, 150, 20);
        contentPane.add(ageField);

        JLabel designationLabel = new JLabel("Designation:");
        designationLabel.setBounds(10, 200, 80, 20);
        contentPane.add(designationLabel);
        designationField = new JTextField();
        designationField.setBounds(100, 200, 150, 20);
        contentPane.add(designationField);

        JLabel nidLabel = new JLabel("NID:");
        nidLabel.setBounds(10, 230, 80, 20);
        contentPane.add(nidLabel);
        nidField = new JTextField();
        nidField.setBounds(100, 230, 150, 20);
        contentPane.add(nidField);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(10, 260, 80, 20);
        contentPane.add(genderLabel);
        genderBox = new JComboBox<>();
        genderBox.setModel(new DefaultComboBoxModel<>(new String[]{"Male", "Female", "Others"}));
        genderBox.setBounds(100, 260, 100, 20);
        contentPane.add(genderBox);

        registerButton = new JButton("Register");
        registerButton.setBounds(10, 300, 100, 30);
        registerButton.addActionListener(this);
        contentPane.add(registerButton);

        backButton = new JButton("Back");
        backButton.setBounds(120, 300, 100, 30);
        backButton.addActionListener(this);
        contentPane.add(backButton);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            String name = nameField.getText();
            String mobile = mobileField.getText();
            String nationality = nationalityField.getText();
            String salary = salaryField.getText();
            String age = ageField.getText();
            String designation = designationField.getText();
            String nid = nidField.getText();
            String gender = (String) genderBox.getSelectedItem();

            if (!name.isEmpty() && !mobile.isEmpty() && !nationality.isEmpty() &&
                    !salary.isEmpty() && !age.isEmpty() && !designation.isEmpty() && !nid.isEmpty()) {

                try {
                    File file = new File("./data/employee_records.txt");
                    FileWriter fileWriter = new FileWriter(file, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    PrintWriter printWriter = new PrintWriter(bufferedWriter);

                    printWriter.println("===============================================");
                    printWriter.println("Name: " + name);
                    printWriter.println("User Name: employee");
                    printWriter.println("Mobile: " + mobile);
                    printWriter.println("Nationality: " + nationality);
                    printWriter.println("Salary: " + salary);
                    printWriter.println("Age: " + age);
                    printWriter.println("Designation: " + designation);
                    printWriter.println("NID: " + nid);
                    printWriter.println("Gender: " + gender);

                    printWriter.close();
                    JOptionPane.showMessageDialog(null, "Employee registered successfully!",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "An error occurred while registering the employee.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please fill all the fields.",
                        "Error", JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource() == backButton) {
            frame.setVisible(false);
            new UserDashBoard();
        }
    }

    public static void main(String[] args) {
      new EmployeeRegistration();
    }
}

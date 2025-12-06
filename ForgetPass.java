import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.event.*;

public class ForgetPass extends JFrame implements ActionListener {

  private int deleteLine;
  private JTextField userField;
  private JButton resetButton;
  private JTextField phoneField;
  private JButton backButton;
  private JPasswordField newPass;
  private JPasswordField confirmPass;

  public ForgetPass() {
    // System.out.println("Currently in ForgetPass class");
    setResizable(false);
    setTitle("Hotel Management System");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 903, 554);
    setLocationRelativeTo(null);

    setLayout(new BorderLayout());  // Use a layout manager
    JPanel formPanel = new JPanel();
    formPanel.setLayout(null);

    JLabel forget = new JLabel("Reset Password");
    forget.setFont(new Font("Times New Roman", Font.PLAIN, 22));
    forget.setBounds(363, 10, 147, 50);
    formPanel.add(forget);

    JLabel username = new JLabel("Username:");
    username.setFont(new Font("Times New Roman", Font.PLAIN, 22));
    username.setBounds(504, 100, 120, 25);
    formPanel.add(username);

    userField = new JTextField();
    userField.setBounds(608, 100, 180, 25);
    userField.setFont(new Font("Times New Roman", Font.BOLD, 18));
    formPanel.add(userField);


    backButton = new JButton("Back");
    backButton.setFont(new Font("Tahoma", Font.BOLD, 10));
    backButton.setBounds(10, 486, 70, 21);
    formPanel.add(backButton);

    phoneField = new JTextField();
    phoneField.setBounds(610, 150, 180, 30);
    phoneField.setFont(new Font("Times New Roman", Font.BOLD, 18));
    formPanel.add(phoneField);

    JLabel phone = new JLabel("Phone No :");
    phone.setFont(new Font("Times New Roman", Font.PLAIN, 22));
    phone.setBounds(491, 150, 109, 25);
    formPanel.add(phone);
 
    JLabel newPasslabel = new JLabel("New Password :");
    newPasslabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
    newPasslabel.setBounds(450, 190, 147, 37);
    formPanel.add(newPasslabel);

    newPass = new JPasswordField();
    newPass.setBounds(610, 190, 180, 37);
    newPass.setFont(new Font("Monospace", Font.BOLD, 18));
    newPass.setEchoChar('*');
    formPanel.add(newPass);

    JLabel confirmPassLbl = new JLabel("Confirm Password :");
    confirmPassLbl.setFont(new Font("Times New Roman", Font.PLAIN, 22));
    confirmPassLbl.setBounds(420, 240, 184, 37);
    formPanel.add(confirmPassLbl);

    confirmPass = new JPasswordField();
    confirmPass.setBounds(610, 240, 180, 36);
    confirmPass.setFont(new Font("Monospace", Font.BOLD, 18));
    confirmPass.setEchoChar('*');
    formPanel.add(confirmPass);

    resetButton = new JButton("Reset Password");
    resetButton.setBounds(640, 300, 130, 40);
    formPanel.add(resetButton);

    resetButton.addActionListener(this);
    backButton.addActionListener(this);

    add(formPanel, BorderLayout.CENTER); // Add the form panel to the frame

    this.setVisible(true);
  }

  

public void actionPerformed(ActionEvent e) {
    String user = "User Name   : " + userField.getText();
    boolean userEmpty = userField.getText().isEmpty();
    boolean notFound = true;
    int totalLines = 0;

    String phone = "Phone Number: " + phoneField.getText();
    boolean phoneEmpty = phoneField.getText().isEmpty();
    boolean Found = false;

    String pass = "Password    : " + String.valueOf(newPass.getPassword());
    boolean passEmpty = pass.isEmpty();

    String ConfirmPass = "Password    : " + String.valueOf(confirmPass.getPassword());

    if (e.getSource() == resetButton) {
        try {
            File userfile = new File("./data/user_login.txt");
            if (userfile.exists()) {
                FileReader fileReader= new FileReader("./data/user_login.txt");
                BufferedReader readFile= new BufferedReader(fileReader);
                //BufferedReader readFile = new BufferedReader(file);
                while (readFile.readLine() != null) {
                    totalLines++;
                    // System.out.println(totalLines);
                }
                readFile.close();
            }
            if (userEmpty) {
                JOptionPane.showMessageDialog(null, "Enter User Name", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                for (int i = 0; i < totalLines; i++) {
                    String line = Files.readAllLines(Paths.get("./data/user_login.txt")).get(i);
                    if (line.equals(user)) {
                        // System.out.println("User name found  "+i);
                        deleteLine = i;
                        notFound = false;
                        break;
                    }
                }
                if (notFound) {
                    // System.out.println("User Name not found");
                    JOptionPane.showMessageDialog(null, "User not found", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }

            if (!notFound) {
                if (phoneEmpty) {
                    JOptionPane.showMessageDialog(null, "Enter phone number", "Error", JOptionPane.WARNING_MESSAGE);
                } 
                else {
                    int n = ((deleteLine) + 1);
                    String line = Files.readAllLines(Paths.get("./data/user_login.txt")).get(n);
                    if (line.equals(phone)) {
                        // System.out.println("User phonenumber found");
                        Found = true;
                    }

                    if (!Found) {
                        // System.out.println("Phone number  not found");
                        JOptionPane.showMessageDialog(null, "User not found", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                    if (passEmpty || !String.valueOf(newPass.getPassword()).equals(String.valueOf(confirmPass.getPassword()))) {
                        // System.out.println("Password mismatch");
                        JOptionPane.showMessageDialog(null, "Please fill with the same password in both fields", "Error", JOptionPane.WARNING_MESSAGE);
                    }

                    if (Found && !notFound && !passEmpty && String.valueOf(newPass.getPassword()).equals(String.valueOf(confirmPass.getPassword()))) {
                        try {
                            File tempFile = new File("./data/user_login_temp.txt");
                            FileWriter fileWriter = new FileWriter(tempFile);
                            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                            // PrintWriter printWriter = new PrintWriter(bufferedWriter);

                            FileReader fileReader= new FileReader("./data/user_login.txt");
                            BufferedReader readFile= new BufferedReader(fileReader);

                            // totalLines = 0;
                            // readFile = new BufferedReader(new FileReader("./files/user_login.txt"));
                            // while (readFile.readLine() != null) {
                            //     totalLines++;
                            // }
                            // readFile.close();
///////////////////////////////////////////////////////////
                            // int changeLine=0;
                            // for (int i = 2; i < totalLines; i++) {
                            //     line = Files.readAllLines(Paths.get("./files/user_login.txt")).get(i);
                            //     if (line.equals(user)) {
                            //         changeLine = i+1;
                            //         System.out.println(changeLine); 
                            //     }
                            //     if (i == changeLine) {
                            //             fileWriter.write(pass+ "/n");
                            //             System.out.println(changeLine);
                            //             //bufferedWriter.write(pass + "/n");
                            //             // printWriter.println(pass);
                            //             System.out.println("Password Changed");
                                        
                            //         }
                            //         else{
                            //             fileWriter.write(line+ "/n");
                            //             // printWriter.println(line);
                            //         }
                            //         // printWriter.close();
                            //         fileWriter.close();
                            // }
///////////////////////////////////////////////////////////
                                String currentLine=readFile.readLine();
                                while (currentLine != null) {
                                    if (currentLine.equals(user)) {
                                     bufferedWriter.write(currentLine + "\n"); // Write the username line
                                     bufferedWriter.write(pass + "\n");        // Write the new password
                                     Found=true;
                                    //passwordChanged = true;
                                    }
                                    else {
                                        if(Found){
                                            Found=false;
                                        }
                                        else{
                                            bufferedWriter.write(currentLine + "\n"); // Write other lines unchanged
                                        }
                                        // bufferedWriter.write(currentLine + "\n"); // Write other lines unchanged
                                    }
                                    currentLine = readFile.readLine();
                                    // bufferedWriter.close();
                                }
                                bufferedWriter.close();
                                readFile.close();

                                File originalFile = new File("./data/user_login.txt");
                                if (originalFile.exists()) {
                                    originalFile.delete();
                                }
                                tempFile.renameTo(originalFile);

                            // int yesORno = JOptionPane.showConfirmDialog(null, "Password Reset Successful. Want to go to the login page?", "Success!", JOptionPane.YES_NO_OPTION);

                            // if (yesORno == 0) {
                                if(JOptionPane.showConfirmDialog(null, "Password Reset Successful. Want to go to the login page?", "Success!", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                                // System.out.println("Exited from ForgetPass class");
                                this.setVisible(false);
                                new Login();
                            }
                            readFile.close();
                        } catch (IOException ioe) {
                            // System.out.println("Username file error");
                            JOptionPane.showMessageDialog(null, "User Not Found", "Warning!", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
            }
        } catch (IOException ioe) {
            // System.out.println("Username file error");
            JOptionPane.showMessageDialog(null, "User Not Found", "Warning!", JOptionPane.WARNING_MESSAGE);
        }
    } else if (e.getSource() == backButton) {
        this.setVisible(false);
        // System.out.println("Exited from ForgetPass class");
        new Login();
    }
}

  

//   public static void main(String[] args) {
//     new ForgetPass();
//   }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SignUp extends JFrame implements ActionListener{
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPassField;
    private JTextField fullField;
    private JButton signin;
    private JButton signup;
    private JTextField phoneNumberField;


        public SignUp() {
        // System.out.println("Currently in Signup class");
        setResizable(false);
        setTitle("Hotel Management System");
        setLocationRelativeTo(null);    
        setVisible(true);   
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 903, 554);
        
        try{
            setIconImage(Toolkit.getDefaultToolkit().getImage(SignUp.class.getResource("/resources/titleIcon.PNG")));
        } catch (NullPointerException f){
            f.printStackTrace();
        }

        setLayout(new BorderLayout());  // Use a layout manager
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);

        JLabel SignUpText = new JLabel("SIGN UP");
        SignUpText.setFont(new Font("Verdana", Font.BOLD, 22));
        SignUpText.setBounds(210, 10, 114, 30);
        formPanel.add(SignUpText);

        JLabel fullName = new JLabel("Full Name :");
        fullName.setFont(new Font("Verdana", Font.PLAIN, 17));
        fullName.setBounds(11, 68, 106, 30);
        formPanel.add(fullName);

        fullField = new JTextField();
        fullField.setBounds(193, 68, 248, 30);
        fullField.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        formPanel.add(fullField);

        JLabel username = new JLabel("User Name :");
        username.setBounds(11, 105, 114, 30);
        username.setFont(new Font("Verdana", Font.PLAIN, 17));
        formPanel.add(username);

        usernameField = new JTextField();
        usernameField.setBounds(193, 105, 248, 30);
        usernameField.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        formPanel.add(usernameField);

        JLabel phoneNumber = new JLabel("Phone Number :");
        phoneNumber.setFont(new Font("Verdana", Font.PLAIN, 17));
        phoneNumber.setBounds(11, 148, 150, 27);
        formPanel.add(phoneNumber);

        phoneNumberField = new JTextField();
        phoneNumberField.setBounds(193, 148, 248, 30);
        phoneNumberField.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        formPanel.add(phoneNumberField);

        JLabel password = new JLabel("Password :");
        password.setFont(new Font("Verdana", Font.PLAIN, 17));
        password.setBounds(11, 189, 106, 30);
        formPanel.add(password);

        passwordField = new JPasswordField();
        passwordField.setBounds(193, 189, 248, 30);
        passwordField.setFont(new Font("Verdana", Font.PLAIN, 18));
        passwordField.setEchoChar('*');
        formPanel.add(passwordField);

        JLabel confirmPassTxt = new JLabel("Confirm Password :");
        confirmPassTxt.setFont(new Font("Verdana", Font.PLAIN, 17));
        confirmPassTxt.setBounds(10, 229, 173, 30);
        formPanel.add(confirmPassTxt);

        confirmPassField = new JPasswordField();
        confirmPassField.setBounds(193, 229, 248, 30);
        confirmPassField.setFont(new Font("Verdana", Font.PLAIN, 18));
        confirmPassField.setEchoChar('*');
        formPanel.add(confirmPassField);

        signin = new JButton("Already have an account?");
        signin.setFont(new Font("Papyrus", Font.BOLD, 17));
        signin.setBounds(331, 405, 264, 47);
        formPanel.add(signin);

        signup = new JButton("Sign up");
        signup.setFont(new Font("Tahoma", Font.BOLD, 15));
        signup.setBounds(213, 298, 110, 34);
        formPanel.add(signup);
    
        signup.addActionListener(this);
        signin.addActionListener(this);

        add(formPanel, BorderLayout.CENTER); // Add the form panel to the frame
        this.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    // Get user input
    String user = usernameField.getText(); // Get username
    String pass = String.valueOf(passwordField.getPassword()); // Get password
    String confpass = String.valueOf(confirmPassField.getPassword()); // Get confirmed password
    String name = fullField.getText(); // Get full name
    String PhoneNumber = phoneNumberField.getText(); // Get phone number

    // Check if fields are empty
    boolean userEmpty = user.isEmpty(); // Check if username is empty
    boolean passEmpty = pass.isEmpty(); // Check if password is empty
    boolean confEmpty = confpass.isEmpty(); // Check if confirmed password is empty
    boolean nameEmpty = name.isEmpty(); // Check if full name is empty
    boolean emailEmpty = PhoneNumber.isEmpty(); // Check if phone number is empty

    // Check if password matches confirmed password
    boolean check = pass.equals(confpass);
    boolean phonecheck=false;
    try {
      Integer.parseInt(PhoneNumber);
  } catch (NumberFormatException nfe) {
      phonecheck=true;
      // System.out.println("Phone Number Check function");
  }


    if (e.getSource() == signup) {
      if (userEmpty || passEmpty || confEmpty || nameEmpty || emailEmpty) {
        // Display an error message if any field is empty
        JOptionPane.showMessageDialog(
            null, "Please fill all of the fields.", "Error!", JOptionPane.WARNING_MESSAGE);
      }
       else if (!validateUsername(user)) {
        // Display an error message for invalid username
        JOptionPane.showMessageDialog(
            null,"No Spaces is allowed. Please enter a valid username between 3 to 10 characters.","Error!",JOptionPane.WARNING_MESSAGE);
      } 
        else if (phonecheck) {
            // Display an error message for invalid phone number
            JOptionPane.showMessageDialog(
             null, "Invalid Phone Number", " Error!", JOptionPane.WARNING_MESSAGE);/////////////////////////////checking for character
       } 
      else if (!check) {
        // Display an error message if password doesn't match
        JOptionPane.showMessageDialog(
            null, "Password does not match", " Error!", JOptionPane.WARNING_MESSAGE);/////////////////////checking with keyboard or focus action event. security flaws
      } 
      else {
        try {
          File file = new File("./data/user_login.txt");
          if (!file.exists()) {
            // Create a new file if it doesn't exist
            boolean created = file.createNewFile();
            if (created) {
              // System.out.println("User Login File created successfully.");
            } else {
              // System.out.println("User Login File creation failed.");
            }
          }
          FileWriter fileWriter = new FileWriter(file, true);
          BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
          PrintWriter printWriter = new PrintWriter(bufferedWriter);

          LocalDateTime myDateObj = LocalDateTime.now();
          DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");

          String timeAndDate = myDateObj.format(myFormatObj);

          // User Login file checked
          int totalLines = 0; // Check the total lines in User Login file
          BufferedReader readFile = new BufferedReader(new FileReader("./data/user_login.txt"));
          while (readFile.readLine() != null) {
            totalLines++;
          }
          readFile.close();

          boolean userflag = false;

          // for user
          for (int i=0;i<totalLines;i++) { // Check if the username already exists in User Login file
            String line = Files.readAllLines(Paths.get("./data/user_login.txt")).get(i);//////////////////////////////reading whole file  in every iteration. not memory concious 
            if (line.equals("User Name : " + user)) {
              userflag = true;
              // System.out.println("User name exists");
              break;
            }
          }

          if (!userflag) {
            // If username is not taken, add user information to the file
            printWriter.println("===============================================");
            printWriter.println("Full Name   : " + name);
            printWriter.println("User Name   : " + user);
            printWriter.println("Password    : " + pass);
            printWriter.println("Phone       : " + PhoneNumber);
            printWriter.println("Time & Date : " + timeAndDate);
            printWriter.println("===============================================");

            // System.out.println("New User details added");
            int yesORno = JOptionPane.showConfirmDialog(
              null, "Registration Succesful. Want to go to login page?", "Warning", JOptionPane.YES_NO_OPTION);

              if (yesORno == 0) {
              // System.out.println("Exited from Signup class");
              this.setVisible(false);
              new Login();
          } 
            
      }
      else {
            //Display a warning message if username is already taken
            int yesORno = JOptionPane.showConfirmDialog(
                null, "User name already taken. Want to go to login page?", "Warning", JOptionPane.YES_NO_OPTION);

              if (yesORno == 0) {
              // System.out.println("Exited from Signup class");
              this.setVisible(false);
              new Login();
              }
          }

          printWriter.close();

        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    }
      if (e.getSource() == signin) {
      this.setVisible(false);
      // System.out.println("Exited from Signup class");
      new Login();
    } 
  }
  

  public boolean validateUsername(String username) {
    // System.out.println("validateUsername function called");
    // Check for spaces
    if (username.contains(" ")) {
      return false;
    }

    // Check length
    int length = username.length();
    // System.out.println("validateUsername function executed successfully");
    return length >= 3 && length <= 10;

  }
}


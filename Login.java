import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Login extends JFrame implements ActionListener{
	//adding buttons.
    private JButton loginButton;
    private JButton signUpButton;
    private JButton forgetButton;

    //adding textfield & passwordfield.
    //where we will write our username & password.
    private JTextField userNameField;
    private JPasswordField passwordField;

    //some needed variables.
    protected static boolean isAdmin;
    protected static boolean loginFlag;
    protected static String USERNAME;
    protected static String fullName="";
    protected static String phoneNumber;
    protected static String fullUserName;
    protected static String oldPassword;
    public static String filePath;
	private static int n=0;
	protected static  String x="";

    public Login() {
        // System.out.println("Currently in Login class");

        //frame works.
        setTitle("The Grand Sultan");
        setSize(903, 554);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //setting icon for login page.
        

        //setting a layout.
        setLayout(new BorderLayout());

        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);

        //an image has been added using this in the login page.
      


        JLabel loginTxt = new JLabel("LOGIN");
        loginTxt.setFont(new Font("Verdana", Font.BOLD, 22));
        loginTxt.setBounds(677, 79, 83, 30);
        contentPane.add(loginTxt);

        JLabel usernameTxt = new JLabel("Username");
        usernameTxt.setFont(new Font("Verdana", Font.PLAIN, 18));
        usernameTxt.setBounds(603, 141, 94, 30);
        contentPane.add(usernameTxt);

        JLabel passwordTxt = new JLabel("Password");
        passwordTxt.setFont(new Font("Verdana", Font.PLAIN, 18));
        passwordTxt.setBounds(603, 223, 94, 30);
        contentPane.add(passwordTxt);

        JLabel loginMassageTxt = new JLabel("Welcome to Grand Sultan");
        loginMassageTxt.setFont(new Font("Modern No. 20", Font.PLAIN, 30));
        loginMassageTxt.setBounds(72, 42, 404, 82);
        contentPane.add(loginMassageTxt);

        userNameField = new JTextField();
        userNameField.setFont(new Font("Times New Roman", Font.BOLD, 17));
        userNameField.setBounds(603, 181, 205, 30);
        contentPane.add(userNameField);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Verdana", Font.BOLD, 17));
        passwordField.setEchoChar('*');
        passwordField.setBounds(603, 276, 205, 30);
        contentPane.add(passwordField);

        forgetButton = new JButton("Forgot Pass");
        forgetButton.setFont(new Font("Dialog", Font.BOLD, 10));
        forgetButton.setBounds(687, 311, 120, 19);
        contentPane.add(forgetButton);

        signUpButton = new JButton("Don't have an account?");
        signUpButton.setFont(new Font("Calibri", Font.BOLD, 14));
        signUpButton.setBounds(637, 410, 189, 30);
        contentPane.add(signUpButton);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        loginButton.setBounds(653, 345, 153, 40);
        contentPane.add(loginButton);

        //adding those buttons to action listener.
        forgetButton.addActionListener(this);
        signUpButton.addActionListener(this);
        loginButton.addActionListener(this);

        add(contentPane, BorderLayout.CENTER); //adding jpanel and layout to the frame.
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event){
    	// Get the user input from the username and password fields
    	String user = userNameField.getText();
    	String password = String.valueOf(passwordField.getPassword());

    	// Check if the username and password fields are empty
    	boolean userEmpty = user.isEmpty();
    	boolean passwordEmpty = password.isEmpty();

    	// Check which button was clicked
    	if(event.getSource() == forgetButton){
    		// If the "forgot" button was clicked, go to the ForgotPass page
    		setVisible(false); // Hide the login frame and show the forgetpass page
    		// System.out.println("Exited from login class");
    		new ForgetPass();
    	}

    	else if(event.getSource() == signUpButton){
    		// If the "signup" button was clicked, go to the signup page
    		setVisible(false); // Hide the login frame and show the signup page
    		// System.out.println("Exited from login class");
    		new SignUp();
    	}

    	else if(event.getSource() == loginButton){
    		//first creating a direactory using this.
    		try{
    			File adminFileObj = new File("./data");
    			adminFileObj.mkdir();

    			filePath = adminFileObj.getAbsolutePath(); //getting the the location of the directroy and store it in a string.
    		} catch(Exception excep){
    			excep.printStackTrace();
    		}
    		//check if the username and password fields are filled
    		if(userEmpty || passwordEmpty){
    			JOptionPane.showMessageDialog(null, "Pleae fill all the fields.", "Warning!", JOptionPane.WARNING_MESSAGE);
    		}

    		else {
    			boolean userbool = false; // Flag to check if the user is an user or not.
    			isAdmin = false; // Flag to check if the user is an admin or not.

    			try{
    				// Create strings for the username and password
    				String username = "User Name   : " + user;
    				String pass =     "Password    : " + password;
    				
    				// Check if the admin login file exists, if not create it.
    				File adminFile = new File(filePath + "/admin_login.txt");

    				if(!adminFile.exists()){
    					adminFile.createNewFile();
    				}

    				//reading the user name & password from the admin_login.txt file and store them in adminUserName & adminPassword.
    				BufferedReader adminReader = new BufferedReader(new FileReader(adminFile));
    				String adminUserName = adminReader.readLine();    				
    				String adminPassword = adminReader.readLine();

    				adminReader.close();

    				// Check if the user is an admin by reading the admin login file. if true then go to AdminDashBoard.
					if( userNameField.getText().equals("employee")){
						x="employee";
						String Line;
						// System.out.println(String.valueOf(passwordField.getPassword()));
						
						BufferedReader userreader = new BufferedReader(new FileReader(filePath + "/employee_records.txt"));
						while ((Line = userreader.readLine()) !=null) {
								n++;
								// if(n==1){
								// 	fullName = userReader.readLine();
								// }

    							if (Line.equals("Mobile: "+String.valueOf(passwordField.getPassword()))) {
        							// System.out.println("User found");
        							new EmployeeDashboard();
								}
						}
					
						userreader.close();
					}
					
    				if(username.equals(adminUserName) && pass.equals(adminPassword)){
    					isAdmin = true;
    					// loginFlag = true;
    					USERNAME = username;
    					// System.out.println("Admin login successful");
    					// Hide the login frame and show the admin dashboard
    					setVisible(false);
    					new AdminDashBoard();
    				} 

    				// Check if the user is a regular user
    				if (!isAdmin){
    					// Check if the user is not an admin
    					// Read the user_login.txt file
    					File userFile = new File(filePath + "/user_login.txt");

    					if(userFile.exists()){
    						// Check if the file exists
    						// Create a buffered reader to read the file
    						BufferedReader userReader = new BufferedReader(new FileReader(filePath + "/user_login.txt"));
    						String line;
							

    						//check each line of the user_login.txt for username and password.
							while ((line = userReader.readLine()) !=null) {
								n++;
								// if(n==1){
								// 	fullName = userReader.readLine();
								// }

    							if (line.equals(username)) {
        							// System.out.println("User found");
        							String line2 = userReader.readLine(); // Read the next line (password line)
        							if (line2.equals(pass)) {
            							// System.out.println("Password matched with username");
            							loginFlag = true;
							            userbool = true;
							            USERNAME = user;
							            phoneNumber = userReader.readLine();
							            oldPassword = line2;
							            fullUserName = username;
							            // System.out.println("Exited from Login class");
							            // Hide the login frame and show the User dashboard
							            this.setVisible(false);
							        	
							            break;

							        }
							    }
							}
							userReader.close();
							BufferedReader userreader = new BufferedReader(new FileReader(filePath + "/user_login.txt"));
							int x=0;
							while ((line = userreader.readLine()) !=null) {
								x++;
								if(x==n-2){
									fullName = userreader.readLine();
									break;
								}
							}
							userreader.close();

							

							
    					}
    				}
    				// If the login is unsuccessful, show an error message
    				if(!userNameField.getText().equals("employee")){
						if (!userbool && !isAdmin){
    					JOptionPane.showMessageDialog(null, "Invalid Name or Password!", "Warning", JOptionPane.WARNING_MESSAGE);
    				}  	}			
    			} catch (Exception ex){
    				ex.printStackTrace();
    				JOptionPane.showMessageDialog(null, "An error occurred. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
    			}
    		}
			if(loginFlag){
				new UserDashBoard();
				// new Chat();
			}
    	}
    }
	
}

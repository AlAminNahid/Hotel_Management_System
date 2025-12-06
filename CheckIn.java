//package myclasses;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;


public class CheckIn extends JPanel implements ActionListener{

    private JFrame frame;
    private JTextField name_field;
    private JTextField mbl_fld;
    private JTextField nationality_fld;
    private JTextField mail_fld;
    private JTextField address_fld;
    private JTextField date_fld;
    private JTextField cost_fld;

    private JComboBox<String> bed_Box;
    private JComboBox<String> roomType_Box;
    private JComboBox<String> roomNo_Box;
    private JComboBox<String> gender_Box;

    private JButton back_btn;
    private JButton confirm_btn;
    private JButton logOut_Btn;

    public String roomNo;
    
    public CheckIn() {
        // System.out.println("Currently in CheckIn class");
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 927, 533);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setTitle("Check In");

        // setLayout(new BorderLayout());  // Use a layout manager
        // JPanel formPanel = new JPanel();
        // formPanel.setLayout(null);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        frame.setContentPane(contentPane);
        contentPane.setLayout(null);
    
        JLabel checkIn_lbl = new JLabel("Check In");
        checkIn_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
        checkIn_lbl.setBounds(10, 3, 180, 34);
        contentPane.add(checkIn_lbl);
    
        JLabel fullName_lbl = new JLabel("Full Name");
        fullName_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        fullName_lbl.setBounds(10, 74, 141, 34);
        contentPane.add(fullName_lbl);
    
        name_field = new JTextField();
        name_field.setBounds(10, 109, 218, 20);
        contentPane.add(name_field);
        name_field.setColumns(10);
    
        JLabel mblNum_lbl = new JLabel("Mobile Number");
        mblNum_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        mblNum_lbl.setBounds(10, 151, 141, 34);
        contentPane.add(mblNum_lbl);
    
        JLabel nationality_lbl = new JLabel("Nationality");
        nationality_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        nationality_lbl.setBounds(10, 231, 141, 34);
        contentPane.add(nationality_lbl);
    
        JLabel gender_lbl = new JLabel("Gender");
        gender_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        gender_lbl.setBounds(10, 298, 141, 34);
        contentPane.add(gender_lbl);
    
        JLabel mail_lbl = new JLabel("mail");
        mail_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        mail_lbl.setBounds(10, 379, 141, 34);
        contentPane.add(mail_lbl);
    
        mbl_fld = new JTextField();
        mbl_fld.setColumns(10);
        mbl_fld.setBounds(10, 187, 218, 20);
        contentPane.add(mbl_fld);
    
        nationality_fld = new JTextField();
        nationality_fld.setColumns(10);
        nationality_fld.setBounds(10, 267, 218, 20);
        contentPane.add(nationality_fld);
    
        mail_fld = new JTextField();
        mail_fld.setColumns(10);
        mail_fld.setBounds(10, 415, 218, 20);
        contentPane.add(mail_fld);
    
        gender_Box = new JComboBox<>();
        gender_Box.setModel(new DefaultComboBoxModel<>(new String[] {"Male", "Female", "Others"}));
        gender_Box.setBounds(10, 342, 76, 22);
        contentPane.add(gender_Box);
    
        JLabel address = new JLabel("Address");
        address.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        address.setBounds(324, 74, 141, 34);
        contentPane.add(address);
    
        address_fld = new JTextField();
        address_fld.setColumns(10);
        address_fld.setBounds(324, 109, 218, 20);
        contentPane.add(address_fld);
    
        date_fld = new JTextField();
        date_fld.setColumns(10);
        date_fld.setBounds(324, 187, 218, 20);
        date_fld.setEditable(false);
        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        date_fld.setText(myFormat.format(cal.getTime()));
        contentPane.add(date_fld);
    
        JLabel date = new JLabel("Date(Today)");
        date.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        date.setBounds(324, 151, 141, 34);
        contentPane.add(date);
    
        JLabel bed_lbl = new JLabel("Bed");
        bed_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        bed_lbl.setBounds(650, 74, 141, 34);
        contentPane.add(bed_lbl);
    
        JLabel roomType_lbl = new JLabel("Room Type");
        roomType_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        roomType_lbl.setBounds(650, 152, 141, 34);
        contentPane.add(roomType_lbl);
    
        JLabel roomNo_lbl = new JLabel("Room No");
        roomNo_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        roomNo_lbl.setBounds(650, 231, 141, 34);
        contentPane.add(roomNo_lbl);
    
        JLabel cost_lbl = new JLabel("Total Cost");
        cost_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        cost_lbl.setBounds(650, 309, 141, 34);
        contentPane.add(cost_lbl);
    
        bed_Box = new JComboBox<>();
        bed_Box.setModel(new DefaultComboBoxModel<>(new String[] {"Single", "Double", "Triple"}));
        bed_Box.setBounds(650, 108, 133, 22);
        bed_Box.addActionListener(this);
        contentPane.add(bed_Box);
    
        cost_fld = new JTextField();
        cost_fld.setEditable(false);
        cost_fld.setBounds(650, 344, 218, 20);
        contentPane.add(cost_fld);
    
        roomType_Box = new JComboBox<>();
        roomType_Box.setModel(new DefaultComboBoxModel<>(new String[] {"AC", "Non-Ac"}));
        roomType_Box.setBounds(650, 186, 133, 22);
        roomType_Box.addActionListener(this);
        contentPane.add(roomType_Box);
    
        roomNo_Box = new JComboBox<>();
        roomNo_Box.setBounds(650, 266, 133, 22);
        roomNo_Box.addActionListener(this);
        contentPane.add(roomNo_Box);
    
        back_btn = new JButton("Back");
        back_btn.setBounds(779, 435, 89, 23);
        back_btn.addActionListener(this);
        contentPane.add(back_btn);
    
        confirm_btn = new JButton("Confirm Book");
        confirm_btn.setBounds(261, 399, 176, 52);
        confirm_btn.addActionListener(this);
        contentPane.add(confirm_btn);
    
        logOut_Btn = new JButton("Log Out");
        logOut_Btn.setBounds(812, 11, 89, 23);
        logOut_Btn.addActionListener(this);
        contentPane.add(logOut_Btn);
        
        

        // add(contentPane, BorderLayout.CENTER);
        frame.setVisible(true);
      }
    
      @Override
      public void actionPerformed(ActionEvent e) {
    
        String name = name_field.getText();
        String mobileNumber = mbl_fld.getText();
        String nationality = nationality_fld.getText();
        String mail = mail_fld.getText();
        String address = address_fld.getText();
        String CheckInDate = date_fld.getText();
        String cost = cost_fld.getText();
        String gender = (String) gender_Box.getSelectedItem();
        String roomNo_B = (String) roomNo_Box.getSelectedItem();
    
        boolean isNameFieldEmpty = name_field.getText().isEmpty();
        boolean isMobileNumberFieldEmpty = mbl_fld.getText().isEmpty();
        boolean isNationalityFieldEmpty = nationality_fld.getText().isEmpty();
        boolean isMailEmpty = mail_fld.getText().isEmpty();
        boolean isAddressEmpty = address_fld.getText().isEmpty();
        boolean isCheckInDateEmptyField = date_fld.getText().isEmpty();
        boolean isCostFieldEmpty = cost_fld.getText().isEmpty();
        boolean phonecheck=false;
        
    
        if (e.getSource() == back_btn) {
          frame.setVisible(false);
          // System.out.println("Exited from CheckIn class");  //@
          new UserDashBoard();
        } 
        else if (e.getSource() == logOut_Btn) { 
          int yesORno =JOptionPane.showConfirmDialog( null, "Are you sure ?", "Alert!", JOptionPane.YES_NO_OPTION);
    
          if (yesORno == JOptionPane.YES_OPTION) {
            frame.setVisible(false);
            // System.out.println("Exited from CheckIn class");
            new Login();
          }
        } 
       
        
        else if (e.getSource() == confirm_btn) {
          try {
          Integer.parseInt(mobileNumber);
      } catch (NumberFormatException nfe) {
          phonecheck=true;
      }
          if (!(isNameFieldEmpty && isMobileNumberFieldEmpty && isNationalityFieldEmpty && isMailEmpty && isAddressEmpty && isCheckInDateEmptyField && isCostFieldEmpty)) {
    
            
              if (!(mail.contains("@"))) {
                if (!(mail.contains("."))) {
                
              JOptionPane.showMessageDialog(null, "Invalid Mail Address", "Error", JOptionPane.WARNING_MESSAGE);

            } 
          }
            else if (phonecheck) {
              JOptionPane.showMessageDialog(
               null, "Invalid Phone Number", " Error!", JOptionPane.WARNING_MESSAGE);
            }
            else {
                try {
                  File file = new File("./data/checkIn.txt");
                  if (!file.exists()) {
                    boolean create = file.createNewFile();
                    if (create) {
                      // System.out.println("Checkin File created successfully.");
                    } else {
                      // System.out.println("Checkin File creation failed.");
                    }
                  }
                  else {
                    // System.out.println("File already exists.");
                  }
                  FileWriter fileWriter = new FileWriter(file, true);
                  BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                  PrintWriter printWriter = new PrintWriter(bufferedWriter);
                  // Write check-in details to the file
                  printWriter.println("===============================================");
                  printWriter.println(name );
                  printWriter.println(roomNo_B);
                  printWriter.println("Gender:" + gender);
                  printWriter.println("Mobile Number:" + mobileNumber);
                  printWriter.println("Nationality:" + nationality);
                  printWriter.println("Email:" + mail);
                  printWriter.println("Address:" + address);
                  printWriter.println(CheckInDate);
                  printWriter.println(cost);
                  printWriter.println("Booked");
    
                  printWriter.close();
                  // System.out.println("New checkIn data stored successfully");
    
                  try {
                    // Input room number to search for
                    String roomNo = String.valueOf(roomNo_Box.getSelectedItem());
                    // Create a temporary file to write updated data to
                    File tempFile = new File("./data/temp.txt");
                    // System.out.println("temp file created");

                    FileWriter filewriter = new FileWriter(tempFile, true);
                    BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
                    PrintWriter pw = new PrintWriter(bufferedwriter);
                    // System.out.println("Writing into temp file");

                    FileReader fileReader= new FileReader("./data/rooms.txt");
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    // System.out.println("Reading from room.txt");

                    String change;
                    while ((change = bufferedReader.readLine()) != null) {
                      if (change.equals("===============================================")) {
                        String[] store = new String[5]; // create an array with 5 elements
                        for (int i = 0; i < 5; i++) {
                          // read the next 5 lines and add the data to the corresponding column
                          store[i] = bufferedReader.readLine();
                          // System.out.println("reading room.txt");
                        }
                        if (store[0].equals(roomNo)) { // if the room number is a match
                          // System.out.println("Room found");
                          store[4] = "Booked"; // update the status
                          // System.out.println("Updated room status to Booked");
                        }
                        // write the updated row data to the temporary file
                        pw.println("===============================================");
                        // System.out.println("Updating data to temp file");
                        for (int i = 0; i < 5; i++) {
                          pw.println(store[i]);
                        }
                      } 
                      else {
                        // write non-"Room Details" lines to the temporary file unchanged
                        pw.println(change);
                      }
                    }
                    bufferedReader.close();
                    pw.close();
                    // Replace the original file with the temporary file
                    File originalFile = new File("./data/rooms.txt");
                    if (originalFile.delete()) {
                      boolean Renamed = tempFile.renameTo(originalFile);
                      if (Renamed) {
                        // System.out.println("The temporary file has been successfully replaced with the original");
                      } else {
                        // System.out.println("Failed to replace the original file with the temporary file.");
                      }
                    } 
                    else {
                      // System.out.println("Failed to delete the original file before replacement.");
                    }
                  } catch (Exception ex) {
                    ex.printStackTrace();
                  }
    
                  JOptionPane.showMessageDialog( null, "Checked In", "Done", JOptionPane.INFORMATION_MESSAGE);
                  // System.out.println("Check-in successfull");
                  // Clearing the input fields
                  name_field.setText(null);
                  mbl_fld.setText(null);
                  nationality_fld.setText(null);
                  mail_fld.setText(null);
                  address_fld.setText(null);
                  cost_fld.setText(null);
                  gender_Box.setSelectedIndex(0);
                  bed_Box.setSelectedIndex(0);
                  roomType_Box.setSelectedIndex(0);
                  // System.out.println("All data cleared from Text Field and Combo Box set to Default");
    
                } 
                catch (Exception ex) {
                  ex.printStackTrace();
                }
            }
          } 
          else {
            JOptionPane.showMessageDialog(
                null, "Please Fill all the box", "Error", JOptionPane.WARNING_MESSAGE);
          }
        } 
        else if (e.getSource() == bed_Box) {
          // Update room details based on selected bed type
          String bed = (String) bed_Box.getSelectedItem();
          String roomtype = (String) roomType_Box.getSelectedItem();

          roomNo_Box.removeAllItems();
          cost_fld.setText(null);
          try {
          FileReader fileReader= new FileReader("./data/rooms.txt");
          BufferedReader bufferedReader = new BufferedReader(fileReader);
          String line;
          while ((line = bufferedReader.readLine()) != null) {
            if (line.equals("===============================================")) {
            String[] check = new String[5]; // create an array with 5 elements
            System.out.println("bed array \n ");
            for (int i = 0; i < 5; i++) {
            // read the next 5 lines and add the data to the corresponding column
                check[i] = bufferedReader.readLine();
                // System.out.println(check[i]);
            }
            if (check[1].equals(roomtype) && check[2].equals(bed) && check[4].equals("Not Booked")) {
              roomNo_Box.addItem(check[0]); // add the room number to the combo
            }
          }
        }
              bufferedReader.close();
          }
          catch (Exception ex) {
            ex.printStackTrace();
          }
    
        } 

        else if (e.getSource() == roomType_Box) {
          // Update room details based on selected room type
          String bed = (String) bed_Box.getSelectedItem();
          String roomtype = (String) roomType_Box.getSelectedItem();

          roomNo_Box.removeAllItems();
          cost_fld.setText(null);

          try {
          FileReader fileReader= new FileReader("./data/rooms.txt");
          BufferedReader bufferedReader = new BufferedReader(fileReader);
          String line;
          while ((line = bufferedReader.readLine()) != null) {
            if (line.equals("===============================================")) {
            String[] check = new String[5]; // create an array with 5 elements
            System.out.println("room type array \n ");
            for (int i = 0; i < 5; i++) {
            // read the next 5 lines and add the data to the corresponding column
                check[i] = bufferedReader.readLine();
                // System.out.println(check[i]);
            }
            if (check[1].equals(roomtype) && check[2].equals(bed) && check[4].equals("Not Booked")) {
              roomNo_Box.addItem(check[0]); // add the room number to the combo
            }
          }
        }
              bufferedReader.close();
          } 
    
    catch (Exception ex) {
      ex.printStackTrace();
    }
    
        }
        
        else if (e.getSource() == roomNo_Box) {
          roomNo = (String) roomNo_Box.getSelectedItem(); // Get the selected room number
          try {
            FileReader fileReader= new FileReader("./data/rooms.txt");
          BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
              if (line.equals("===============================================")) {
                String[] store = new String[5]; // create an array with 5 elements
                // System.out.println("room no. array \n ");
                for (int i = 0; i < 5; i++) {
                  // read the next 4 lines and add the data to the corresponding column
                  store[i] = bufferedReader.readLine();
                  // System.out.println(store[i]);
                }
                if (store[0].equals(roomNo)) {
                  // Set the cost in the cost_fld
                  cost_fld.setText(store[3]);
                }
              }
            }
            bufferedReader.close();
          } catch (Exception ex) {
            ex.printStackTrace();
          }
        }
      }
    }
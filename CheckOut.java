import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class CheckOut extends JFrame implements ActionListener, ICheckOutRoomSearch{
	private JTextField CustomerName_fld;
  	private JTextField CustomerNum_fld;
  	private JTextField checkInDate_fld;
  	private JTextField pricePerDay_fld;
  	private JTextField dayStay_fld;
  	private JTextField totalAmount_fld;
  	private JTextField email_fld;
  	private JComboBox <String> comboBox;
  	private JButton logOut_btn;
  	private JButton back_btn;
  	private JButton checkOut_btn;

  	String name;
  	String mobileNumber;
  	String nationality;
  	String gmail;
  	String address;
  	String CheckinDate;
  	String gender;
  	String roomNo_B;
  	String roomType;
  	String bed;
  	String roomPrice;
  	String checkOutRoomNo;

  	public CheckOut(){
    	setResizable(false);
    	setTitle("Checkout");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setBounds(100, 100, 927, 533);
    	setLocationRelativeTo(null);

    	setLayout(new BorderLayout());
    	JPanel contentPane = new JPanel();
      contentPane.setBackground(Color.LIGHT_GRAY);
    	contentPane.setLayout(null);

    	logOut_btn = new JButton("Log Out");
    	logOut_btn.setBounds(812, 11, 89, 23);
    	contentPane.add(logOut_btn);

    	JLabel checkOut_lbl = new JLabel("CheckOut");
    	checkOut_lbl.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
    	checkOut_lbl.setBounds(10, 3, 180, 34);
    	contentPane.add(checkOut_lbl);

    	back_btn = new JButton("Back");
    	back_btn.setBounds(702, 11, 89, 23);
    	contentPane.add(back_btn);

    	JLabel customerNameLbl = new JLabel("Customer Name");
    	customerNameLbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    	customerNameLbl.setBounds(21, 80, 150, 23);
    	contentPane.add(customerNameLbl);

    	JScrollPane scrollPane = new JScrollPane();
    	scrollPane.setBounds(10, 318, 891, 139);
    	contentPane.add(scrollPane);


    	JLabel checkInDate_lbl = new JLabel("Check In Date");
    	checkInDate_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    	checkInDate_lbl.setBounds(251, 80, 97, 23);
    	contentPane.add(checkInDate_lbl);

    	JLabel checkOutDate_lbl = new JLabel("Check Out (Today)");
    	checkOutDate_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    	checkOutDate_lbl.setBounds(479, 80, 150, 23);
    	contentPane.add(checkOutDate_lbl);

    	JLabel customerNumberLbl = new JLabel("Customer Mobile Number");
    	customerNumberLbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    	customerNumberLbl.setBounds(702, 78, 180, 26);
    	contentPane.add(customerNumberLbl);

    	CustomerName_fld = new JTextField();
    	CustomerName_fld.setBounds(21, 113, 151, 20);
    	CustomerName_fld.setEditable(false);
    	contentPane.add(CustomerName_fld);

    	CustomerNum_fld = new JTextField();
    	CustomerNum_fld.setEditable(false);
    	CustomerNum_fld.setBounds(702, 113, 160, 20);
    	contentPane.add(CustomerNum_fld);

    	checkOut_btn = new JButton("Check Out");
    	checkOut_btn.setBounds(25, 284, 97, 23);
    	contentPane.add(checkOut_btn);

    	checkInDate_fld = new JTextField();
    	checkInDate_fld.setEditable(false);
    	checkInDate_fld.setBounds(251, 114, 151, 20);
    	contentPane.add(checkInDate_fld);

    	JTextField checkOut_fld = new JTextField();
    	checkOut_fld.setEditable(false);
    	checkOut_fld.setBounds(479, 113, 151, 20);

    	SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyy");
    	Calendar cal = Calendar.getInstance();

    	checkOut_fld.setText(myFormat.format(cal.getTime()));
    	contentPane.add(checkOut_fld);

    	JLabel priceDay_lbl = new JLabel("Price Per Day");
    	priceDay_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    	priceDay_lbl.setBounds(21, 168, 89, 23);
    	contentPane.add(priceDay_lbl);

    	JLabel numberOfDays_lbl = new JLabel("Number Of Days Stay");
    	numberOfDays_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    	numberOfDays_lbl.setBounds(251, 168, 180, 23);
    	contentPane.add(numberOfDays_lbl);

    	JLabel totalAmount_lbl = new JLabel("Total Amount");
    	totalAmount_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    	totalAmount_lbl.setBounds(479, 168, 126, 23);
    	contentPane.add(totalAmount_lbl);

    	JLabel email_lbl = new JLabel("Email");
    	email_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    	email_lbl.setBounds(702, 166, 44, 26);
    	contentPane.add(email_lbl);

    	pricePerDay_fld = new JTextField();
    	pricePerDay_fld.setEditable(false);
    	pricePerDay_fld.setBounds(21, 201, 151, 20);
    	contentPane.add(pricePerDay_fld);

    	dayStay_fld = new JTextField();
    	dayStay_fld.setEditable(false);
    	dayStay_fld.setBounds(251, 202, 151, 20);
    	contentPane.add(dayStay_fld);

    	totalAmount_fld = new JTextField();
    	totalAmount_fld.setEditable(false);
    	totalAmount_fld.setBounds(479, 201, 151, 20);
    	contentPane.add(totalAmount_fld);

    	email_fld = new JTextField();
    	email_fld.setEditable(false);
    	email_fld.setBounds(702, 201, 160, 20);
    	contentPane.add(email_fld);

    	JLabel roomNum_lbl = new JLabel("Room Number");
    	roomNum_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    	roomNum_lbl.setBounds(187, 32, 106, 23);
    	contentPane.add(roomNum_lbl);

    	comboBox = new JComboBox<>();
    	comboBox.setBounds(303, 35, 151, 20);
    	contentPane.add(comboBox);
    

    	
    	roomSearch();

    	logOut_btn.addActionListener(this);
    	back_btn.addActionListener(this);
    	checkOut_btn.addActionListener(this);
    	comboBox.addActionListener(this);

    	add(contentPane, BorderLayout.CENTER);
    	this.setVisible(true);
	}

  	public void actionPerformed(ActionEvent event){
    	if (event.getSource() == logOut_btn) {
      		int yesORno =
          	JOptionPane.showConfirmDialog(null, "Are you sure ?", "Alert!", JOptionPane.YES_NO_OPTION);
      		if (yesORno == JOptionPane.YES_OPTION) {
        		this.setVisible(false);
        		new Login();
      		}
  		}

  		else if(event.getSource() == back_btn){
      		if(!Login.isAdmin){
            this.setVisible(false);
            new UserDashBoard();
          }
          else{
            this.setVisible(false);
            new AdminDashBoard();
          }
  		}
  		else if(event.getSource() == checkOut_btn){
  			if (comboBox.getSelectedItem()==null) {
        		JOptionPane.showMessageDialog(null, "Select a Room to Checkout", "Error", JOptionPane.WARNING_MESSAGE);
      		}

      		else{
      			if (JOptionPane.showConfirmDialog(null, "Are You Sure?", "Confirmation", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION) {
          			 new Payment();
					 
					 try {
            			String roomNo = (String) comboBox.getSelectedItem();
            			File tempFile = new File("./data/temp.txt");
						
						FileWriter fw=new FileWriter(tempFile);
						BufferedWriter bw=new BufferedWriter(fw);
            			PrintWriter pw = new PrintWriter(bw);

						FileReader fr=new FileReader("./data/rooms.txt");
            			BufferedReader br = new BufferedReader(fr);
            			String check;
            			while ((check = br.readLine()) != null) {
            			  if (check.equals("===============================================")) {
                			String[] store = new String[5];
                			for (int i = 0; i < 5; i++) {
                  			store[i] = br.readLine();
                			}
                			if (store[0].equals(roomNo)) {
                  				store[4] = "Not Booked";
                			}
                			pw.println("===============================================");
                			for (int i = 0; i < 5; i++) {
                  				pw.println(store[i]);
                			}
              			} 
              			else {
                			pw.println(check);
              			}
            		}
            		br.close();
            		pw.close();

            		File originalFile = new File("./data/rooms.txt");
            		if (originalFile.delete()) {
            			tempFile.renameTo(originalFile);
            	} 
				} 
					catch (Exception ex) {
            			ex.printStackTrace();
          			}
				
				checkOutRoomNo =(String)comboBox.getSelectedItem();

			        deleteRoomEntry();
					clearFields();
                	comboBox.removeAllItems();
                	roomSearch();
            }
					clearFields();
      			}
          	}
				// else{
				// 	if (JOptionPane.showConfirmDialog(null, "Please Complete your Payment", "Confirmation", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION) {
          		// 	 new Payment();
				// }

          			

      			if (event.getSource() == comboBox) {
					try (BufferedReader br = new BufferedReader(new FileReader("./data/CheckIn.txt"))) {
      					String line;
      					while ((line = br.readLine()) != null) {
        				if (line.equals("===============================================")) {
          					String[] store = new String[10];
          					for (int i = 0; i < 10; i++) {
            					store[i] = br.readLine();
          				}
						if(store[1].equals((String)comboBox.getSelectedItem())){
							name=store[0];
							CheckinDate=store[7];
							String m=store[3];
							mobileNumber=m.replace("Mobile Number:", "");
							roomPrice= store[8];
							String n=store[5];
							gmail=n.replace("Email:", "");
						}


        			}
      			}
    		} 
				catch (Exception e) {
     				 e.printStackTrace();
    			}
					CustomerName_fld.setText(name);
					checkInDate_fld.setText(CheckinDate);
					CustomerNum_fld.setText(mobileNumber);
					pricePerDay_fld.setText(roomPrice);
					email_fld.setText(gmail);
          		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
            	Calendar cal = Calendar.getInstance();
            	String dateBeforeString = CheckinDate;//"21/08/2023"
            	Date dateBefore;
            try {
                dateBefore = myFormat.parse(dateBeforeString);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            } 
          		String dateAfterString = myFormat.format(cal.getTime());   //@
          		Date dateAfter;
          		try {
            		dateAfter = myFormat.parse(dateAfterString);
          		} catch (ParseException ex) {
            		throw new RuntimeException(ex);
          		}
          		long difference = dateAfter.getTime() - dateBefore.getTime();
          		int noOfDayStay = (int) (difference / (1000 * 60 * 60 * 24));
          		
          		if (noOfDayStay == 0) {
            		noOfDayStay = 1;
          		}
          		
          		dayStay_fld.setText(String.valueOf(noOfDayStay));
          		
          		if(pricePerDay_fld.getText() != null){
                float price = Float.parseFloat(pricePerDay_fld.getText());
                totalAmount_fld.setText(String.valueOf(noOfDayStay * price));
              }
        	}
		}
      	// }

  public void deleteRoomEntry() {
    try {
      File inputFile = new File("./data/checkIn.txt");
      File tempFile = new File("./data/checkIn_temp.txt");

      BufferedReader reader = new BufferedReader(new FileReader(inputFile));
      BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

      String currentLine;
      int count=0;
      int lineCounter= 0;
      int startLine = 0;
      int endLine = 0;
      while ((currentLine = reader.readLine()) != null) {
        lineCounter++;
        if (currentLine.contains(checkOutRoomNo)) {
          startLine=lineCounter-2;
          endLine=lineCounter+9;
        }
      }
      
      while ((currentLine = reader.readLine()) != null) {
        lineCounter++;
    
        if (lineCounter >= startLine && lineCounter <= endLine) {
          continue;
      }
  
      writer.write(currentLine + "\n");
  }
  
  writer.close();
  reader.close();

      inputFile.delete();

      tempFile.renameTo(inputFile);

    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public void roomSearch() {
    try (BufferedReader br = new BufferedReader(new FileReader("./data/rooms.txt"))) {
      String change;
      while ((change = br.readLine()) != null) {
        if (change.equals("===============================================")) {
          String[] store = new String[5];
          for (int i = 0; i < 5; i++) {
            store[i] = br.readLine();
          }
          if (store[4].equals("Booked")) {
            comboBox.addItem(store[0]);
          }
        }
      }
	  comboBox.setSelectedIndex(-1);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public void clearFields(){
    	CustomerName_fld.setText(null);
        CustomerNum_fld.setText(null);
        checkInDate_fld.setText(null);
        pricePerDay_fld.setText(null);
        dayStay_fld.setText(null);
        totalAmount_fld.setText(null);
        email_fld.setText(null);
        comboBox.setSelectedIndex(-1);
  }



  
}

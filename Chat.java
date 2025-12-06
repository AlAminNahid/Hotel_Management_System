import javax.swing.*;
import java.awt.event.*;
import java.io.*;


public class Chat extends JFrame implements ActionListener {
    private JButton backButton;
    private JTextArea textArea;
    private JTextField inputField;
    private JButton sendButton;
    private Timer refreshTimer;
    protected static String fromadmin="#";
    private String from_admin=fromadmin;
    private String name=null;
    // private String fileName;
    // protected Boolean fileName.uRead;
    // protected Boolean aRead;

    public Chat() {
        if(from_admin.equals("#")){
             if (!Login.isAdmin && !Login.x.equals("employee")){
            name = Login.fullName.replace("Full Name   : ", "");
            // System.out.println(name);
        }
        // if(from_admin.equals("#")){
        //      if (!Login.isAdmin){
        //     name = Login.fullName.replace("Full Name   : ", "");
        //     System.out.println(name);
        // }
        else{
            name = "employee";
        }
        //   name = "User"; ///for testing purpose
        }
        else{
            name=from_admin;
            setLocationRelativeTo(null);
        }
        
        
        setTitle("Help Center");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(null);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 10, 560, 250);
        // if (!Login.isAdmin){
        //     textArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);/////////visually not pleasing
        // }
        add(scrollPane);

        inputField = new JTextField();
        inputField.setBounds(10, 270, 400, 30);
        inputField.addActionListener(this);
        add(inputField);

        sendButton = new JButton("Send");
        sendButton.setBounds(420, 270, 80, 30);
        sendButton.addActionListener(this);
        add(sendButton);

        backButton = new JButton("Back");
        backButton.setBounds(510, 270, 60, 30);
        backButton.addActionListener(this);
        add(backButton);



        
        loadMessages();

        refreshTimer = new Timer(3000,this);
        refreshTimer.start();

        setVisible(true);
    }
    public void actionPerformed(ActionEvent event) {
        String message=null;
        if (event.getSource() == sendButton || event.getSource() == inputField){
        //     if (!Login.isAdmin){
        //         aRead=true;
        //         //uRead=false;
        //     message = name+ " : " + inputField.getText();
        // }
          if(from_admin.equals("#" )){
            // uRead=true;
            // aRead=false;
            message = name+ " : " + inputField.getText();
        }
        else{
            // uRead=true;
            // aRead=false;
            message = "Admin : " + inputField.getText();
        }
        
            
            if (!message.isEmpty()) {
                appendMessageToFile(message);
                inputField.setText("");
            }
        } 
        else if (event.getSource() == refreshTimer) {
            textArea.setText("");
            loadMessages();
        }
        else if (event.getSource() == backButton) {
            if (!Login.isAdmin){
                new UserDashBoard();
            }
            else{
                // new AdminDashBoard();
            }
            this.setVisible(false);
        }
    }
    


    private void loadMessages() {
        try {
            File file = new File("./chats/"+name+".txt");
            if (!Login.isAdmin){
                if (!file.exists()) {
                boolean create = file.createNewFile();
                if (create) {
                    // System.out.println("Chat Messages File created successfully.");
                } else {
                    // System.out.println("Chat Messages File creation failed.");
                }
            }
        }
            FileReader fr= new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            textArea.setText("Error reading the messages.");
        }
    }

    private void appendMessageToFile(String message) {
        try {
            File file = new File("./chats/"+name+".txt");
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            printWriter.println(message);
            printWriter.close();

            textArea.append(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            textArea.setText("Error writing to the messages.");
        }
    }

    // public static void main(String[] args) {
    //     new Chat();
    // }
}

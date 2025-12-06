import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener{
    private Container c;
    private Cursor cursor;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scroll;
    private JLabel label1,label2;
    private JPanel panel1,panel2,panel3;
    private ImageIcon img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15,img16,img17,img18,img19;
    private JButton restartB,button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12,button13,button14,button15,button16,button17,button18,button19;
    private static double totalPrice =0;
    private static int count1 =0;
    private String[] colums={"ITEM","Quantity","Price"};
    private String[] rows = new String[3];
    private String[] genders = {" ","Male","Female","Others"};


    public Menu(){
        menuDashBoard();
        
    }   
    
    
    public void menuDashBoard(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,1390);
        this.setLocationRelativeTo(null);
        this.setTitle("Main Menu");

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);

        JTabbedPane tp = new JTabbedPane();
        tp.setBounds(100,100,750,750);
        c.add(tp);

        JButton restartButton = new JButton();
        restartButton.setText("Confirm");
        restartButton.setBounds(900,700,100,50);
        c.add(restartButton);

        JTextField tf = new JTextField();
        tf.setBounds(900,400,150,50);
        c.add(tf);

        Font font1 = new Font("Phosphate",Font.BOLD,25);
        Font font2 = new Font("BM Dohyeon",Font.BOLD,16);
        //Images


        img1 = new ImageIcon(getClass().getResource("img1.jpg"));
        img2 = new ImageIcon(getClass().getResource("img2.jpg"));
        img3 = new ImageIcon(getClass().getResource("img3.jpg"));
        img4 = new ImageIcon(getClass().getResource("img4.jpg"));
        img5 = new ImageIcon(getClass().getResource("img5.jpg"));
        img6 = new ImageIcon(getClass().getResource("img6.jpg"));
        img7 = new ImageIcon(getClass().getResource("img7.jpg"));
        img8 = new ImageIcon(getClass().getResource("img8.jpg"));
        img9 = new ImageIcon(getClass().getResource("img9.jpg"));
        img10 = new ImageIcon(getClass().getResource("img10.jpg"));
        img11= new ImageIcon(getClass().getResource("img11.jpg"));
        img12= new ImageIcon(getClass().getResource("img12.jpg"));
        img13= new ImageIcon(getClass().getResource("img13.jpg"));
        img14= new ImageIcon(getClass().getResource("img14.jpg"));
        img15= new ImageIcon(getClass().getResource("img15.jpg"));
        img16= new ImageIcon(getClass().getResource("img16.jpg"));
        img17= new ImageIcon(getClass().getResource("img17.jpg"));

        label1 = new JLabel();
        label1.setText("CLICK TO ADD ITEMS");
        label1.setBounds(900, 190, 300, 50);
        label1.setFont(font1);
        c.add(label1);

        label2 = new JLabel();
        label2.setText("Total Cost:");
        label2.setBounds(900, 369, 200, 50);
        label2.setFont(font2);
        c.add(label2);


        

        cursor = new Cursor(Cursor.HAND_CURSOR);

        button1 =new JButton(img1);
        button1.setBounds(50,50,200,200);
        button1.setCursor(cursor);

        button2 =new JButton(img2);
        button2.setBounds(300,300,200,200);
        button2.setCursor(cursor);

        button3 =new JButton(img3);
        button3.setBounds(40,79,250,250);
        button3.setCursor(cursor);

        button4 =new JButton(img4);
        button4.setBounds(40,79,250,250);
        button4.setCursor(cursor);

        button5 =new JButton(img5);
        button5.setBounds(40,79,250,250);
        button5.setCursor(cursor);

        button6 =new JButton(img6);
        button6.setBounds(40,79,250,250);
        button6.setCursor(cursor);

        button7 =new JButton(img7);
        button7.setBounds(40,79,250,250);
        button7.setCursor(cursor);

        button8 =new JButton(img8);
        button8.setBounds(40,79,250,250);
        button8.setCursor(cursor);

        button9 =new JButton(img9);
        button9.setBounds(40,79,250,250);
        button9.setCursor(cursor);

        button10 =new JButton(img10);
        button10.setBounds(40,79,250,250);
        button10.setCursor(cursor);

        button11 =new JButton(img11);
        button11.setBounds(40,79,250,250);
        button11.setCursor(cursor);

        button12 =new JButton(img12);
        button12.setBounds(40,79,250,250);
        button12.setCursor(cursor);

        button13 =new JButton(img13);
        button13.setBounds(40,79,250,250);
        button13.setCursor(cursor);

        button14 =new JButton(img14);
        button14.setBounds(40,79,250,250);
        button14.setCursor(cursor);


        button15 =new JButton(img15);
        button15.setBounds(40,79,250,250);
        button15.setCursor(cursor);

        button16 =new JButton(img16);
        button16.setBounds(40,79,250,250);
        button16.setCursor(cursor);

        button17 =new JButton(img17);
        button17.setBounds(40,79,250,250);
        button17.setCursor(cursor);


        panel1 = new JPanel();
        panel1.setBounds(100,100,200,200);
        panel1.setBackground(Color.GRAY);
        panel1.setLayout(new GridLayout(3,3,35,35));
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);
        panel1.add(button5);
        panel1.add(button6);
        panel1.add(button7);
        panel1.add(button8);
        panel1.add(button9);

        panel2 = new JPanel();
        panel2.setBounds(100,100,200,200);
        panel2.setBackground(Color.GRAY);
        panel2.setLayout(new GridLayout(3,3,35,35));
        panel2.add(button10);
        panel2.add(button11);
        panel2.add(button12);
        panel2.add(button13);
        panel2.add(button14);


 
        panel3 = new JPanel();
        panel3.setBounds(100,100,200,200);
        panel3.setBackground(Color.GRAY);
        panel3.setLayout(new GridLayout(3,3,35,35));
        panel3.add(button15);
        panel3.add(button16);
        panel3.add(button17);


        tp.add("Main Course",panel1);
        tp.add("Desert",panel2);
        tp.add("Drinks",panel3);

        // table = new JTable();
        // model = new DefaultTableModel();
        // model.setColumnIdentifiers(colums);
        // table.setModel(model);
        // table.setRowHeight(25);

        // scroll = new JScrollPane(table);
        // scroll.setBounds(879,150,300,250);
        // c.add(scroll);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                count1++;
                totalPrice = totalPrice+700;
                String total = String.valueOf(totalPrice);
                tf.setText(total);
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                count1++;
                totalPrice = totalPrice+700;
                String total = String.valueOf(totalPrice);
                tf.setText(total);
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                count1++;
                totalPrice = totalPrice+650;
                String total = String.valueOf(totalPrice);
                tf.setText(total);
            }
        });

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                count1++;
                totalPrice = totalPrice+650;
                String total = String.valueOf(totalPrice);
                tf.setText(total);
            }
        });

        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                count1++;
                totalPrice = totalPrice+800;
                String total = String.valueOf(totalPrice);
                tf.setText(total);
            }
        });

        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                count1++;
                totalPrice = totalPrice+1100;
                String total = String.valueOf(totalPrice);
                tf.setText(total);
            }
        });

        button7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                count1++;
                totalPrice = totalPrice+1200;
                String total = String.valueOf(totalPrice);
                tf.setText(total);
            }
        });

        button8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                count1++;
                totalPrice = totalPrice+1100;
                String total = String.valueOf(totalPrice);
                tf.setText(total);
            }
        });

        button9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                count1++;
                totalPrice = totalPrice+1600;
                String total = String.valueOf(totalPrice);
                tf.setText(total);
            }
        });
        button10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                count1++;
                totalPrice = totalPrice+980;
                String total = String.valueOf(totalPrice);
                tf.setText(total);
            }
        });

        button11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                count1++;
                totalPrice = totalPrice+1020;
                String total = String.valueOf(totalPrice);
                tf.setText(total);
            }
        });

        button12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                count1++;
                totalPrice = totalPrice+400;
                String total = String.valueOf(totalPrice);
                tf.setText(total);
            }
        });

        button13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                count1++;
                totalPrice = totalPrice+560;
                String total = String.valueOf(totalPrice);
                tf.setText(total);
            }
        });
        button14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                count1++;
                totalPrice = totalPrice+10200;
                String total = String.valueOf(totalPrice);
                tf.setText(total);
            }
        });

        button15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                count1++;
                totalPrice = totalPrice+180;
                String total = String.valueOf(totalPrice);
                tf.setText(total);
            }
        });


        button16.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                count1++;
                totalPrice = totalPrice+340;
                String total = String.valueOf(totalPrice);
                tf.setText(total);
            }
        });

        button17.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                count1++;
                totalPrice = totalPrice+350;
                String total = String.valueOf(totalPrice);
                tf.setText(total);
            }
        });

        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
           
                JOptionPane.showMessageDialog(null,"Your Order Has Been Confirmed.");
            }
        });


        this.setVisible(true);
            
    }
    
    // public static void main(String[] args) {
    //     Menu frame = new Menu();
    //     frame.setVisible(true);
    // }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }



}
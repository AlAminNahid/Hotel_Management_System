import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Help_Desk extends JFrame implements MouseListener, ActionListener{//extends Chat {
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton backButton;


    public Help_Desk() {
        setTitle("Help Desk");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); 

        String[] columnNames = {"                                                         Chats"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 380, 240);
        add(scrollPane);

        File folder = new File("./chats");
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (int row = 0; row < files.length; row++) {
                    File file = files[row];
                    if (file.isFile()) {
                        String fileName = file.getName();
                        if (fileName.endsWith(".txt")) {
                            fileName = fileName.substring(0, fileName.length() - 4);
                        }
                        tableModel.addRow(new Object[]{fileName});
                    }
                }
            }
        }
        backButton = new JButton("Back");
        backButton.setBounds(150, 260, 80, 30);
        backButton.addActionListener(this);
        add(backButton);


        // table.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
        //     public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
        //         Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        //         if (aRead=false) {
        //             renderer.setBackground(Color.RED);
        //         } else {
        //             renderer.setBackground(Color.WHITE);
        //         }

        //         return renderer;
        //     }
        // });

        

        // table.addMouseListener(new java.awt.event.MouseAdapter() {
        //     public void mouseClicked(java.awt.event.MouseEvent evt) {
        //         int row = table.rowAtPoint(evt.getPoint());
        //         if (row >= 0) {
        //             // aRead=false;
        //             Chat.fromadmin= table.getValueAt(row, 0).toString();
                    
        //             new  Chat();
        //         }
        //     }
        // });
        table.addMouseListener(this);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            this.setVisible(false);
            new AdminDashBoard();
        }
    }


        public void mouseClicked(MouseEvent m) {
            int row = table.rowAtPoint(m.getPoint());
            if (row >= 0) {
                // aRead=false;
                Chat.fromadmin = table.getValueAt(row, 0).toString();
                
                new Chat();
            }
        }
    
    
        public void mousePressed(MouseEvent e) {
        }
    
        public void mouseReleased(MouseEvent e) {
        }
    
        public void mouseEntered(MouseEvent e) {
        }
    
        public void mouseExited(MouseEvent e) {
        }
        
    }
    

   


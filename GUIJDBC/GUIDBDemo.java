package GUIJDBC;

import javax.swing.*;
import java.awt.*;
// import java.awt.event.*;
import java.sql.*;
public class GUIDBDemo extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = -5497590407537564561L;
    JTextField txtChName, txtChType, txtChFreq;
    JButton btnNext, btnPrevious, btnFirst, btnLast, btnNew;
    Connection dbConn;
    PreparedStatement pstmt, insertpstmt;
    ResultSet rs;

    private Connection createConnection() {
        Connection c = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://sql6.freesqldatabase.com:3306/sql6397443","sql6397443","TsZ1I4RLI5");
        }catch(ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Channel Info",JOptionPane.ERROR_MESSAGE);
        }
        return c;
    }

    private void enableFields(boolean state) {
        txtChName.setEnabled(state);
        txtChType.setEnabled(state);
        txtChFreq.setEnabled(state);
    }

    public GUIDBDemo() {
        super("Channel Information");
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        txtChName = new JTextField(20);
        txtChType = new JTextField(20);
        txtChFreq = new JTextField(20);
        btnNext = new JButton("Next");
        btnPrevious = new JButton("Previous");
        btnFirst = new JButton("First");
        btnLast = new JButton("Last");
        btnNew = new JButton("New");
        add(txtChName);
        add(txtChType);
        add(txtChFreq);
        add(btnFirst);
        add(btnPrevious);
        add(btnNext);
        add(btnLast);
        add(btnNew);
        enableFields(false);
        btnNew.addActionListener((ae)->{
//            if(((JButton)ae.getSource()).getText().equals("New"))
            if(btnNew.getText().equals("New")){
                txtChName.setText("");
                txtChType.setText("");
                txtChFreq.setText("");
                enableFields(true);
                btnNew.setText("Save");
            }
            else if(btnNew.getText().equals("Save")){
                try {
                    insertpstmt.setString(1, txtChName.getText());
                    insertpstmt.setString(2, txtChType.getText());
                    insertpstmt.setInt(3, Integer.parseInt(txtChFreq.getText()));
                    insertpstmt.executeUpdate();
                    btnNew.setText("New");
                    enableFields(false);
                }catch(SQLException e) {
                    JOptionPane.showMessageDialog(null,e.getMessage(),"Channel Info",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnFirst.addActionListener((ae)->{
            try {
                if(rs.first())
                    renderRecord();
            }catch(SQLException e) {
                JOptionPane.showMessageDialog(null,e.getMessage(),"Channel Info",JOptionPane.ERROR_MESSAGE);
            }
        });
        btnLast.addActionListener((ae)->{
            try {
                if(rs.last())
                    renderRecord();
            }catch(SQLException e) {
                JOptionPane.showMessageDialog(null,e.getMessage(),"Channel Info",JOptionPane.ERROR_MESSAGE);
            }
        });
        btnPrevious.addActionListener((ae)->{
            try {
                if(rs.previous())
                    renderRecord();
                else if(rs.last())
                    renderRecord();
            }catch(SQLException e) {
                JOptionPane.showMessageDialog(null,e.getMessage(),"Channel Info",JOptionPane.ERROR_MESSAGE);
            }
        });
        btnNext.addActionListener((ae)->{
            try {
                if(rs.next())
                    renderRecord();
                else if(rs.first())
                    renderRecord();
            }catch(SQLException e) {
                JOptionPane.showMessageDialog(null,e.getMessage(),"Channel Info",JOptionPane.ERROR_MESSAGE);
            }
        });

        dbConn = createConnection();
        try {
            pstmt = dbConn.prepareStatement("select * from TVChannels",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            insertpstmt = dbConn.prepareStatement("insert into TVChannels (chname,chtype,chfrequency) values (?,?,?)");
            rs = pstmt.executeQuery();
            if(rs.next()) {
                renderRecord();
            }
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Channel Info",JOptionPane.ERROR_MESSAGE);
        }

    }

    private void renderRecord() {
        try {
            txtChName.setText(rs.getString("chname"));
            txtChType.setText(rs.getString("chtype"));
            txtChFreq.setText(""+rs.getInt("chfrequency"));
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Channel Info",JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        GUIDBDemo guiDB = new GUIDBDemo();
        guiDB.setSize(500,500);
        guiDB.setVisible(true);
        guiDB.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

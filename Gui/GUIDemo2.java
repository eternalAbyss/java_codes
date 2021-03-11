package Gui;

// Component (Source), Method (Action), Listener (What kind of action, interface)
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;
class LoginUI2 extends JFrame implements ActionListener {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	Random r = new Random();
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1)
            demoPanel.setBackground(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
        else
            loginPanel.setBackground(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
    }
    ButtonGroup bg;
    JButton b1, b2;
    JLabel lblLogin, lblPassword;
    JTextField txtLogin;
    JPasswordField txtPassword;
    JComboBox jComboBoxWeather;
    JCheckBox jCheckBoxCricket, jCheckBoxHockey, jCheckBoxFootball;
    JRadioButton jRadioButtonMale, jRadioButtonFemale;
    JPanel loginPanel, demoPanel;
    public LoginUI2(String title) {
        // parameterized constructor of Frame class
        super(title);
        this.setLayout(new BorderLayout());
        loginPanel = new JPanel();
        loginPanel.setBackground(Color.DARK_GRAY);
        demoPanel = new JPanel();
        demoPanel.setBackground(Color.LIGHT_GRAY);
        b1 = new JButton("<html><b>Sign-In</b></html>");
        b2 = new JButton("<html><b>Sign-Up</b></html>");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b2, BorderLayout.WEST);
        lblLogin = new JLabel("<html><i>Username:</i></html>");
        lblPassword = new JLabel("Password:");
        txtLogin = new JTextField(20);
        txtPassword = new JPasswordField(20);
        txtPassword.setEchoChar('*');
        loginPanel.add(lblLogin);
        loginPanel.add(txtLogin);
        loginPanel.add(lblPassword);
        loginPanel.add(txtPassword);
        loginPanel.add(b1);
        add(loginPanel, BorderLayout.NORTH);
        b1.setBackground(Color.BLUE);
        String[] weathers = new String[]{"Cloudy", "Sunny", "Raining", "Drizzling"};
        jComboBoxWeather = new JComboBox(weathers);
        demoPanel.add(jComboBoxWeather);

        jCheckBoxCricket = new JCheckBox("Cricket");
        jCheckBoxFootball = new JCheckBox("Football");
        jCheckBoxHockey = new JCheckBox("Hockey");

        demoPanel.add(jCheckBoxCricket);
        demoPanel.add(jCheckBoxFootball);
        demoPanel.add(jCheckBoxHockey);

        jRadioButtonFemale = new JRadioButton("Female");
        jRadioButtonMale = new JRadioButton("Male");
        demoPanel.add(jRadioButtonFemale);
        demoPanel.add(jRadioButtonMale);
        bg = new ButtonGroup();
        bg.add(jRadioButtonFemale);
        bg.add(jRadioButtonMale);
        add(demoPanel, BorderLayout.SOUTH);
    }
}
public class GUIDemo2 {
    public static void main(String[] args) {
        LoginUI2 loginScreen = new LoginUI2("Login");
        loginScreen.setSize(500,500);
        loginScreen.setVisible(true);
    }
}

package Gui;

import javax.swing.*;
import java.awt.*;
class LoginPage extends JFrame {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JButton b1;
    JLabel lblLogin, lblPassword;
    JTextField txtLogin;
    JPasswordField txtPassword;

    public LoginPage(String title) {
        // parameterized constructor of Frame class
        super(title);
        this.setLayout(new FlowLayout());
        b1 = new JButton("<html><b>Sign-In</b></html>");
        lblLogin = new JLabel("<html><i>Username:</i></html>");
        lblPassword = new JLabel("Password:");
        txtLogin = new JTextField(20);
        txtPassword = new JPasswordField(20);
        txtPassword.setEchoChar('*');
        add(lblLogin);
        add(txtLogin);
        add(lblPassword);
        add(txtPassword);
        add(b1);
        b1.addActionListener((e)->{
            if(txtLogin.getText().equalsIgnoreCase("Admin")&&txtPassword.getText().equals("123")) {
                LandingPage landingPage = new LandingPage();
                landingPage.setSize(500,500);
                landingPage.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        LoginPage lp = new LoginPage("Login Page");
        lp.setSize(200,500);
        lp.setVisible(true);
        lp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/* MouseListener (5), MouseMotionListener (2), KeyListener (3), WindowListener(7), ActionListener (1), ItemListener (1) */

public class LandingPage1 extends JFrame implements MouseListener, MouseMotionListener, KeyListener, WindowListener, ItemListener {
    JButton mouseTest;
    JTextField keyTest;
    JCheckBox itemTest;
    // Item Listener Actions
    public void itemStateChanged(ItemEvent ie) {
        System.out.println(itemTest.isSelected());
    }
    // Window Listener Actions
    public void windowClosing(WindowEvent we) {
        System.out.println("Did you click on the close button?");
    }
    public void windowClosed(WindowEvent we) {
        System.out.println("Closed");
    }
    public void windowOpened(WindowEvent we) {
        System.out.println("Opened");
    }
    public void windowActivated(WindowEvent we) {
        System.out.println("Activated");
    }
    public void windowDeactivated(WindowEvent we) {
        System.out.println("Deactivated");
    }
    // Minimized
    public void windowIconified(WindowEvent we) {
        System.out.println("Minimized");
    }
    // Maximized
    public void windowDeiconified(WindowEvent we) {
        System.out.println("Maximized");
    }
    // Key Listener Actions
    public void keyPressed(KeyEvent ke){
        System.out.println("Key Pressed: "+ke.getKeyCode());
    }
    public void keyReleased(KeyEvent ke){
        System.out.println("Key Released: "+ke.getKeyCode());
    }
    public void keyTyped(KeyEvent ke){
        System.out.println("Key Typed: "+ke.getKeyChar());
    }
    // Mouse Motion Listener Actions
    public void mouseMoved(MouseEvent me) {
        System.out.println("Moved at: "+me.getX()+", "+me.getY());
    }
    public void mouseDragged(MouseEvent me) {
        System.out.println("Dragged at: "+me.getX()+", "+me.getY());
    }
    // Mouse Listener Actions
    public void mouseClicked(MouseEvent me){
        System.out.println("Clicked");
    }
    public void mouseEntered(MouseEvent me){
        System.out.println("Entered");
    }
    public void mouseExited(MouseEvent me){
        System.out.println("Exited");
    }
    public void mousePressed(MouseEvent me){
        System.out.println("Pressed");
    }
    public void mouseReleased(MouseEvent me){
        System.out.println("Released");
    }
    public LandingPage1() {
        super("LandingPage");
        itemTest = new JCheckBox("Terms and Conditions");
        mouseTest = new JButton("Testing Mouse Events");
        keyTest = new JTextField();
        add(keyTest, BorderLayout.NORTH);
        keyTest.addKeyListener(this);
        add(mouseTest, BorderLayout.SOUTH);
        mouseTest.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addWindowListener(this);
        this.add(itemTest,BorderLayout.EAST);
        itemTest.addItemListener(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    public static void main(String[] args) {
        LandingPage landingpage = new LandingPage();
        landingpage.setSize(500,500);
        landingpage.setVisible(true);
    }
}

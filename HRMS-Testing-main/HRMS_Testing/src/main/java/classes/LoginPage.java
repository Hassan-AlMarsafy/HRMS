package classes;

import javax.swing.*;
import java.awt.event.*;

public class LoginPage extends JFrame implements ActionListener , KeyListener {
    private JPanel LoginPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton submit;

    Main main = new Main();

    public LoginPage() {
        main.init();

        setContentPane(LoginPanel);
        setTitle("HRMS");
        setSize(500,500);
        setVisible(true);

        // Close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        submit.addActionListener(this);
        submit.addKeyListener((KeyListener) this);
    }

    public LoginPage(HRemployee hre){
        main.hre = hre;

        System.out.println(hre.getLeaveManagement().getAllLeaveRequests().size());

        setContentPane(LoginPanel);
        setTitle("HRMS");
        setSize(500,500);
        setVisible(true);

        // Close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        submit.addActionListener(this);
        submit.addKeyListener((KeyListener) this);
    }

    public static void main(String[] args) {
        new LoginPage();
    }

    private void Login(){
        // .trim() to remove unwanted spaces --- zay el adv soft

        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        int loginStatus = main.hre.authenticate(username, password);

        if (loginStatus == 2) {
            setVisible(false);
            new HRemployeePage(main.hre);
        }
        else if (loginStatus == -1) {
            JOptionPane.showMessageDialog(this, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            setVisible(false);
            new EmployeePage(main.hre.findEmployeeById(loginStatus),main.hre);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            Login();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            Login();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

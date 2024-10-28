package classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EmployeePage  extends JFrame implements ActionListener, KeyListener {
    private JPanel EmployeePanel;
    private JButton requestLeaveButton;
    private JButton viewEvaluationButton;
    private JLabel welcome;
    private JButton backButton;

    Employee employee;
    HRemployee hre;

    public EmployeePage(Employee employee, HRemployee hre) {
        this.employee = employee;
        this.hre = hre;
        System.out.println(hre.getLeaveManagement().getAllLeaveRequests().size());

        welcome.setText("Welcome " + employee.getName());
        setVisible(true);

        setContentPane(EmployeePanel);
        setTitle("Welcome " + employee.getName());
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        requestLeaveButton.addActionListener(this);
        viewEvaluationButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == requestLeaveButton) {
            setVisible(false);
            new LeaveRequestPage(employee,hre);
        }
        else if (e.getSource() == viewEvaluationButton) {
            if (employee.getEvaluation() != null)
            {
                JOptionPane.showMessageDialog(EmployeePanel, "You are Evaluated as  " + employee.getEvaluation());
            }
            else
                JOptionPane.showMessageDialog(EmployeePanel, "You are Not Evaluated Yet");
        }
        else if (e.getSource() == backButton) {
            setVisible(false);
            new LoginPage(hre);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}

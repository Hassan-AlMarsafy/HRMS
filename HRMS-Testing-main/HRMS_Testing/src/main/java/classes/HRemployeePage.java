package classes;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HRemployeePage extends JFrame implements ActionListener, KeyListener {
    private JButton manageEmployeeDataButton;
    private JButton manageLeaveRequestsButton;
    private JButton viewEvaluationButton;
    private JPanel HRemployeePanel;
    private JButton payrollProcessingButton;
    HRemployee hre;

    public HRemployeePage(HRemployee hre) {
        this.hre = hre;
        System.out.println(hre.getLeaveManagement().getAllLeaveRequests().size());

        setVisible(true);

        setContentPane(HRemployeePanel);
        setTitle("HRMS");
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        manageEmployeeDataButton.addActionListener(this);
        manageLeaveRequestsButton.addActionListener(this);
        viewEvaluationButton.addActionListener(this);
        payrollProcessingButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == manageEmployeeDataButton) {
            setVisible(false);
            new ManageEmployeeDataPage(hre);
        }
        else if (e.getSource() == manageLeaveRequestsButton) {
            setVisible(false);
            new LeaveManagmentPage(hre);
        }
        else if (e.getSource() == viewEvaluationButton) {
            setVisible(false);
            new EvaluatePerformancePage(hre);
        }
        else if (e.getSource() == payrollProcessingButton) {
            setVisible(false);
            new PayrollProccessingPage(hre);
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

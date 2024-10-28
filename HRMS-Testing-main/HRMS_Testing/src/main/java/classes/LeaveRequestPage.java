package classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LeaveRequestPage extends JFrame {
    private JComboBox<String> comboBox1;
    private JPanel LeaveRequestPanel;
    private JTextField endField;
    private JTextField startField;
    private JButton btnsubmit;
    private JLabel LeaveType;
    private JLabel RequestLeave;

    LeaveType leaveType1;
    HRemployee hre;

    public LeaveRequestPage(Employee employee, HRemployee hre) {
        this.hre = hre;

        setContentPane(LeaveRequestPanel);
        setSize(500,500);
        setTitle("Leave Request");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        btnsubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String leaveType = (String) comboBox1.getSelectedItem();

                String startDateStr = startField.getText();
                String endDateStr = endField.getText();

                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                Date startDate = null;
                Date endDate = null;

                if (leaveType == null){
                    JOptionPane.showMessageDialog(LeaveRequestPanel, "Please select a leave type", "Leave Request", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    try {
                        startDate = sdf.parse(startDateStr);
                        endDate = sdf.parse(endDateStr);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(LeaveRequestPanel, "Invalid date format. Please use dd-MM-yyyy.", "Date", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (startDate == null || endDate == null || endDate.before(startDate)) {
                        JOptionPane.showMessageDialog(LeaveRequestPanel, "End date must be after start date.", "Date", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                int result = JOptionPane.showConfirmDialog(LeaveRequestPanel,
                        "Leave Request Submitted\n" +
                                "Leave Type: " + leaveType + "\n" +
                                "Start Date: " + sdf.format(startDate) + "\n" +
                                "End Date: " + sdf.format(endDate),
                            "Confirm Leave Request",
                                JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.INFORMATION_MESSAGE);

                if (result == JOptionPane.OK_OPTION) {
                    assert leaveType != null;
                    convertStringToLeaveType(leaveType);
                    LeaveRequest leaveRequest = new LeaveRequest(hre.getAllLeaveRequests().size(),employee ,leaveType1 ,startDate ,endDate);
                    hre.getLeaveManagement().addLeaveRequest(leaveRequest);
                    System.out.println(hre.getLeaveManagement().getAllLeaveRequests().size());

                    setVisible(false);
                    new EmployeePage(employee,hre);
                }
            }
        });
    }

    private void convertStringToLeaveType(String leaveType) {
        switch (leaveType) {
            case "Sick Leave":
                leaveType1 = classes.LeaveType.SickLeave;
                break;
            case "Paternity Leave":
                leaveType1 = classes.LeaveType.PaternityLeave;
                break;
            case "Maternity Leave":
                leaveType1 = classes.LeaveType.MaternityLeave;
                break;
            case "Emergency Leave":
                leaveType1 = classes.LeaveType.EmergencyLeave;
                break;
            case "Vacation Leave":
                leaveType1 = classes.LeaveType.VacationLeave;
                break;
        }
    }
}

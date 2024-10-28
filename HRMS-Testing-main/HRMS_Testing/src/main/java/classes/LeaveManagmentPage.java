package classes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;

public class LeaveManagmentPage extends JFrame implements ActionListener, KeyListener{

    private JPanel LeaveManagmentPanel;
    private JButton ApproveButton;
    private JButton rejectButton;
    private JButton backButton;
    private JScrollPane TablePane;
    private JTable leaveRequestsTable;
    HRemployee hre;

    public LeaveManagmentPage(HRemployee hre) {
        this.hre = hre;

        setContentPane(LeaveManagmentPanel);
        setTitle("Manage Employee Data");
        setSize(500,500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        List<LeaveRequest> requests = hre.getAllLeaveRequests();

        String[] columnNames = { "ID", "Employee ID", "Type", "Start Date", "End Date", "Status"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (LeaveRequest request : requests) {
            Object[] row = {
                    request.getId(),
                    request.getEmployee().getId(),
                    request.getLeaveType(),
                    request.getStartDate(),
                    request.getEndDate(),
                    request.getLeaveStatus()
            };
            model.addRow(row);
        }

        leaveRequestsTable.setModel(model);
        backButton.addActionListener(this);
        rejectButton.addActionListener(this);
        ApproveButton.addActionListener(this);

        setVisible(true);
    }

    public void UpdateTable(){
        List<LeaveRequest> requests = hre.getAllLeaveRequests();

        String[] columnNames = { "ID", "Employee", "Type", "Start Date", "End Date", "Status"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (LeaveRequest request : requests) {
            Object[] row = {
                    request.getId(),
                    request.getEmployee(),
                    request.getLeaveType(),
                    request.getStartDate(),
                    request.getEndDate(),
                    request.getLeaveStatus()
            };
            model.addRow(row);
        }

        leaveRequestsTable.setModel(model);
    }

    public void approveRequest() {
        DefaultTableModel model = (DefaultTableModel) leaveRequestsTable.getModel();
        if(leaveRequestsTable.getSelectedRowCount() == 1) {
            int id = (int) leaveRequestsTable.getValueAt(leaveRequestsTable.getSelectedRow(), 0);
            hre.approveLeaveRequest(id);
            UpdateTable();
        }
    }
    public void rejectRequest() {
        DefaultTableModel model = (DefaultTableModel) leaveRequestsTable.getModel();
        if(leaveRequestsTable.getSelectedRowCount() == 1) {
            int id = (int) leaveRequestsTable.getValueAt(leaveRequestsTable.getSelectedRow(), 0);
            hre.rejectLeaveRequest(id);
            UpdateTable();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton) {
            setVisible(false);
            new HRemployeePage(hre);
        }
        else if(e.getSource() == rejectButton) {
            rejectRequest();
        }
        else if(e.getSource() == ApproveButton) {
            approveRequest();
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

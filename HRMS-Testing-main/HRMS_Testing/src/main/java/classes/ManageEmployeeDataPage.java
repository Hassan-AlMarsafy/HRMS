package classes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;

public class ManageEmployeeDataPage extends JFrame implements ActionListener, KeyListener {
    private JPanel ManageEmployeeDataPanel;
    private JButton addButton;
    private JButton editButton;
    private JButton removeButton;
    private JButton backButton;
    private JScrollPane TablePane;
    private JTable EmployeeDataTable;

    HRemployee hre;

    public ManageEmployeeDataPage(HRemployee hre) {
        this.hre = hre;

        setContentPane(ManageEmployeeDataPanel);
        setTitle("Manage Employee Data");
        setSize(500,500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        List<Employee> employees = hre.getAllEmployees();

        String[] columnNames = { "Name", "ID", "Username", "Department", "Type", "Evaluation" };

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Employee employee : employees) {
            Object[] row = {
                    employee.getName(),
                    employee.getId(),
                    employee.getUsername(),
                    employee.getDepartment(),
                    employee.getEmployeeType(),
                    employee.getEvaluation()
            };
            model.addRow(row);
        }

        EmployeeDataTable.setModel(model);

        addButton.addActionListener(this);
        editButton.addActionListener(this);
        removeButton.addActionListener(this);
        backButton.addActionListener(this);
        setVisible(true);
    }

    public void UpdateTable(){
        List<Employee> employees = hre.getAllEmployees();

        String[] columnNames = { "Name", "ID", "Username", "Department", "Type", "Evaluation" };

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Employee employee : employees) {
            Object[] row = {
                    employee.getName(),
                    employee.getId(),
                    employee.getUsername(),
                    employee.getDepartment(),
                    employee.getEmployeeType(),
                    employee.getEvaluation()
            };
            model.addRow(row);
        }

        EmployeeDataTable.setModel(model);
    }

    public void EditEmployee() {
        DefaultTableModel model = (DefaultTableModel) EmployeeDataTable.getModel();
        if(EmployeeDataTable.getSelectedRowCount() == 1) {
            String name = EmployeeDataTable.getValueAt(EmployeeDataTable.getSelectedRow(), 0).toString();
            String username = EmployeeDataTable.getValueAt(EmployeeDataTable.getSelectedRow(), 2).toString();
            String department = EmployeeDataTable.getValueAt(EmployeeDataTable.getSelectedRow(), 3).toString();
            String type = EmployeeDataTable.getValueAt(EmployeeDataTable.getSelectedRow(), 4).toString();
            String ID = EmployeeDataTable.getValueAt(EmployeeDataTable.getSelectedRow(), 1).toString();
            setVisible(false);
            EditEmployeeDataPage editEmployeeDataPage = new EditEmployeeDataPage(hre,name,username,department,type);
            editEmployeeDataPage.EmployeeId(ID);
        }
        else
            JOptionPane.showMessageDialog(ManageEmployeeDataPanel, "Please select a row from the table");

    }
    public void RemoveEmployee() {
        DefaultTableModel model = (DefaultTableModel) EmployeeDataTable.getModel();
        if(EmployeeDataTable.getSelectedRowCount() == 1) {
            int id = (int) EmployeeDataTable.getValueAt(EmployeeDataTable.getSelectedRow(), 1);
            hre.deleteEmployee(id);
            UpdateTable();
        }
        else
            JOptionPane.showMessageDialog(ManageEmployeeDataPanel, "Please select a row from the table");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addButton) {
            setVisible(false);
            new CreateEmployeePage(hre);
        }
        else if(e.getSource() == editButton) {
            EditEmployee();
        }
        else if(e.getSource() == removeButton) {
            RemoveEmployee();
        }
        else if(e.getSource() == backButton) {
            setVisible(false);
            new HRemployeePage(hre);
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

package classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Objects;

public class EditEmployeeDataPage extends JFrame implements ActionListener, KeyListener {

    private JPanel EditEmployeeDataPanel;
    private JTextField NameField;
    private JTextField UsernameField;
    private JTextField DepartmentField;
    private JComboBox EmpTypeBox;
    private JButton confirmButton;
    private JButton cancelButton;

    EmployeeType employeeType;
    HRemployee hre;
    int ID;

    public EditEmployeeDataPage(HRemployee hre, String n, String u, String d, String t) {
        this.hre = hre;
        setVisible(true);

        setContentPane(EditEmployeeDataPanel);
        setTitle("Edit Employee Data");
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        confirmButton.addActionListener(this);
        cancelButton.addActionListener(this);

        NameField.setText(n);
        UsernameField.setText(u);
        DepartmentField.setText(d);
        EmpTypeBox.setSelectedItem(t);
    }

    public void EmployeeId(String id){
        ID = Integer.parseInt(id);
    }

    private boolean CheckUniqueUsername(String username, int id) {
        List<Employee> employees = hre.getAllEmployees();

        for (Employee employee : employees) {
            if (employee.getUsername().equals(username) && employee.getId() != id) {
                return false;
            }
        }
        return true;
    }

    private int changeEmployeeData() {

        Employee employees = hre.findEmployeeById(ID);

        if (NameField.getText().isEmpty() || UsernameField.getText().isEmpty() || DepartmentField.getText().isEmpty()) {
            return -1;
        }
        else if (!(CheckUniqueUsername(UsernameField.getText(), employees.getId()))){
            return 0;
        }

        employees.setName(NameField.getText());
        employees.setUsername(UsernameField.getText());
        employees.setDepartment(DepartmentField.getText());
        employees.setEmployeeType(EmployeeType.valueOf(Objects.requireNonNull(EmpTypeBox.getSelectedItem()).toString()));
        return 1;
    }

    private void convertStringToEmployeeType(String empType) {
        switch (empType) {
            case "Hourly":
                employeeType = EmployeeType.Hourly;
                break;
            case "PartTime":
                employeeType = EmployeeType.PartTime;
                break;
            case "FullTime":
                employeeType = EmployeeType.FullTime;
                break;
            case "Intern":
                employeeType = EmployeeType.Intern;
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
            int status = changeEmployeeData();
            if (status == 1) {
                setVisible(false);
                new ManageEmployeeDataPage(hre);
            }
            else if (status == 0) {
                JOptionPane.showMessageDialog(EditEmployeeDataPanel, "Username already exists", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (status == -1) {
                JOptionPane.showMessageDialog(EditEmployeeDataPanel, "Please fill out all the fields", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
        else if (e.getSource() == cancelButton) {
            setVisible(false);
            new ManageEmployeeDataPage(hre);
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


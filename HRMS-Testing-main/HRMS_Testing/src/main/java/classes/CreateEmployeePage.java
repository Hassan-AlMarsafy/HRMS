package classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class CreateEmployeePage extends JFrame implements ActionListener, KeyListener {
    private JPanel CreateEmployeePanel;
    private JTextField NameField;
    private JTextField UsernameField;
    private JTextField DepartmentField;
    private JComboBox EmpTypeBox;
    private JButton confirmButton;
    private JButton cancelButton;
    private JTextField IDField;
    private JLabel IdLabel;
    private JTextField PasswordField;

    EmployeeType employeeType;
    HRemployee hre;

    public CreateEmployeePage(HRemployee hre) {
        this.hre = hre;

        setVisible(true);

        setContentPane(CreateEmployeePanel);
        setTitle("Edit Employee Data");
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        confirmButton.addActionListener(this);
        cancelButton.addActionListener(this);

    }
    private int createEmployeeData() {
        if((NameField.getText().isEmpty()) || (UsernameField.getText().isEmpty()) || (DepartmentField.getText().isEmpty()) || (EmpTypeBox.getSelectedIndex() == -1 || PasswordField.getText().isEmpty()) || (IDField.getText().isEmpty())) {
            return -1;
        }
        else if (!CheckUniqueId(Integer.parseInt(IDField.getText()))){
            return 0;
        } else if (!CheckUniqueUsername(UsernameField.getText())) {
            return -2;
        }
        Employee employee = new Employee(NameField.getText(),Integer.parseInt(IDField.getText()),UsernameField.getText(),PasswordField.getText(),null, DepartmentField.getText(),EmployeeType.valueOf(EmpTypeBox.getSelectedItem().toString()),Evaluation.Excellent);
        employee.setPay(null);
        hre.addEmployee(employee);
        return 1;
    }

    private boolean CheckUniqueId(int id) {
        List<Employee> employees = hre.getAllEmployees();

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return false;
            }
        }
        return true;
    }

    private boolean CheckUniqueUsername(String username) {
        List<Employee> employees = hre.getAllEmployees();
        for (Employee employee : employees) {
            if (employee.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
            int status = createEmployeeData();
            if(status == 1) {
                setVisible(false);
                new ManageEmployeeDataPage(hre);
            }
            else if(status == 0) {
                JOptionPane.showMessageDialog(CreateEmployeePanel, "Employee Id already exists", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(status == -1) {
                JOptionPane.showMessageDialog(CreateEmployeePanel, "Please fill out all the fields", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(status == -2) {
                JOptionPane.showMessageDialog(CreateEmployeePanel, "Username already exists", "Error", JOptionPane.ERROR_MESSAGE);
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

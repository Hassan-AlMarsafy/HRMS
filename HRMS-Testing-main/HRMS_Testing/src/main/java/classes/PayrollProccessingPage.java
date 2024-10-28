package classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PayrollProccessingPage extends JFrame implements ActionListener {
    private JPanel PayrollProccessingPanel;
    private JComboBox comboBox1;
    private JTextField baseSalaryField;
    private JTextField hoursField;
    private JTextField taxField;
    private JTextField deductionsField;
    private JTextField bonusField;
    private JButton submit;
    private JButton backButton;

    Employee employee;
    HRemployee hre;

    public PayrollProccessingPage(HRemployee hre) {
        this.hre = hre;
        setContentPane(PayrollProccessingPanel);
        setTitle("Payroll Proccessing Page");
        setSize(500,500);
        setVisible(true);

        List<Employee> employees = hre.getAllEmployees();

        for (Employee employee : employees) {
            comboBox1.addItem(employee.getId());
        }
        comboBox1.setSelectedIndex(-1);

        comboBox1.addActionListener(this);
        submit.addActionListener(this);
        backButton.addActionListener(this);

        // Close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public int ProccessPayroll() {
        if (comboBox1.getSelectedIndex() == -1 || baseSalaryField.getText().isEmpty() || hoursField.getText().isEmpty() || taxField.getText().isEmpty() || deductionsField.getText().isEmpty() || bonusField.getText().isEmpty()) {
            return -1;
        }
        else if (Double.parseDouble(baseSalaryField.getText()) < 0){
            return -2;
        }
        else if (Double.parseDouble(hoursField.getText()) < 0){
            return -3;
        }
        else if (Double.parseDouble(taxField.getText()) < 0){
            return -4;
        }
        else if (Double.parseDouble(deductionsField.getText()) < 0){
            return -5;
        }
        else if (Double.parseDouble(bonusField.getText()) < 0){
            return -6;
        } else {
            return 1;
        }
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            int status = ProccessPayroll();
            if (status == -1) {
                JOptionPane.showMessageDialog(PayrollProccessingPanel, "Please fill out all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (status == -2) {
                JOptionPane.showMessageDialog(PayrollProccessingPanel, "Invalid Base Salary", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (status == -3) {
                JOptionPane.showMessageDialog(PayrollProccessingPanel, "Invalid Hours", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (status == -4) {
                JOptionPane.showMessageDialog(PayrollProccessingPanel, "Invalid Tax", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (status == -5) {
                JOptionPane.showMessageDialog(PayrollProccessingPanel, "Invalid Deductions", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (status == -6) {
                JOptionPane.showMessageDialog(PayrollProccessingPanel, "Invalid Bonus", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (status == 1) {
                employee.getPay().setBaseSalary(Double.parseDouble(baseSalaryField.getText()));
                employee.getPay().setHours(Integer.parseInt(hoursField.getText()));
                employee.getPay().setTax(Double.parseDouble(taxField.getText()));
                employee.getPay().setDeductions(Double.parseDouble(deductionsField.getText()));
                employee.getPay().setBonus(Double.parseDouble(bonusField.getText()));

                setVisible(false);
                new HRemployeePage(hre);
            }
        }
        else if (e.getSource() == backButton) {
            setVisible(false);
            new HRemployeePage(hre);
        }
        else if (e.getSource() == comboBox1) {
            employee = hre.findEmployeeById((int)comboBox1.getSelectedItem());
            baseSalaryField.setText(String.valueOf(employee.getPay().getBaseSalary()));
            hoursField.setText(String.valueOf(employee.getPay().getHours()));
            taxField.setText(String.valueOf(employee.getPay().getTax()));
            deductionsField.setText(String.valueOf(employee.getPay().getDeductions()));
            bonusField.setText(String.valueOf(employee.getPay().getBonus()));
        }
    }

}

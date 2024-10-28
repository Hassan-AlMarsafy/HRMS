package classes;

public class Payroll {
    private EmployeeType employeeType;
    private double baseSalary;
    private int hours;
    private double tax;
    private double deductions;
    private double bonus;

    public Payroll(EmployeeType employeeType, double baseSalary, int hours, double tax, double deductions, double bonus) {
        this.employeeType = employeeType;
        if (baseSalary < 0){
            this.baseSalary = -1;
        }
        if (hours < 0){
            this.hours = -1;
        }
        if (tax < 0){
            this.tax = -1;
        }
        if (deductions < 0){
            this.deductions = -1;
        }
        if (bonus < 0){
            this.bonus = -1;
        }
        if (baseSalary >= 0 && hours >= 0 && tax >= 0 && deductions >= 0 && bonus >= 0) {
            this.baseSalary = baseSalary;
            this.hours = hours;
            this.tax = tax;
            this.deductions = deductions;
            this.bonus = bonus;
        }
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0) {
            this.baseSalary = -1;
        }
        else {
            this.baseSalary = baseSalary;
        }
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        if (hours < 0) {
            this.hours = -1;
        }
        else {
            this.hours = hours;
        }
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        if (tax < 0) {
            this.tax = -1;
        }
        else {
            this.tax = tax;
        }
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        if (deductions < 0) {
            this.deductions = -1;
        }
        else {
            this.deductions = deductions;
        }
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        if (bonus < 0) {
            this.bonus = -1;
        }
        else {
            this.bonus = bonus;
        }
    }

    public double calculatePay() {

        if (employeeType == EmployeeType.Hourly) {
            return baseSalary * hours + bonus - tax - deductions;
        } else if (employeeType == EmployeeType.Intern) {
            return baseSalary;
        } else {
            return baseSalary + bonus - tax - deductions;
        }
    }
}

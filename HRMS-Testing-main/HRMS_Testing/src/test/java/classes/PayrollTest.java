package classes;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PayrollTest {
    private Payroll fullTimePayroll;
    private Payroll partTimePayroll;
    private Payroll hourlyPayroll;
    private Payroll internPayroll;

    @BeforeAll
    public static void Message() {
        System.out.println("Testing the Payroll Class");
    }

    @BeforeEach
    public void setUp() {
        fullTimePayroll = new Payroll(EmployeeType.FullTime, 5000, 0, 1000, 500, 200);
        partTimePayroll = new Payroll(EmployeeType.PartTime, 2500, 0, 500, 250, 100);
        hourlyPayroll = new Payroll(EmployeeType.Hourly, 20, 160, 300, 150, 50);
        internPayroll = new Payroll(EmployeeType.Intern, 1000, 0, 100, 50, 0);
    }

    @Test
    @Order(1)
    @DisplayName("Test Full-Time Employee Pay Calculation")
    public void testFullTimePay() {
        double expectedPay = 5000 + 200 - 1000 - 500;
        assertEquals(expectedPay, fullTimePayroll.calculatePay());
    }

    @Test
    @Order(2)
    @DisplayName("Test Part-Time Employee Pay Calculation")
    public void testPartTimePay() {
        double expectedPay = 2500 + 100 - 500 - 250;
        assertEquals(expectedPay, partTimePayroll.calculatePay());
    }

    @Test
    @Order(3)
    @DisplayName("Test Hourly Employee Pay Calculation")
    public void testHourlyPay() {
        double expectedPay = 20 * 160 + 50 - 300 - 150;
        assertEquals(expectedPay, hourlyPayroll.calculatePay());
    }

    @Test
    @Order(4)
    @DisplayName("Test Intern Pay Calculation")
    public void testInternPay() {
        double expectedPay = 1000;
        assertEquals(expectedPay, internPayroll.calculatePay());
    }

    @Test
    @Order(5)
    @DisplayName("Test Invalid Base Salary")
    public void testInvalidBaseSalary() {
        Payroll invalidPayroll = new Payroll(EmployeeType.FullTime, -5000, 0, 1000, 500, 200);
        assertEquals(-1, invalidPayroll.getBaseSalary());
    }

    @Test
    @Order(6)
    @DisplayName("Test Invalid Hours")
    public void testInvalidHours() {
        Payroll invalidPayroll = new Payroll(EmployeeType.Hourly, 20, -160, 300, 150, 50);
        assertEquals(-1, invalidPayroll.getHours());
    }

    @Test
    @Order(7)
    @DisplayName("Test Invalid Tax")
    public void testInvalidTax() {
        Payroll invalidPayroll = new Payroll(EmployeeType.FullTime, 5000, 0, -1000, 500, 200);
        assertEquals(-1, invalidPayroll.getTax());
    }

    @Test
    @Order(8)
    @DisplayName("Test Invalid Deductions")
    public void testInvalidDeductions() {
        Payroll invalidPayroll = new Payroll(EmployeeType.FullTime, 5000, 0, 1000, -500, 200);
        assertEquals(-1, invalidPayroll.getDeductions());
    }

    @Test
    @Order(9)
    @DisplayName("Test Invalid Bonus")
    public void testInvalidBonus() {
        Payroll invalidPayroll = new Payroll(EmployeeType.FullTime, 5000, 0, 1000, 500, -200);
        assertEquals(-1, invalidPayroll.getBonus());
    }

    @Test
    @Order(10)
    @DisplayName("Test Set and Get Employee Type")
    public void testSetGetEmployeeType() {
        fullTimePayroll.setEmployeeType(EmployeeType.PartTime);
        assertEquals(EmployeeType.PartTime, fullTimePayroll.getEmployeeType());
    }

    @Test
    @Order(11)
    @DisplayName("Test Set and Get Base Salary")
    public void testSetGetBaseSalary() {
        fullTimePayroll.setBaseSalary(6000);
        assertEquals(6000, fullTimePayroll.getBaseSalary());
    }

    @Test
    @Order(12)
    @DisplayName("Test Set and Get Hours")
    public void testSetGetHours() {
        hourlyPayroll.setHours(120);
        assertEquals(120, hourlyPayroll.getHours());
    }

    @Test
    @Order(13)
    @DisplayName("Test Set and Get Tax")
    public void testSetGetTax() {
        internPayroll.setTax(200);
        assertEquals(200, internPayroll.getTax());
    }

    @Test
    @Order(14)
    @DisplayName("Test Set and Get Deductions")
    public void testSetGetDeductions() {
        partTimePayroll.setDeductions(300);
        assertEquals(300, partTimePayroll.getDeductions());
    }

    @Test
    @Order(15)
    @DisplayName("Test Set and Get Bonus")
    public void testSetGetBonus() {
        fullTimePayroll.setBonus(300);
        assertEquals(300, fullTimePayroll.getBonus());
    }
}
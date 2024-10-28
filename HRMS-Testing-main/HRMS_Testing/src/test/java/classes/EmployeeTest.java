package classes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeTest {
    Employee employee;
    Address address;

    @BeforeAll
    public static void Message() {
        System.out.println("Testing the Employee Class");
    }

    @BeforeEach
    public void setUp() {
        address = new Address("Zahraa ElMaadi", "Cairo", "00000", "Egypt");
        employee = new Employee("Aley", 101, "Aley", "password", address, "Computer Engineering", EmployeeType.FullTime, Evaluation.Excellent);
    }

    @Test
    @DisplayName("Test Employee Initialization")
    public void testEmployeeInitialization() {
        assertEquals("Aley", employee.getName());
        assertEquals(101, employee.getId());
        assertEquals("Aley", employee.getUsername());
        assertEquals("password", employee.getPassword());
        assertEquals(address, employee.getAddress());
        assertEquals("Computer Engineering", employee.getDepartment());
        assertEquals(EmployeeType.FullTime, employee.getEmployeeType());
        assertEquals(Evaluation.Excellent, employee.getEvaluation());
        assertTrue(employee.getPerformanceList().isEmpty());
    }

    @Test
    @DisplayName("Test Set and Get Name")
    public void testSetGetName() {
        employee.setName("Ziad");
        assertEquals("Ziad", employee.getName());
    }

    @Test
    @DisplayName("Test Set and Get ID")
    public void testSetGetId() {
        employee.setId(102);
        assertEquals(102, employee.getId());
    }

    @Test
    @DisplayName("Test Set and Get Username")
    public void testSetGetUsername() {
        employee.setUsername("Zeze");
        assertEquals("Zeze", employee.getUsername());
    }

    @Test
    @DisplayName("Test Set and Get Password")
    public void testSetGetPassword() {
        employee.setPassword("newpassword123");
        assertEquals("newpassword123", employee.getPassword());
    }

    @Test
    @DisplayName("Test Set and Get Address")
    public void testSetGetAddress() {
        Address newAddress = new Address("Nasr city", "Cairo", "00000", "Egypt");
        employee.setAddress(newAddress);
        assertEquals(newAddress, employee.getAddress());
    }

    @Test
    @DisplayName("Test Set and Get Department")
    public void testSetGetDepartment() {
        employee.setDepartment("Marketing");
        assertEquals("Marketing", employee.getDepartment());
    }

    @Test
    @DisplayName("Test Set and Get Employee Type")
    public void testSetGetEmployeeType() {
        employee.setEmployeeType(EmployeeType.PartTime);
        assertEquals(EmployeeType.PartTime, employee.getEmployeeType());
    }

    @Test
    @DisplayName("Test Set and Get Payroll")
    public void testSetGetPayroll() {
        Payroll payroll = new Payroll(EmployeeType.FullTime, 5000, 0, 1000, 500, 200);
        employee.setPay(payroll);
        assertEquals(payroll, employee.getPay());
    }

    @Test
    @DisplayName("Test Add and Get Performance List")
    public void testAddGetPerformanceList() {
        employee.addPerformance(Performance.Attendance);
        List<Performance> performanceList = employee.getPerformanceList();
        assertEquals(1, performanceList.size());
        assertEquals(Performance.Attendance, performanceList.get(0));
    }

    @Test
    @DisplayName("Test Set and Get Evaluation")
    public void testSetGetEvaluation() {
        employee.setEvaluation(Evaluation.Unsatisfactory);
        assertEquals(Evaluation.Unsatisfactory, employee.getEvaluation());
    }
}

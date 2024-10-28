package Junit4;

import classes.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.Calendar;
import java.util.Date;

public class LeaveRequestTest {
    private LeaveRequest leaveRequest;
    private Employee employee;
    private Date startDate;
    private Date endDate;
    @BeforeClass
    public static void Message() {
        System.out.println("LeaveRequest Class Testing");
    }

    @Before
    public void setup() {
        Address address = new Address("Nasr city", "Cairo", "00000", "Egypt");
        employee = new Employee("Mazen", 69, "Mizo", "password", address, "Computer Engineering", EmployeeType.Hourly, Evaluation.Excellent);
        startDate = new Date(2024 - 1900, Calendar.AUGUST, 1);
        endDate = new Date(2024 - 1900, Calendar.AUGUST, 10);
        leaveRequest = new LeaveRequest(1,employee,LeaveType.VacationLeave,startDate,endDate);
    }
    @Test
    @DisplayName("Test testGetId")
    public void testGetId() {
        Assertions.assertEquals(1, leaveRequest.getId());
    }

    @Test
    @DisplayName("Test testSetId")
    public void testSetId() {
        leaveRequest.setId(2);
        Assertions.assertEquals(2, leaveRequest.getId());
    }

    @Test
    @DisplayName("Test testGetEmployee")

    public void testGetEmployee() {
        Assertions.assertEquals(employee, leaveRequest.getEmployee());
    }

    @Test
    @DisplayName("Test testSetEmployee")
    public void testSetEmployee() {
        Employee newEmployee = new Employee("Ali", 70, "Ali123", "newpassword", new Address("Heliopolis", "Cairo", "11111", "Egypt"), "Mechanical Engineering", EmployeeType.FullTime, Evaluation.Excellent);
        leaveRequest.setEmployee(newEmployee);
        Assertions.assertEquals(newEmployee, leaveRequest.getEmployee());
    }

    @Test
    @DisplayName("Test testGetLeaveType")
    public void testGetLeaveType() {
        Assertions.assertEquals(LeaveType.VacationLeave, leaveRequest.getLeaveType());
    }

    @Test
    @DisplayName("Test testSetLeaveType")

    public void testSetLeaveType() {
        leaveRequest.setLeaveType(LeaveType.SickLeave);
        Assertions.assertEquals(LeaveType.SickLeave, leaveRequest.getLeaveType());
    }

    @Test
    @DisplayName("Test testGetStartDate")

    public void testGetStartDate() {
        Assertions.assertEquals(startDate, leaveRequest.getStartDate());
    }

    @Test
    @DisplayName("Test testSetStartDate")

    public void testSetStartDate() {
        Date newStartDate = new Date(2024 , Calendar.AUGUST, 5);
        leaveRequest.setStartDate(newStartDate);
        Assertions.assertEquals(newStartDate, leaveRequest.getStartDate());
    }

    @Test
    @DisplayName("Test testGetEndDate")

    public void testGetEndDate() {
        Assertions.assertEquals(endDate, leaveRequest.getEndDate());
    }

    @Test
    @DisplayName("Test testSetEndDate")

    public void testSetEndDate() {
        Date newEndDate = new Date(2024, Calendar.AUGUST, 15);
        leaveRequest.setEndDate(newEndDate);
        Assertions.assertEquals(newEndDate, leaveRequest.getEndDate());
    }

    @Test
    @DisplayName("Test testGetLeaveStatus")

    public void testGetLeaveStatus() {
        Assertions.assertEquals(LeaveStatus.Pending, leaveRequest.getLeaveStatus());
    }

    @Test
    @DisplayName("Test testSetLeaveStatus")

    public void testSetLeaveStatus() {
        leaveRequest.setLeaveStatus(LeaveStatus.Pending);
        Assertions.assertEquals(LeaveStatus.Pending, leaveRequest.getLeaveStatus());
    }

}

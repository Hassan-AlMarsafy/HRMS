package Junit4;

import classes.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HRemployeeTest {

    private HRemployee hrEmployee;
    private Employee employee1;
    private Employee employee2;

    @Before
    public void setUp() {
        hrEmployee = new HRemployee();

        Address address1 = new Address("123 Main St", "Cityville", "12345", "USA");
        employee1 = hrEmployee.createEmployee("Alice", 101, "alice", "password", address1, "HR", EmployeeType.FullTime);

        Address address2 = new Address("456 Elm St", "Townsville", "67890", "USA");
        employee2 = hrEmployee.createEmployee("Bob", 102, "bob", "password", address2, "IT", EmployeeType.PartTime);
    }

    @Test
    public void testCreateEmployee() {
        assertNotNull(employee1);
        assertNotNull(employee2);
    }

    @Test
    public void testFindEmployeeById() {
        Employee foundEmployee = hrEmployee.findEmployeeById(101);
        assertEquals(employee1, foundEmployee);
    }

    @Test
    public void TestRemoveEmployee(){
        int id = employee1.getId();
        hrEmployee.removeEmployee(id);
        assertNull(hrEmployee.findEmployeeById(id));
    }

    @Test
    public void testEvaluateEmployeePerformance() {
        Evaluation aliceEvaluation = hrEmployee.evaluateEmployeePerformance(101);
        assertEquals(Evaluation.Unsatisfactory, aliceEvaluation);
    }

    @Test
    public void testLeaveRequests() {
        LeaveRequest leaveRequest1 = new LeaveRequest(1, employee1, LeaveType.SickLeave, new Date(), new Date());
        LeaveRequest leaveRequest2 = new LeaveRequest(2, employee2, LeaveType.VacationLeave, new Date(), new Date());

        hrEmployee.getAllLeaveRequests().add(leaveRequest1);
        hrEmployee.getAllLeaveRequests().add(leaveRequest2);

        hrEmployee.approveLeaveRequest(1);
        hrEmployee.rejectLeaveRequest(2);

        assertEquals(LeaveStatus.Accepted, leaveRequest1.getLeaveStatus());
        assertEquals(LeaveStatus.Rejected, leaveRequest2.getLeaveStatus());
    }
}

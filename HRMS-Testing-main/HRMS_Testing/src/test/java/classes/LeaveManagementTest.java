package classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LeaveManagementTest {
    private LeaveManagement leaveManagement;
    private LeaveRequest leaveRequest1;
    private LeaveRequest leaveRequest2;

    @BeforeEach
    public void setUp() {
        leaveManagement = new LeaveManagement();
        Address address = new Address("Nasr city", "Cairo", "00000", "Egypt");
        Employee employee = new Employee("Mazen", 60, "Mizo", "password", address, "Computer Engineering", EmployeeType.Hourly,Evaluation.Excellent);
        Date startDate = new Date(2024 - 1900, Calendar.AUGUST, 1);
        Date endDate = new Date(2024 - 1900, Calendar.AUGUST, 10);
        leaveRequest1 = new LeaveRequest(1,employee,LeaveType.VacationLeave,startDate,endDate);
        leaveRequest2 = new LeaveRequest(2,employee,LeaveType.VacationLeave,startDate,endDate);
    }

    @Test
    public void testAddLeaveRequest() {
        leaveManagement.addLeaveRequest(leaveRequest1);
        assertEquals(1, leaveManagement.getAllLeaveRequests().size());
    }

    @Test
    public void testRemoveLeaveRequest() {
        leaveManagement.addLeaveRequest(leaveRequest1);
        boolean removed = leaveManagement.removeLeaveRequest(1);
        assertTrue(removed);
        assertEquals(0, leaveManagement.getAllLeaveRequests().size());
    }

    @Test
    public void testGetLeaveRequest() {
        leaveManagement.addLeaveRequest(leaveRequest1);
        LeaveRequest request = leaveManagement.getLeaveRequest(1);
        assertNotNull(request);
        assertEquals(1, request.getId());
    }

    @Test
    public void testGetAllLeaveRequests() {
        leaveManagement.addLeaveRequest(leaveRequest1);
        leaveManagement.addLeaveRequest(leaveRequest2);
        List<LeaveRequest> requests = leaveManagement.getAllLeaveRequests();
        assertEquals(2, requests.size());
    }


    @Test
    public void testUpdateLeaveStatus() {
        leaveManagement.addLeaveRequest(leaveRequest1);
        leaveManagement.updateLeaveStatus(1, LeaveStatus.Accepted);
        LeaveRequest request = leaveManagement.getLeaveRequest(1);
        assertEquals(LeaveStatus.Accepted, request.getLeaveStatus());
    }

    @Test
    public void testApproveLeaveRequest() {
        leaveManagement.addLeaveRequest(leaveRequest1);
        leaveManagement.approveLeaveRequest(1);
        LeaveRequest request = leaveManagement.getLeaveRequest(1);
        assertEquals(LeaveStatus.Accepted, request.getLeaveStatus());
    }

    @Test
    public void testRejectLeaveRequest() {
        leaveManagement.addLeaveRequest(leaveRequest1);
        leaveManagement.rejectLeaveRequest(1);
        LeaveRequest request = leaveManagement.getLeaveRequest(1);
        assertEquals(LeaveStatus.Rejected, request.getLeaveStatus());
    }
}

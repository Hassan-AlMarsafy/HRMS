package Junit4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AddressTest.class,
        EmployeeTest.class,
        HRemployeeTest.class,
        LeaveManagementTest.class,
        LeaveRequestTest.class,
        PayrollTest.class,
        PerformanceEvaluationTest.class
})
public class TestSuite {
}

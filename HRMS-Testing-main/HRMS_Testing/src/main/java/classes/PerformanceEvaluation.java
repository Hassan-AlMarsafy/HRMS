package classes;

import java.util.List;

public class PerformanceEvaluation {
    private static final int MIN_PERFORMANCE_Excellent = 4;
    private static final int MIN_PERFORMANCE_FOR_MEETS = 3;
    private static final int MIN_PERFORMANCE_FOR_NEEDS_IMPROVEMENT = 2;

    public static Evaluation evaluatePerformance(Employee employee) {
        List<Performance> performanceList = employee.getPerformanceList();
        int numPerformances = performanceList.size();

        if (numPerformances == MIN_PERFORMANCE_FOR_MEETS) {
            employee.setEvaluation(Evaluation.MeetsExpectations);
            return Evaluation.MeetsExpectations;
        }
        else if (numPerformances == MIN_PERFORMANCE_FOR_NEEDS_IMPROVEMENT) {
            employee.setEvaluation(Evaluation.NeedsImprovement);
            return Evaluation.NeedsImprovement;
        }
        else if (numPerformances == MIN_PERFORMANCE_Excellent) {
            employee.setEvaluation(Evaluation.Excellent);
            return Evaluation.Excellent;
        }
        else if (numPerformances > MIN_PERFORMANCE_Excellent) {
            employee.setEvaluation(Evaluation.OverAchieving);
            return Evaluation.OverAchieving;
        }
        else {
            employee.setEvaluation(Evaluation.Unsatisfactory);
            return Evaluation.Unsatisfactory;
        }
    }
}

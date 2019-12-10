package domain;

public class BaseballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "30 minutes of batting practice.";
    }
}

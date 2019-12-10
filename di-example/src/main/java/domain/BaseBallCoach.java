package domain;

public class BaseBallCoach implements Coach {

    private FortuneService fortuneService;

    public BaseBallCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getWorkout() {
        return "30 minutes of batting practice.";
    }

    @Override
    public String getFortune() {
        return fortuneService.getFortune();
    }
}

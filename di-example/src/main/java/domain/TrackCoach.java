package domain;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;
    private String name;
    private String eMail;

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String getEMail() {
        return eMail;
    }

    @Override
    public String getWorkout() {
        return "30 minutes of running uphill.";
    }

    @Override
    public String getFortune() {
        return fortuneService.getFortune();
    }
}

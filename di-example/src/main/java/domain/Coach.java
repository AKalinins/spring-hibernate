package domain;

public interface Coach {

    String getWorkout();
    String getFortune();
    default String getName() {return "";}
    default String getEMail() {return "";}
}

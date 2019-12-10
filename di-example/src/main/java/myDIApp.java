import domain.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class myDIApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml");

        Coach coach = context.getBean("coach", Coach.class);
        System.out.print(coach.getFortune() + " ");
        System.out.println(coach.getWorkout());

        coach = context.getBean("trackCoach", Coach.class);
        System.out.print(coach.getFortune() + " ");
        System.out.println(coach.getWorkout() + " (c)" + coach.getName());
        System.out.println(coach.getEMail());

        context.close();
    }
}

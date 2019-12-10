import domain.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class myApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml");

        Coach coach = context.getBean("coach", Coach.class);

        System.out.println(coach.getDailyWorkout());

        context.close();
    }
}

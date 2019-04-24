import com.example.Demo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void springTest() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Demo user = (Demo) ac.getBean("Demo");
        System.out.println(user);
    }/* out
    com.example.Demo@78ac1102
    */
}

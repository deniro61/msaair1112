package msaair.common;


import msaair.ReservationhistApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { ReservationhistApplication.class })
public class CucumberSpingConfiguration {
    
}

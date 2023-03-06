package msaair.common;


import msaair.ReservationmgmtApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { ReservationmgmtApplication.class })
public class CucumberSpingConfiguration {
    
}

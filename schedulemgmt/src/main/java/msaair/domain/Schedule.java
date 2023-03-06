package msaair.domain;

import msaair.SchedulemgmtApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Schedule_table")
@Data

public class Schedule  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long scheduleId;
    
    
    
    
    
    private String departure;
    
    
    
    
    
    private String arrival;
    
    
    
    
    
    private Date departtureTime;
    
    
    
    
    
    private Date arrivalTime;

    @PostPersist
    public void onPostPersist(){
    }

    public static ScheduleRepository repository(){
        ScheduleRepository scheduleRepository = SchedulemgmtApplication.applicationContext.getBean(ScheduleRepository.class);
        return scheduleRepository;
    }






}

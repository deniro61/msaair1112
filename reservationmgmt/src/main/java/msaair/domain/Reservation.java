package msaair.domain;

import msaair.domain.ReservationCreated;
import msaair.domain.ReservationCancelled;
import msaair.ReservationmgmtApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Reservation_table")
@Data

public class Reservation  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long reservationId;
    
    
    
    
    
    private Long customerId;
    
    
    
    
    
    private Integer peopleNo;
    
    
    
    
    
    private Integer mileageToIncrease;
    
    
    
    
    
    private Long scheduleId;

    @PostPersist
    public void onPostPersist(){


        ReservationCreated reservationCreated = new ReservationCreated(this);
        reservationCreated.publishAfterCommit();



        ReservationCancelled reservationCancelled = new ReservationCancelled(this);
        reservationCancelled.publishAfterCommit();

        // Get request from Mileage
        //msaair.external.Mileage mileage =
        //    Application.applicationContext.getBean(msaair.external.MileageService.class)
        //    .getMileage(/** mapping value needed */);

    }

    public static ReservationRepository repository(){
        ReservationRepository reservationRepository = ReservationmgmtApplication.applicationContext.getBean(ReservationRepository.class);
        return reservationRepository;
    }






}

package msaair.domain;

import msaair.domain.Mileageincreased;
import msaair.domain.MileageDecreased;
import msaair.CustomermgmtApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Mileage_table")
@Data

public class Mileage  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long customerId;
    
    
    
    
    
    private Long mileage;

    @PostPersist
    public void onPostPersist(){


        Mileageincreased mileageincreased = new Mileageincreased(this);
        mileageincreased.publishAfterCommit();



        MileageDecreased mileageDecreased = new MileageDecreased(this);
        mileageDecreased.publishAfterCommit();

    }

    public static MileageRepository repository(){
        MileageRepository mileageRepository = CustomermgmtApplication.applicationContext.getBean(MileageRepository.class);
        return mileageRepository;
    }




    public static void accumulateMileage(ReservationCreated reservationCreated){

        /** Example 1:  new item 
        Mileage mileage = new Mileage();
        repository().save(mileage);

        Mileageincreased mileageincreased = new Mileageincreased(mileage);
        mileageincreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(reservationCreated.get???()).ifPresent(mileage->{
            
            mileage // do something
            repository().save(mileage);

            Mileageincreased mileageincreased = new Mileageincreased(mileage);
            mileageincreased.publishAfterCommit();

         });
        */

        
    }
    public static void cancelMileage(ReservationCancelled reservationCancelled){

        /** Example 1:  new item 
        Mileage mileage = new Mileage();
        repository().save(mileage);

        MileageDecreased mileageDecreased = new MileageDecreased(mileage);
        mileageDecreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(reservationCancelled.get???()).ifPresent(mileage->{
            
            mileage // do something
            repository().save(mileage);

            MileageDecreased mileageDecreased = new MileageDecreased(mileage);
            mileageDecreased.publishAfterCommit();

         });
        */

        
    }


}

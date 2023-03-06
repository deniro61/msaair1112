package msaair.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import msaair.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import msaair.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired NotificationRepository notificationRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='ReservationCreated'")
    public void wheneverReservationCreated_SendNotification(@Payload ReservationCreated reservationCreated){

        ReservationCreated event = reservationCreated;
        System.out.println("\n\n##### listener SendNotification : " + reservationCreated + "\n\n");


        

        // Sample Logic //
        Notification.sendNotification(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='ReservationCancelled'")
    public void wheneverReservationCancelled_SendNotification(@Payload ReservationCancelled reservationCancelled){

        ReservationCancelled event = reservationCancelled;
        System.out.println("\n\n##### listener SendNotification : " + reservationCancelled + "\n\n");


        

        // Sample Logic //
        Notification.sendNotification(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='MileageDecreased'")
    public void wheneverMileageDecreased_SendNotification(@Payload MileageDecreased mileageDecreased){

        MileageDecreased event = mileageDecreased;
        System.out.println("\n\n##### listener SendNotification : " + mileageDecreased + "\n\n");


        

        // Sample Logic //
        Notification.sendNotification(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Mileageincreased'")
    public void wheneverMileageincreased_SendNotification(@Payload Mileageincreased mileageincreased){

        Mileageincreased event = mileageincreased;
        System.out.println("\n\n##### listener SendNotification : " + mileageincreased + "\n\n");


        

        // Sample Logic //
        Notification.sendNotification(event);
        

        

    }

}



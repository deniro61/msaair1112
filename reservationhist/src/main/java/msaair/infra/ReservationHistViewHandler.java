package msaair.infra;

import msaair.domain.*;
import msaair.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationHistViewHandler {

    @Autowired
    private ReservationHistRepository reservationHistRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationCreated_then_CREATE_1 (@Payload ReservationCreated reservationCreated) {
        try {

            if (!reservationCreated.validate()) return;

            // view 객체 생성
            ReservationHist reservationHist = new ReservationHist();
            // view 객체에 이벤트의 Value 를 set 함
            reservationHist.setCustomerId(reservationCreated.getCustomerId());
            reservationHist.setScheduleId(reservationCreated.getScheduleId());
            reservationHist.setReservationStatus("예약등록");
            // view 레파지 토리에 save
            reservationHistRepository.save(reservationHist);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenMileageincreased_then_UPDATE_1(@Payload Mileageincreased mileageincreased) {
        try {
            if (!mileageincreased.validate()) return;
                // view 객체 조회

                List<ReservationHist> reservationHistList = reservationHistRepository.findByCustomerId(mileageincreased.getId());
                for(ReservationHist reservationHist : reservationHistList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    reservationHist.setMilieage(mileageincreased.getMileage());
                // view 레파지 토리에 save
                reservationHistRepository.save(reservationHist);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationCancelled_then_DELETE_1(@Payload ReservationCancelled reservationCancelled) {
        try {
            if (!reservationCancelled.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            reservationHistRepository.deleteByCustomerId(reservationCancelled.getCustomerId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}


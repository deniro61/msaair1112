package msaair.domain;

import msaair.domain.*;
import msaair.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class ReservationCancelled extends AbstractEvent {

    private Long reservationId;
    private Integer peopleNo;
    private Integer mileageToIncrease;
    private Long scheduleId;
    private Long customerId;

    public ReservationCancelled(Reservation aggregate){
        super(aggregate);
    }
    public ReservationCancelled(){
        super();
    }
}

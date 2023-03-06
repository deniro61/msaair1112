package msaair.domain;

import msaair.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class ReservationCreated extends AbstractEvent {

    private Long reservationId;
    private Integer peopleNo;
    private Integer mileageToIncrease;
    private Long scheduleId;
    private Long customerId;
}

package msaair.domain;

import msaair.domain.*;
import msaair.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class MileageDecreased extends AbstractEvent {

    private Long customerId;
    private Integer mileage;

    public MileageDecreased(Mileage aggregate){
        super(aggregate);
    }
    public MileageDecreased(){
        super();
    }
}

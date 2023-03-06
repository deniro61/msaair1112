package msaair.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;


@FeignClient(name = "customermgmt", url = "${api.url.customermgmt}")
public interface MileageService {
    @RequestMapping(method= RequestMethod.GET, path="/mileages/{customerId}")
    public Mileage getMileage(@PathVariable("customerId") Long customerId);
}

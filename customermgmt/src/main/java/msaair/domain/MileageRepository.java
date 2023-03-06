package msaair.domain;

import msaair.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="mileages", path="mileages")
public interface MileageRepository extends PagingAndSortingRepository<Mileage, Long>{

}

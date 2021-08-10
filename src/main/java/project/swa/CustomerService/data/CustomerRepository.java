package project.swa.CustomerService.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import project.swa.CustomerService.domain.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

}

package project.swa.CustomerCommand.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import project.swa.CustomerCommand.domain.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

}

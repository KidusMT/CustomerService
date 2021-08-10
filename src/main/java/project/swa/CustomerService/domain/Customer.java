package project.swa.CustomerService.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "CUSTOMER")
public class Customer {
    @Id
    private String customerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Address address;

    public Customer(String customerId, String firstName, String lastName, String phoneNumber, String email, Address address) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }
}

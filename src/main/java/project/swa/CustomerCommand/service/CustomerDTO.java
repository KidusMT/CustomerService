package project.swa.CustomerCommand.service;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import project.swa.CustomerCommand.domain.Address;

@Data
public class CustomerDTO {
    private String customerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Address address;

    public CustomerDTO(String customerId, String firstName, String lastName, String phoneNumber, String email, Address address) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }
}

package project.swa.CustomerService.service;

import lombok.Data;
import project.swa.CustomerService.domain.Address;

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

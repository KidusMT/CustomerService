package project.swa.CustomerService.service;

import project.swa.CustomerService.domain.Customer;

public class CustomerAdapter {
    public static Customer getCustomer(CustomerDTO customerDTO) {
        return new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getFirstName(),
                customerDTO.getLastName(),
                customerDTO.getPhoneNumber(),
                customerDTO.getEmail(),
                customerDTO.getAddress());
    }

    public static CustomerDTO getCustomerDTO(Customer customer) {
        return new CustomerDTO(customer.getCustomerId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getPhoneNumber(),
                customer.getEmail(),
                customer.getAddress());
    }
}

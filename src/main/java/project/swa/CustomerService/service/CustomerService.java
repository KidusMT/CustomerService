package project.swa.CustomerService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.swa.CustomerService.exception.CustomerNotFoundException;
import project.swa.CustomerService.data.CustomerRepository;
import project.swa.CustomerService.domain.Customer;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<CustomerDTO> getAll() {
        return customerRepository.findAll().stream().map(CustomerAdapter::getCustomerDTO).toList();
    }

    public CustomerDTO add(CustomerDTO customerDTO) {
        Customer customer = customerRepository.save(CustomerAdapter.getCustomer(customerDTO));
        return CustomerAdapter.getCustomerDTO(customer);
    }

    public CustomerDTO update(String id, CustomerDTO customerDTO) {
        Optional<Customer> customerDTO1 = customerRepository.findById(id);
        if (customerDTO1.isPresent()) {
            customerDTO.setCustomerId(id);
            Customer customer = customerRepository.save(CustomerAdapter.getCustomer(customerDTO));
            return CustomerAdapter.getCustomerDTO(customer);
        }
//        throw new CustomerNotFoundException();
        return null;
    }

    public CustomerDTO delete(String customerId) throws CustomerNotFoundException {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            customerRepository.delete(customer);
            return CustomerAdapter.getCustomerDTO(customer);
        }
//        throw new CustomerNotFoundException();
        return null;
    }
}

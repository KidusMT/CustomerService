package project.swa.CustomerCommand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.swa.CustomerCommand.exception.CustomerNotFoundException;
import project.swa.CustomerCommand.integration.KafkaSender;
import project.swa.CustomerCommand.service.CustomerDTO;
import project.swa.CustomerCommand.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private KafkaSender kafkaSender;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getCustomers() {
        List<CustomerDTO> customerDTO1 = customerService.getAll();
        try {
            if (customerDTO1 != null) {
                return new ResponseEntity<>(customerDTO1, HttpStatus.CREATED);
            } else {
                throw new CustomerNotFoundException("Customer not found");
            }
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO customerDTO1 = customerService.add(customerDTO);
        try {
            if (customerDTO1 != null) {
                kafkaSender.send(customerDTO1);
                return new ResponseEntity<>(customerDTO1, HttpStatus.CREATED);
            } else {
                throw new CustomerNotFoundException("Customer not found");
            }
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable String id, @RequestBody CustomerDTO customerDTO) {
        CustomerDTO customerDTO1 = customerService.update(id, customerDTO);
        if (customerDTO1 != null) {
            kafkaSender.send(customerDTO1);
            return new ResponseEntity<>(customerDTO1, HttpStatus.CREATED);
        } else {
            throw new CustomerNotFoundException("Customer not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable String id) {
        CustomerDTO customerDTO1 = customerService.delete(id);
        if (customerDTO1 != null) {
            return new ResponseEntity<>(customerDTO1, HttpStatus.CREATED);
        } else {
            throw new CustomerNotFoundException("customer not found");
        }
    }
}

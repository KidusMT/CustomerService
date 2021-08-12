package project.swa.CustomerService.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.swa.CustomerService.exception.CustomerNotFoundException;
import project.swa.CustomerService.integration.KafkaSender;
import project.swa.CustomerService.service.CustomerDTO;
import project.swa.CustomerService.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
//    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class.getName());
    private static final Logger logger = LogManager.getLogger(CustomerController.class.getName());
    @Autowired
    private CustomerService customerService;

    @Autowired
    private KafkaSender kafkaSender;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getCustomers() {
        logger.warn("Calling GET /customer");
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
        logger.warn("Calling POST /customer");
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
        logger.warn("Calling PUT /customer");
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
        logger.warn("Calling DELETE /customer");
        CustomerDTO customerDTO1 = customerService.delete(id);
        if (customerDTO1 != null) {
            return new ResponseEntity<>(customerDTO1, HttpStatus.CREATED);
        } else {
            throw new CustomerNotFoundException("customer not found");
        }
    }
}

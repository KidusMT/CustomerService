package project.swa.CustomerService.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import project.swa.CustomerService.service.CustomerDTO;

@Component
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, CustomerDTO> kafkaTemplate;

    @Value("${app.topic.customertopic}")//app.topic.customertopic
    private String topic;

    public void send(CustomerDTO customerDTO){
        kafkaTemplate.send(topic, customerDTO);
    }
}

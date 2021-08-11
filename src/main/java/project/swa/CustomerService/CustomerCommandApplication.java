package project.swa.CustomerService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
@EnableFeignClients
@EnableDiscoveryClient
public class CustomerCommandApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerCommandApplication.class, args);
	}

}

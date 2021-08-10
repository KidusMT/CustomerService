package project.swa.CustomerCommand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class CustomerCommandApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerCommandApplication.class, args);
	}

}

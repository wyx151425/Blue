package blue.microservice.bus;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author WangZhenqi
 */
@EnableEurekaClient
@SpringBootApplication
public class BusApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(BusApplication.class).web(true).run(args);
	}
}

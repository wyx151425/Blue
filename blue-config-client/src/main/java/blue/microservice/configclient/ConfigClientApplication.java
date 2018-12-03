package blue.microservice.configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangZhenqi
 */
@RestController
@EnableEurekaClient
@SpringBootApplication
public class ConfigClientApplication {

    private final Environment env;

    @Autowired
    public ConfigClientApplication(Environment env) {
        this.env = env;
    }

    @RequestMapping("/")
    public String home() {
        String name = env.getProperty("test.user.name");
        return "Hello " + name;
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigClientApplication.class).web(true).run(args);
    }
}

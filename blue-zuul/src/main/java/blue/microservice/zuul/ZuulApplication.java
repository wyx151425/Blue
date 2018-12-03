package blue.microservice.zuul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangZhenqi
 */
@RestController
@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication {
	
	private final Environment env;

	@Autowired
	public ZuulApplication(Environment env) {
		this.env = env;
	}

	@RequestMapping("/")
	public String home() {
		System.out.println("读取到的值：" + env.getProperty("test.user.name"));
		return "Hello";
	}
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(ZuulApplication.class).run(args);
	}
}

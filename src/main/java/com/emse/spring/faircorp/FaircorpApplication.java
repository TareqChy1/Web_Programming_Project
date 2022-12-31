package com.emse.spring.faircorp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * This is the main class for Faircorp application and this is the application's entry point.
 * <p>
 * This class uses annotation `@SpringBootApplication`. This annotation is used to enable three features, that is:
 * `@EnableAutoConfiguration`: enable Spring Boot’s auto-configuration mechanism.
 * `@ComponentScan`: enable @Component scan on the package where the application is located.
 * `@Configuration`: allow to register extra beans in the context or import additional configuration classes.
 * <p>
 * On startup Spring Boot will automatically scan all sub packages defined in com.emse.spring.faircorp.
 * If these packages contain Spring Beans (classes annotated with special annotations LIKE `@Controller`, `@Service`)
 * Spring Boot will automatically add them to the Spring context.
 */

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class FaircorpApplication {

	/**
	 * FaircorpApplication is a bootable class because it contains a main class.
	 * SpringApplication is a predefine class in the spring boot and run is a static method which is available in this class.
	 * @param args the application's  arguments (usually passed from a Java main method).
	 * `@return` the running ApplicationContext.
	 */
	public static void main(String[] args) {
		SpringApplication.run(FaircorpApplication.class, args);
	}


}
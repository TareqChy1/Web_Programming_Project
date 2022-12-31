package com.emse.spring.faircorp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * The`@SpringBootTest` annotation is used to bootstrap the entire container.
 * The annotation works by creating the ApplicationContext that will be utilized in our tests.
 * We can use the webEnvironment attribute of `@SpringBootTest` to configure our runtime environment.
 */

@SpringBootTest

/**
 * This is the test file of FaircorpApplication.
 * In this all files are tested and verified.
 */
public class FaircorpApplicationTests {

	@Test
	public void contextLoads() {
	}

}

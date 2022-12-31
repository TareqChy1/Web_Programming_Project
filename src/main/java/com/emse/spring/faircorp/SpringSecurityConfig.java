package com.emse.spring.faircorp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;


/**
 * SpringSecurityConfig helps to add authentication and authorization to  web application.
 * `@Configuration` tells Spring container that there is one or more beans that needs to be dealt with on runtime.
 */
@Configuration
public class SpringSecurityConfig {

    private static final String ROLE_USER = "USER";
    private static final String ROLE_ADMIN = "ADMIN";


    /**
     * userDetailsService can be configured to manage the user and their permissions.
     */
    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        manager.createUser(User.withUsername("user").password(
                encoder.encode("password")).roles(ROLE_USER).build()
        );

        manager.createUser(User.withUsername("admin").password(
                        encoder.encode("admin")).roles(ROLE_USER,ROLE_ADMIN).build()
        );

        return manager;
    }


    /**
     * Several SecurityFilterChain can be used to implement different security level.
     * <p>
     * For understanding more than one filter need to use an annotation `@Order` to define the first one to use.
     * antMatcher states that this HttpSecurity will only be applicable to URLs that start with /api/.
     * It is possible to specify the roles that will really have access to this HTTP route.
     * </p>
     */
    @Bean
    @Order(1)
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
                .csrf().disable()
                .antMatcher("/api/**")
                .authorizeRequests(authorize -> authorize.anyRequest().authenticated())
                .formLogin(withDefaults())
                .httpBasic(withDefaults())
                .build();

    }

    /**
     * SecurityFilterChain is added to secure a http route.
     * <p>
     * Allows users to authenticate with HTTP Basic authentication.
     * Allows users to authenticate with form based login.
     * Ensures that any request to our application requires the user to be authenticated.
     * </p>
     */
    @Bean
    public SecurityFilterChain filterChainMain(HttpSecurity http) throws Exception {

        return http
                .authorizeRequests(authorize -> authorize.anyRequest().permitAll())
                .formLogin(withDefaults())
                .httpBasic(withDefaults())
                .build();

    }


}
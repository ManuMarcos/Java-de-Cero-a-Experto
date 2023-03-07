package arg.com.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    /*
    @Autowired
    private DataSource dataSource;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    //Enable jdbc authentication
    @Bean
    JdbcUserDetailsManager users(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        return jdbcUserDetailsManager;
    }
    */

    @Bean
    InMemoryUserDetailsManager users() {
        return new InMemoryUserDetailsManager(
                User.withUsername("manu")
                        .password("{noop}manu")
                        .roles("ADMIN", "USER")
                        .build()
        );
    }


    //Autorizacion
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //TO DO: Pagina de error personalizada
        http
                .authorizeHttpRequests()
                .requestMatchers("/login")
                .permitAll()
                .requestMatchers("/")
                .hasAnyRole("USER", "ADMIN")
                .requestMatchers("/editar/**", "/agregar/**", "/eliminar")
                .hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
        ;
        return http.build();

    }
}

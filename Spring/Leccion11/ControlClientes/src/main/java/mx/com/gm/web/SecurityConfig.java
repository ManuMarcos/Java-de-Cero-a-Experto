package mx.com.gm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    
    //Autenticacion
    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails admin = User.withUsername("admin")
            .password("{noop}123")
            .roles("ADMIN", "USER")
            .build();
        UserDetails user = User.withUsername("user")
            .password("{noop}123")
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(admin, user);
    }
    
    //Autorizacion
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        //TO DO: Pagina de error personalizada
        http
                .authorizeHttpRequests()
                .requestMatchers("/login")
                    .permitAll()
                .requestMatchers("/")
                    .hasAnyRole("USER","ADMIN")
                .requestMatchers("/editar/**", "/agregar/**", "/eliminar")
                    .hasRole("ADMIN")
                    //.anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
               ;
        return http.build();
                
    }
   
    
}



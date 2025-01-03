package com.challenge.esercizio.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance(); //psw memorizzata in chiaro (no cifratura)
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); //la password verrà criptata sul DB
    }

//    @Bean
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
//
//        http.authorizeHttpRequests(
//                requests -> requests.anyRequest().denyAll()
//        )
//                .formLogin(Customizer.withDefaults()) //sia da login form
//                .httpBasic(Customizer.withDefaults()); //che da postman
//        //nega tutte le richieste
//        return  http.build();
//    }

//    @Bean
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
//
//        http.authorizeHttpRequests(
//                        requests -> requests.anyRequest().permitAll()
//                )
//                .formLogin(Customizer.withDefaults()) //sia da login form
//                .httpBasic(Customizer.withDefaults()); //che da postman
//        //permette tutte le richieste
//        return  http.build();
//    }

//    @Bean
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
//
//        http.authorizeHttpRequests(
//                        requests -> requests
//                                .requestMatchers("/risposte").authenticated()
//                                .requestMatchers("/domande/**").permitAll()
//                )
//                .formLogin(Customizer.withDefaults()) //sia da login form
//                .httpBasic(Customizer.withDefaults()); //che da postman
//        //richiede autenticazione su alcune uri e su altre no
//        return  http.build();
//    }

//    @Bean
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
//
//        http.authorizeHttpRequests(
//                        requests -> requests
//                                .requestMatchers("/domande").permitAll()
//                                .anyRequest().hasAuthority("administrator")
//                )
//                .formLogin(Customizer.withDefaults()) //sia da login form
//                .httpBasic(Customizer.withDefaults()); //che da postman
//        //richiede autenticazione su alcune uri e su altre no
//        return  http.build();
//    }

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{

        http
                .csrf((csrf)->csrf.disable())
                .authorizeHttpRequests(
                        requests -> requests
                                .requestMatchers("/domande").permitAll()
                                .requestMatchers("/customer").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults()) //sia da login form
                .httpBasic(Customizer.withDefaults()); //che da postman
                //richiede autenticazione su alcune uri e su altre no


        return  http.build();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService(){
//
//        UserDetails admin = User.withUsername("admin")
//                .password("admin")
//                .authorities("administrator") //profilo
//                .build();
//
//        UserDetails user = User.withUsername("user")
//                .password("1234")
//                .authorities("read","writer") //profili
//                .build();
//
//        return new InMemoryUserDetailsManager(admin,user); //restituisco gli utenti abilitati ad usare i nostrsi servizi
//    }
}

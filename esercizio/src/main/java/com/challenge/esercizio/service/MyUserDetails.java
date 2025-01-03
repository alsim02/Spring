package com.challenge.esercizio.service;

import com.challenge.esercizio.model.Customer;
import com.challenge.esercizio.repository.CustomerRepository;
import com.challenge.esercizio.repository.RisposteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetails implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String userName;
        String password;
        List<GrantedAuthority> authorities;
        List<Customer> customers = customerRepository.findByEmail(username);

        if(customers.size()==0){
            throw new UsernameNotFoundException("User details not found");
        }
        else{
            userName = customers.get(0).getEmail();
            password = customers.get(0).getPsw();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(customers.get(0).getRole()));

        }

        return new User(userName,password,authorities);
    }
}

package com.school.circuits.service;

import com.school.circuits.entities.Users;
import com.school.circuits.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService {

    private UsersRepository UsersRepository;
    private static final Logger logger = LoggerFactory.getLogger(UsersService.class);

    public UserDetailsServiceImpl(UsersRepository UsersRepository) {
        this.UsersRepository = UsersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users applicationUser = UsersRepository.findByNombreusuario(username).get();
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }

        return new User(applicationUser.getNombreusuario(), applicationUser.getClave(), emptyList());
    }

}

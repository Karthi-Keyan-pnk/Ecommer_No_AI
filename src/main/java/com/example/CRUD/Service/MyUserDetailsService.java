package com.example.CRUD.Service;

import com.example.CRUD.Module.User;
import com.example.CRUD.Module.UserPrincipal;
import com.example.CRUD.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userRepo.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException(username);
        }
        return new UserPrincipal(user);

    }
}

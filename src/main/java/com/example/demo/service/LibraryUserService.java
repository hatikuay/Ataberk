package com.example.demo.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.LibraryUser;
import com.example.demo.repository.LibraryUserRepository;

@Service
public class LibraryUserService implements UserDetailsService {

  @Autowired
  private LibraryUserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public void save(LibraryUser user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userRepository.save(user);

  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    LibraryUser user = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not found"));

    return new org.springframework.security.core.userdetails.User(
        user.getUsername(), user.getPassword(),
        Collections.singleton(new SimpleGrantedAuthority("Role_" + user.getRole())));

  }

}

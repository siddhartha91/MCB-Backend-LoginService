//package com.mcb.app.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.mcb.app.entities.User;
//import com.mcb.app.repository.UserRepository;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Service
//@Slf4j
//public class AppUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        if(user!=null){
//        	log.info("logged_in user :"+username);
//            return new AppUserDetails(user); //return user login details from database
//        }else{
//        	log.info("Loggin Error:"+username);
//            throw new UsernameNotFoundException("User does not exist!");
//        }
//    }
//}

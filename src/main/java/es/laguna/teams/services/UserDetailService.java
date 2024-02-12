package es.laguna.teams.services;

import es.laguna.teams.Models.user.User;
import es.laguna.teams.Repositories.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailService  implements UserDetailsService {
    private final UserDetailsRepository userDetailsRepository;
   // private final PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userDetailsRepository.findByEmail(email);
    }
    public List<User> getAll(){
        return userDetailsRepository.findAll();
    }

}

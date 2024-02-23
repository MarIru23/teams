package es.laguna.teams.services;

import es.laguna.teams.Models.user.User;
import es.laguna.teams.Repositories.UserDetailsRepository;
import es.laguna.teams.auth.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserDetailsRepository userDetailsRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        return userDetailsRepository.findByEmail(email);
    }

    public UserDetails create(SignUpRequest signupRequest){
        return userDetailsRepository.save(
                new User(
                        signupRequest.getEmail(),
                        passwordEncoder.encode(signupRequest.getPassword()
                        )
                )
        );
    }
    public User save(User user){
        return userDetailsRepository.save(user);
    }
    public User updateUser(String email, User user) {
        User userUpdated = this.loadUserByUsername(email);
        userUpdated.setFirstname(user.getFirstname());
        userUpdated.setLastname(user.getLastname());
        userDetailsRepository.save(userUpdated);
        return userUpdated;
    }


}

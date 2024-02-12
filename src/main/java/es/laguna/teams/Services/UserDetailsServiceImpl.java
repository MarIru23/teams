package es.laguna.teams.Services;

import es.laguna.teams.Models.user.User;
import es.laguna.teams.Repositories.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

//Tenemos que implementar de esa clase que noc reamos nosotros, e importamos métodos
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;
    //private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userDetailsRepository.findByEmail(email);
    }

    public List<User> getAll(){
        return userDetailsRepository.findAll();
    }

    /*public UserDetails create(SignupRequest signupRequest){
        return userDetailsRepository.save(
                new User(
                        signupRequest.getEmail(),
                        passwordEncoder.encode(signupRequest.getPassword()
                        )
                )
        );
    }
*/

}

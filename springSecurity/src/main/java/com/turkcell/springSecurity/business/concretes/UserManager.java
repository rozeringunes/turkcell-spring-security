package com.turkcell.springSecurity.business.concretes;

import com.turkcell.springSecurity.business.abstracts.UserService;
import com.turkcell.springSecurity.business.dto.requests.RegisterRequest;
import com.turkcell.springSecurity.business.messages.AuthMessages;
import com.turkcell.springSecurity.core.utilities.exceptions.types.BusinessException;
import com.turkcell.springSecurity.core.utilities.mapping.ModelMapperService;
import com.turkcell.springSecurity.dataAccess.abstracts.UserRepository;
import com.turkcell.springSecurity.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserManager implements UserService {
    private UserRepository userRepository;
    private ModelMapperService modelMapperService;
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(RegisterRequest request) {
        //TODO:Business Rule,Validation
        User user = modelMapperService.forRequest().map(request, User.class);
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findUserByEmail(username).orElseThrow();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findUserByEmail(username)
                .orElseThrow(()-> new BusinessException(AuthMessages.LOGIN_FAILED));
    }
}

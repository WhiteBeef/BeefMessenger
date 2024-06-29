package ru.whitebeef.beefmessenger.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.whitebeef.beefmessenger.dto.LoginDataDto;
import ru.whitebeef.beefmessenger.dto.UserDto;
import ru.whitebeef.beefmessenger.entities.User;
import ru.whitebeef.beefmessenger.entities.UserRole;
import ru.whitebeef.beefmessenger.exceptions.IncorrectCredentialsException;
import ru.whitebeef.beefmessenger.mappers.UserMapper;
import ru.whitebeef.beefmessenger.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {


    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getUser(username);
    }

    public User getUser(String username) {
        return userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException(String.format("User with username %s not found", username)));
    }


    @Transactional
    public void signUpUser(LoginDataDto loginDataDto) {
        UserDto userDto = userMapper.authRequestDtoToUserDto(loginDataDto);

        if (userRepository.findByUsername(userDto.getUsername()).isPresent()) {
            throw new UsernameNotFoundException("Username already taken!");
        }

        userDto.setEnabled(true);
        userDto.setLocked(false);
        userDto.setUserRole(UserRole.USER);

        User user = userMapper.userDtoToUser(userDto);

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);
        userRepository.save(user);
    }

    public void loginUser(LoginDataDto loginDataDto) {
        UserDto userDto = userMapper.authRequestDtoToUserDto(loginDataDto);
        Optional<User> user = userRepository.findByUsername(userDto.getUsername());
        if (user.isEmpty()) {
            throw new IncorrectCredentialsException("Username or password is incorrect!");
        }

        if (!bCryptPasswordEncoder.matches(userDto.getPassword(), user.get().getPassword())) {
            throw new IncorrectCredentialsException("Username or password is incorrect!");
        }
    }

}

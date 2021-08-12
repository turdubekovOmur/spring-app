package kg.web.springapp.service.impl;

import kg.web.springapp.model.User;
import kg.web.springapp.model.dto.UserConverter;
import kg.web.springapp.model.dto.UserDto;
import kg.web.springapp.repository.UserRepository;
import kg.web.springapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Override
    public UserDto saveUser(UserDto userDto) {
        User savedUser = userRepository.save(userConverter.fromDtoToUser(userDto));
        return userConverter.fromUserToDto(savedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserDto findByLongin(String login) {
        User user = userRepository.findByLogin(login);
        if (user != null) {
            return userConverter.fromUserToDto(user);
        }
        return null;
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(userConverter::fromUserToDto)
                .collect(Collectors.toList());
    }
}

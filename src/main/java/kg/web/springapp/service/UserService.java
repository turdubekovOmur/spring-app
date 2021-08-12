package kg.web.springapp.service;

import kg.web.springapp.model.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto saveUser(UserDto userDto);

    void deleteUser(Long userId);

    UserDto findByLongin(String login);

    List<UserDto> findAll();



}

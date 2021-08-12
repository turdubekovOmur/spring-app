package kg.web.springapp.model.dto;

import kg.web.springapp.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User fromDtoToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setLogin(userDto.getLogin());
        user.setEmail(userDto.getEmail());
        return user;
    }

    public UserDto fromUserToDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .login(user.getLogin())
                .email(user.getEmail())
                .build();
    }


}

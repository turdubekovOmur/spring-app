package kg.web.springapp.controller;

import kg.web.springapp.model.dto.UserDto;
import kg.web.springapp.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public UserDto save(@RequestBody @Valid UserDto userDto){
        return userService.saveUser(userDto);
    }

    @GetMapping("/findAll")
    public List<UserDto> findAll(){
        return userService.findAll();
    }

    @GetMapping("findByLogin")
    public  UserDto findByLogin(String login){
        return userService.findByLongin(login);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }



}

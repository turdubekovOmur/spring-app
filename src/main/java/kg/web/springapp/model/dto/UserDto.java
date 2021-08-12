package kg.web.springapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Builder
@Data
@AllArgsConstructor
public class UserDto {
    private Long id;

    @NotBlank(message = "Необходимо указать имя")
    private String name;

    @NotBlank(message = "Необходимо указать логин")
    private String login;

    @Email(message = "email должен быть коректным")
    private String email;
}

package bcy.user;

import lombok.Getter;

@Getter
public class UserDto {
    private String name;
    private String email;
    private String picture;

    public UserDto(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}

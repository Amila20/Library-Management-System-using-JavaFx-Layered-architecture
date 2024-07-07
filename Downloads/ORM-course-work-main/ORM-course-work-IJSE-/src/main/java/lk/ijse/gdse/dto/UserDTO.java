package lk.ijse.gdse.dto;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
public class UserDTO {
    private String fullName;
    private String userName;
    private String email;
    private String password;

}

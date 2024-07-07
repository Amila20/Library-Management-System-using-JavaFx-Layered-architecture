package lk.ijse.gdse.entity;

import lk.ijse.gdse.dto.UserDTO;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@Entity
public class User implements SuperEntity {
    @Column(nullable = false)
    private String fullName;
    @Id
    private String userName;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String password;


}

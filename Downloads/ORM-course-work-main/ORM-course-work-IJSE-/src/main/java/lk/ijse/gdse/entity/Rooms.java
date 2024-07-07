package lk.ijse.gdse.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@Entity
public class Rooms {
    @Id
    private String room_type_id;
    private String type;
    private String key_money;
    private int qty;

}

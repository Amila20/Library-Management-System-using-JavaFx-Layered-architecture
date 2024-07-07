package lk.ijse.gdse.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
public class ReservationDTO {
    private String res_id;
    private Date date;
    private String student_id;
    private String room_type_id;
    private String status;
}

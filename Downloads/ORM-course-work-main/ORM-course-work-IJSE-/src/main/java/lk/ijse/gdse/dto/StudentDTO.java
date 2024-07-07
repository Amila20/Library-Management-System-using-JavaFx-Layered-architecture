package lk.ijse.gdse.dto;

import lombok.*;

import java.util.Date;
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
public class StudentDTO {
    private String student_id;
    private String name;
    private String address;
    private String contact_no;
    private Date dob;
    private String gender;


}

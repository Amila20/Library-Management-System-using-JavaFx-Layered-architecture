package com.Ijse.gdse.Controller;

import com.Ijse.gdse.Dao.SQLUtil;
import com.Ijse.gdse.Dto.MemberDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberCrudController {




    public static MemberDTO getMemberDetails(String id) throws SQLException, ClassNotFoundException {

         ResultSet resultSet= SQLUtil.executeQuery("SELECT * FROM   member WHERE memberId=?",id);
         if (resultSet.next()){
             return new MemberDTO(
                     resultSet.getString(1),
                     resultSet.getString(2),
                     resultSet.getString(3),
                     resultSet.getInt(4),
                     resultSet.getDate(5)
             );
         }
         return null;
    }




}

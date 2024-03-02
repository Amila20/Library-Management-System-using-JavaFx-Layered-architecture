package com.Ijse.gdse.Controller;

import com.Ijse.gdse.Dao.SQLUtil;
import com.Ijse.gdse.Dto.BookDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BooksCrudController {
    public static BookDTO getBookDetails(String id) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.executeQuery("SELECT * FROM book WHERE  book_id=?",id);
        if (resultSet.next()) {
            return new BookDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4)
            );
        }
        return null;
    }




}

package com.Ijse.gdse.Dao.Custom.Impl;

import com.Ijse.gdse.Dao.Custom.ReturnDAO;
import com.Ijse.gdse.Dao.SQLUtil;
import com.Ijse.gdse.Dto.BookDTO;
import com.Ijse.gdse.Dto.ReturnDTO;
import com.Ijse.gdse.Dto.ReturnDetailsDTO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReturnDAOImpl implements ReturnDAO {
    public static String getNextOrderId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.executeQuery("SELECT  returnID FROM returnDetails ORDER BY  returnID DESC LIMIT 1");
        if (resultSet.next()) {
            return generateNextOrderId(resultSet.getString(1));
        }
        return generateNextOrderId(null);
    }

    private static String generateNextOrderId(String currentOrderId) {
        if (currentOrderId != null) {
            String[] ids = currentOrderId.split("R00");
            int id = Integer.parseInt(ids[1]);
            id += 1;

            return "R00" + id;
        }
        return "R001";
    }

    public boolean saveReturnBook(ReturnDTO returnDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("INSERT INTO returnBook VALUES(?,?,?)",returnDTO.getReturnID(),returnDTO.getMemberID(),returnDTO.getReturnDate());

    }

    public static boolean SaveReturnBookDetails(ArrayList<ReturnDetailsDTO> details) throws SQLException, ClassNotFoundException {
        for (ReturnDetailsDTO det : details) {
            boolean isAdd =
                    connection(det.getReturnID(), det.getMemberId(), det.getBookID(), det.getBookName(), det.getReturnDate());
        }
        return true;
    }

    public static boolean connection(String returnId, String memberId, String bookId, String bookName, Date returnDate) throws SQLException, ClassNotFoundException {
       return SQLUtil.executeUpdate("INSERT INTO  returnDetails VALUES (?,?,?,?,?)",returnId,memberId,bookId,bookName,returnDate);

    }

    public static boolean connection2(String bookId, String bookName, String bookTittle, double bookPrice) throws SQLException, ClassNotFoundException {
      return SQLUtil.executeUpdate("INSERT INTO  availablebooks VALUES (?,?,?,?)",bookId,bookName,bookTittle,bookPrice);
    }


    public static BookDTO SaveAvailableBookDetails(ArrayList<String> details2) throws SQLException, ClassNotFoundException {

        for (int i=0;i<details2.size();i++) {
            String bookID=details2.get(i);

            ResultSet resultSet =SQLUtil.executeQuery("SELECT * FROM book WHERE book_id=?",bookID);
            if (resultSet.next()) {
                String bookName = resultSet.getString(2);
                String bookTittle = resultSet.getString(3);
                double bookPrice = resultSet.getDouble(4);
                boolean isADd = connection2(bookID, bookName, bookTittle, bookPrice);

            }
        }
        return null;
    }
}

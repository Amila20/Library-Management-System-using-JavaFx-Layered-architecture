package com.Ijse.gdse.Dao.Custom.Impl;

import com.Ijse.gdse.Dao.Custom.BookDAO;
import com.Ijse.gdse.Dao.SQLUtil;
import com.Ijse.gdse.Dto.BookDTO;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BooksDAOImpl implements BookDAO {

    public boolean save(BookDTO bookDTO) throws SQLException, ClassNotFoundException {
      return   SQLUtil.executeUpdate("Insert into book VALUES(?,?,?,?)",bookDTO.getBookId(),bookDTO.getBookName(),bookDTO.getBookTittle(),bookDTO.getBookPrice());
    }

    public boolean saveAvailable(BookDTO bookDTO) throws SQLException, ClassNotFoundException {
     return   SQLUtil.executeUpdate("INSERT INTO  availablebooks VALUES (?,?,?,?)",bookDTO.getBookId(),bookDTO.getBookName(),bookDTO.getBookTittle(),bookDTO.getBookPrice());
    }

    public  boolean update(String bookId, String bookName, BookDTO bookDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE  book SET book_id=?,book_name=?,book_tittle=?,book_price=? WHERE book_id=? AND book_name=?",bookDTO.getBookId(),bookDTO.getBookName(),bookDTO.getBookTittle(),bookDTO.getBookPrice(),bookId,bookName);
    }

    public  boolean delete(String bookId, String bookName) throws SQLException, ClassNotFoundException {
      return  SQLUtil.executeUpdate("DELETE FROM book WHERE book_id=? AND book_name=?",bookId,bookName);

    }
    public  boolean deleteAvailableBook(String bookId, String bookName) throws SQLException, ClassNotFoundException {
     return SQLUtil.executeUpdate("DELETE FROM availablebooks WHERE bookId=? AND bookName=?",bookId,bookName);

    }

    public  BookDTO search(String bookID) throws SQLException, ClassNotFoundException {
        ResultSet resultSet =SQLUtil.executeQuery("SELECT * FROM book WHERE book_id=?",bookID);

        if (resultSet.next()) {
            String bookName = resultSet.getString(2);
            String bookTittle = resultSet.getString(3);
            double bookPrice = resultSet.getDouble(4);
            return new BookDTO(bookID, bookName, bookTittle, bookPrice);
        }
        return null;
    }
    public List<BookDTO> GetDetails() throws SQLException, ClassNotFoundException {
        ResultSet resultSet=SQLUtil.executeQuery("SELECT * FROM  book");
        List<BookDTO> list=new ArrayList<>();

        while (resultSet.next()){
            String BookId=resultSet.getString(1);
            String BookName=resultSet.getString(2);
            String BookTittle=resultSet.getString(3);
            double BookPrice= resultSet.getDouble(4);
            list.add(new BookDTO(BookId,BookName,BookTittle,BookPrice));
        }
        return list;
    }

    public ArrayList<String> getIds() throws SQLException, ClassNotFoundException {
        ResultSet resultSet= SQLUtil.executeQuery("SELECT bookId FROM availablebooks");
        ArrayList<String> ids=new ArrayList<>();
        while (resultSet.next()){
            ids.add(resultSet.getString(1));
        }
        return ids;
    }

    public  ArrayList<String> getIssuesBookIds() throws SQLException, ClassNotFoundException {
        ResultSet resultSet= SQLUtil.executeQuery("SELECT bookID FROM issuesoderdetails");
        ArrayList<String> ids=new ArrayList<>();
        while (resultSet.next()){
            ids.add(resultSet.getString(1));
        }
        return ids;
    }

    public ObservableList getALlData(ObservableList observableList) throws SQLException, ClassNotFoundException {
       ResultSet resultSet=SQLUtil.executeQuery("SELECT  * FROM  availablebooks");
        while (resultSet.next()){

            observableList.add(new BookDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4)
            ));
        }

        return observableList;
    }

    @Override
    public boolean delete(String publisherId) throws SQLException, ClassNotFoundException {
        return false;
    }

}

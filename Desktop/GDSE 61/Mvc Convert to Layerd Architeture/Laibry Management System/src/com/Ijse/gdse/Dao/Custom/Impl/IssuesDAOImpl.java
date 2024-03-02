package com.Ijse.gdse.Dao.Custom.Impl;

import com.Ijse.gdse.Dao.Custom.IssueDAO;
import com.Ijse.gdse.Dao.SQLUtil;
import com.Ijse.gdse.Dto.IssuesOder;
import com.Ijse.gdse.Dto.IssuesOrderDetails;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IssuesDAOImpl implements IssueDAO {
    public static boolean SaveIssuesBookDetails(ArrayList<IssuesOrderDetails> details) throws SQLException, ClassNotFoundException {
        for (IssuesOrderDetails det : details) {
            boolean isAdd =
                    connection(det.getOrderId(), det.getMemberId(), det.getBookId(), det.getBookName(), det.getIssueDate());
        }
        return true;
    }

    public static boolean DeleteAvailableBookDetails(ArrayList<String> details) throws SQLException, ClassNotFoundException {
        for (String id : details) {
            deleteBook(id);
        }
        return true;
    }

    public boolean saveIssueBook(IssuesOder issuesOder) throws SQLException, ClassNotFoundException {
      return SQLUtil.executeUpdate("INSERT INTO issuebook VALUES(?,?,?)",issuesOder.getOrderId(),issuesOder.getMemberId(),issuesOder.getIssueDate());

    }

    public static String getNextOrderId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.executeQuery("SELECT  orderID FROM issuesoderdetails ORDER BY  orderID DESC LIMIT 1");
        if (resultSet.next()) {
            return generateNextOrderId(resultSet.getString(1));
        }
        return generateNextOrderId(null);
    }

    private static String generateNextOrderId(String currentOrderId) {
        if (currentOrderId != null) {
            String[] ids = currentOrderId.split("D00");
            int id = Integer.parseInt(ids[1]);
            id += 1;

            return "D00" + id;
        }
        return "D001";
    }

    public static boolean connection(String orderId, String memberId, String bookId, String bookName, Date issueDate) throws SQLException, ClassNotFoundException {
       return SQLUtil.executeUpdate("INSERT INTO  issuesoderDetails VALUES (?,?,?,?,?)",orderId,memberId,bookId,bookName,issueDate);

    }

    public static boolean deleteBook(String bookId) throws SQLException, ClassNotFoundException {
       return SQLUtil.executeUpdate("DELETE FROM availablebooks WHERE bookId=?",bookId);

    }

}

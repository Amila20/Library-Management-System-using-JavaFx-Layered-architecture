package com.Ijse.gdse.bo;

import com.Ijse.gdse.Controller.IssuesBooksController;
import com.Ijse.gdse.DB.DBConnection;
import com.Ijse.gdse.Dao.Custom.Impl.IssuesDAOImpl;
import com.Ijse.gdse.Dto.IssuesOder;
import com.Ijse.gdse.Dto.IssuesOrderDetails;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Bo {
    IssuesDAOImpl issuesDAO=new IssuesDAOImpl();
    IssuesBooksController controller=new IssuesBooksController();

    public void issueBook(IssuesOder issuesOder, ArrayList<IssuesOrderDetails>bookDetails, ArrayList<String>details) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            boolean saveIssueBooks = issuesDAO.saveIssueBook(issuesOder);
            if (saveIssueBooks) {
                boolean saveIssueBookDetails = IssuesDAOImpl.SaveIssuesBookDetails(bookDetails);
                IssuesDAOImpl.DeleteAvailableBookDetails(details);
                if (saveIssueBookDetails) {
                    new Alert(Alert.AlertType.CONFIRMATION, "BookS issue Success !").show();
                    controller.Cleartext();
                } else {
                    connection.rollback();
                    new Alert(Alert.AlertType.ERROR, "Something went wrong!").show();
                }
            } else {
                connection.rollback();
                new Alert(Alert.AlertType.ERROR, "Something went wrong!").show();
            }
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            connection.setAutoCommit(true);
        }

    }
}

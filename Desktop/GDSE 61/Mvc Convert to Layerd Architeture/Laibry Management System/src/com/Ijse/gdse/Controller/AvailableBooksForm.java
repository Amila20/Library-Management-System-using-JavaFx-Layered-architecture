package com.Ijse.gdse.Controller;

import com.Ijse.gdse.Dao.Custom.Impl.BooksDAOImpl;
import com.Ijse.gdse.Dao.DAOFactory;
import com.Ijse.gdse.Dto.BookDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class AvailableBooksForm {

    public TableView<BookDTO> tblAvailableBook;
    public TableColumn colBookId;
    public TableColumn colBookName;
    public TableColumn colBookAuthor;
    public TableColumn colbookPrice;

    ObservableList<BookDTO> observableList= FXCollections.observableArrayList();

    BooksDAOImpl booksDAO= (BooksDAOImpl) DAOFactory.getDaoFactory().getDaoTypes(DAOFactory.DAOTypes.BOOK);

    public void initialize() throws SQLException, ClassNotFoundException {
        loadAllData();
        SetValueToTable();

    }

    public void loadAllData() throws SQLException, ClassNotFoundException {
        booksDAO.getALlData(observableList);

        tblAvailableBook.setItems(observableList);

    }

    private void SetValueToTable(){
        colBookId.setCellValueFactory(new PropertyValueFactory<>("BookId"));
        colBookName.setCellValueFactory(new PropertyValueFactory<>("BookName"));
        colBookAuthor.setCellValueFactory(new PropertyValueFactory<>("BookTittle"));
        colbookPrice.setCellValueFactory(new PropertyValueFactory<>("BookPrice"));
        tblAvailableBook.refresh();
        tblAvailableBook.setItems(observableList);
    }

}


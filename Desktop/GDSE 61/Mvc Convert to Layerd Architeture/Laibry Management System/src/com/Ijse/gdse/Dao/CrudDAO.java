package com.Ijse.gdse.Dao;

import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CrudDAO<T,ID> extends SupperDAO{

    boolean save(T dto) throws SQLException, ClassNotFoundException;
    boolean saveAvailable(T dto) throws SQLException, ClassNotFoundException;

     boolean update(ID Id, String name, T dto)throws SQLException, ClassNotFoundException ;

     boolean delete(ID Id, String name) throws SQLException, ClassNotFoundException;

     boolean deleteAvailableBook(ID Id, String name)throws SQLException, ClassNotFoundException;

     T search(ID ID) throws SQLException, ClassNotFoundException;

     List<T> GetDetails() throws SQLException, ClassNotFoundException ;

     ArrayList<String> getIds() throws SQLException, ClassNotFoundException;

     ArrayList<String> getIssuesBookIds() throws SQLException, ClassNotFoundException;
     ObservableList getALlData(ObservableList observableList) throws SQLException, ClassNotFoundException;

     boolean delete(String publisherId) throws SQLException, ClassNotFoundException;
}

package com.Ijse.gdse.Dao.Custom.Impl;

import com.Ijse.gdse.Dao.Custom.PublisherDAO;
import com.Ijse.gdse.Dao.SQLUtil;
import com.Ijse.gdse.Dto.PublisherDTO;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PublisherDAOImpl implements PublisherDAO {
    public boolean save(PublisherDTO publisherDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("INSERT INTO publisher VALUES (?,?,?)", publisherDTO.getPublisherId(), publisherDTO.getPublisherName(), publisherDTO.getPublisherAddress());
    }

    @Override
    public boolean saveAvailable(PublisherDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(String Id, String name, PublisherDTO publisherDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE publisher SET publisherName=?,publisherAddress=? WHERE publisherId=?", publisherDTO.getPublisherName(), publisherDTO.getPublisherAddress(), Id);
    }

    @Override
    public boolean delete(String Id, String name) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteAvailableBook(String Id, String name) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public PublisherDTO search(String ID) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.executeQuery("SELECT  * FROM publisher WHERE publisherId=?", ID);
        if (resultSet.next()) {
            String pubName = resultSet.getString(2);
            String pubAddress = resultSet.getString(3);
            return new PublisherDTO(ID, pubName, pubAddress);
        }
        return null;
    }

    @Override
    public List<PublisherDTO> GetDetails() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.executeQuery("SELECT  * FROM  publisher");
        List<PublisherDTO> list = new ArrayList<>();

        while (resultSet.next()) {
            String publisherId = resultSet.getString(1);
            String publisherName = resultSet.getString(2);
            String publishrAddress = resultSet.getString(3);
            list.add(new PublisherDTO(publisherId, publisherName, publishrAddress));
        }
        return list;
    }

    @Override
    public ArrayList<String> getIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> getIssuesBookIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList getALlData(ObservableList obj) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.executeQuery("SELECT * FROM publisher");
        while (resultSet.next()) {
            obj.add(new PublisherDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            ));
        }
        return obj;
    }

    @Override
    public boolean delete(String publisherId) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM publisher WHERE publisherId=?",publisherId);
    }
}
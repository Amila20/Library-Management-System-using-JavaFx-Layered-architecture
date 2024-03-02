package com.Ijse.gdse.Dao.Custom.Impl;

import com.Ijse.gdse.Dao.Custom.MemberDAO;
import com.Ijse.gdse.Dao.SQLUtil;
import com.Ijse.gdse.Dto.BookDTO;
import com.Ijse.gdse.Dto.MemberDTO;
import javafx.collections.ObservableList;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOImpl implements MemberDAO {
    @Override
    public boolean save(MemberDTO memberDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("INSERT INTO member VALUES (?,?,?,?,?",memberDTO.getMemberId(),memberDTO.getMemberName(),memberDTO.getMemberAddress(),memberDTO.getMemberContact(),memberDTO.getMemberRegistorDate());
    }

    @Override
    public boolean saveAvailable(MemberDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(String memberId, String memberName, MemberDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE member SET memberId=?,memberName=?,memberAddress=?,memberContact=?,memberRegistorDate=? WHERE memberId=? AND memberName=?",dto.getMemberId(),dto.getMemberName(),dto.getMemberAddress(),dto.getMemberContact(),dto.getMemberRegistorDate(),memberId,memberName);
    }




    @Override
    public ArrayList<String> getIssuesBookIds() throws SQLException, ClassNotFoundException {
        return null;
    }




   @Override
    public  boolean delete(String memberId,String memberName) throws SQLException, ClassNotFoundException {
      return   SQLUtil.executeUpdate("DELETE FROM member WHERE memberId=? AND memberName=?",memberId,memberName);
    }
    public boolean deleteAvailableBook(String bookId, String bookName) throws SQLException, ClassNotFoundException {
        return false;
    }


    public MemberDTO search(String memberId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet= SQLUtil.executeQuery("SELECT * FROM member WHERE memberId=?",memberId);
        if (resultSet.next()){
            String memberName= resultSet.getString(2);
            String memberAddress=resultSet.getString(3);
            int memberContact=resultSet.getInt(4);
            Date memberRegisterDate=resultSet.getDate(5);
            return new MemberDTO(memberId,memberName,memberAddress,memberContact,memberRegisterDate);
        }
        return null;
    }




    public List<MemberDTO> GetDetails() throws SQLException, ClassNotFoundException {
        ResultSet resultSet=SQLUtil.executeQuery("SELECT  * FROM member");
        List<MemberDTO> list=new ArrayList<>();

        while (resultSet.next()){
            String memberId=resultSet.getString(1);
            String memberName=resultSet.getString(2);
            String memberAddress=resultSet.getString(3);
            int memberContact=resultSet.getInt(4);
            Date registerDate=resultSet.getDate(5);
            list.add(new MemberDTO(memberId,memberName,memberAddress,memberContact,registerDate));
        }
        return list;


    }
    public  ArrayList<String> getIds() throws SQLException, ClassNotFoundException {
        ResultSet resultSet= SQLUtil.executeQuery("SELECT  memberId FROM member");
        ArrayList<String> ids=new ArrayList<>();

        while (resultSet.next()){
            ids.add(resultSet.getString(1));
        }
        return ids;
    }

    public static ArrayList<String> getIssuesMembersId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet= SQLUtil.executeQuery("SELECT  memberID FROM issuesoderdetails");
        ArrayList<String> ids=new ArrayList<>();
        while (resultSet.next()){
            ids.add(resultSet.getString(1));
        }
        return ids;

    }
    public ObservableList getALlData(ObservableList observableList) throws SQLException, ClassNotFoundException {
       ResultSet resultSet=SQLUtil.executeQuery("SELECT * FROM  membe");
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



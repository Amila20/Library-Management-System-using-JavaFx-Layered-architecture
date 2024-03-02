package com.Ijse.gdse.Dao;

import com.Ijse.gdse.Dao.Custom.Impl.*;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getDaoFactory(){
        if (daoFactory==null){
            daoFactory=new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOTypes{
        BOOK,MEMBER,PUBLISHER,ISSUES,RETURN
    }
    public SupperDAO getDaoTypes(DAOTypes types){
        switch (types){
            case BOOK:
                return new BooksDAOImpl();
            case MEMBER:
                return new MemberDAOImpl();
            case PUBLISHER:
                return new PublisherDAOImpl();
            case ISSUES:
                return new IssuesDAOImpl();
            case RETURN:
                return  new ReturnDAOImpl();
            default:
                return null;
        }

    }

}

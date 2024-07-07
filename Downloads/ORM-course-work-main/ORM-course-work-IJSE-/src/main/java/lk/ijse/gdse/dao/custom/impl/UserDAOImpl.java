package lk.ijse.gdse.dao.custom.impl;


import lk.ijse.gdse.entity.User;
import lk.ijse.gdse.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAOImpl {

    public boolean save(User user)throws Exception{
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(user);

        transaction.commit();
        session.close();
        return true;


    }

    public User search(String userName)throws Exception{
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        User user = session.get(User.class, userName);

        transaction.commit();
        session.close();

        return user;
    }

}

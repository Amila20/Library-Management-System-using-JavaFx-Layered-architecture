package lk.ijse.gdse.dao.custom.impl;

import lk.ijse.gdse.entity.Rooms;
import lk.ijse.gdse.entity.Student;
import lk.ijse.gdse.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class RoomsDAOImpl {
    public boolean save(Rooms rooms)throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(rooms);

        transaction.commit();
        session.close();
        return true;

    }

    public List<Rooms> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "from Rooms";
        Query query = session.createQuery(hql);
        List <Rooms> roomList = query.list();

        transaction.commit();
        session.close();
        return roomList;
    }
    public List<Rooms> getRoomIds(){
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();

        List<Rooms> roomsIdList = (List<Rooms>) session.createQuery("SELECT room_type_id from Rooms");
        transaction.commit();
        session.close();
        return roomsIdList;

    }
}

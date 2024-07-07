package lk.ijse.gdse.dao.custom.impl;

import lk.ijse.gdse.entity.Student;
import lk.ijse.gdse.entity.User;
import lk.ijse.gdse.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAOImpl {
    public boolean save(Student student)throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(student);

        transaction.commit();
        session.close();
        return true;

    }


    public Student search(String phoneNumber) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class, phoneNumber);

        transaction.commit();
        session.close();
        return student;
    }

    public boolean update(Student student)throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(student);

        transaction.commit();
        session.close();
        return true;
    }

    public boolean delete(String id)throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class, id);
        session.delete(student);

        transaction.commit();
        session.close();
        return true;
    }

    public List<Student> getAll()throws Exception{

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "from Student";
        Query query = session.createQuery(hql);
        List <Student> studentList = query.list();

        transaction.commit();
        session.close();
        return studentList;

    }
}

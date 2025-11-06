package com.tca;

import com.tca.entitis.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration=null;
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction=null;
        try
        {
            configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();

            session = sessionFactory.openSession();

            transaction = session.beginTransaction();


            Student ob = new Student();
            ob.setPer(23.54);
            ob.setName("sss");

            int rno= (int)session.save(ob);

            Student o = (Student) session.get(Student.class,rno);
            System.out.println(o.getName());
            System.out.println(o.getRno());
            System.out.println(o.getPer());


            transaction.commit();
            System.out.println("Saved record Successfully for RNO"+rno);

        }
        catch (Exception e)
        {
            transaction.rollback();
            System.out.println(e.getMessage());
        }
        finally
        {
            session.close();
            sessionFactory.close();
        }


    }
}

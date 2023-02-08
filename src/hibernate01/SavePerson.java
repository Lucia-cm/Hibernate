package hibernate01;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SavePerson {

    public static void main(String[] args) {

        SessionFactory myFactory=new Configuration()
                .configure("hibernate_persona.cfg.xml")
                .addAnnotatedClass(Persona.class)
                .buildSessionFactory();
        Session mySession=myFactory.openSession();
        try{
            Persona person=new Persona("Lucía", "1998-04-29",155.5,50.0);
            mySession.beginTransaction();
            mySession.save(person);
            mySession.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            myFactory.close();
        }
    }


}

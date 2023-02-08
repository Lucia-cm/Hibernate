package hibernate.hibernate02;

import hibernate.pruebas_hibernate.Clientes;
import jdk.swing.interop.SwingInterOpUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Options {
    private SessionFactory myFactory;
    private Session mySession;

    //crear factory y session
    public void create_factory_session(){
        myFactory=new Configuration()
                .configure("hibernate_persona.cfg.xml")
                .addAnnotatedClass(Persona.class)
                .buildSessionFactory();

        mySession=myFactory.openSession();
    }

    //Select
    public void option_select(){
        create_factory_session();
        try{
            //comenzar sesión
            mySession.beginTransaction();

            List<Persona> persons=mySession.createQuery("from Persona").getResultList();
            //mostrar las personas
            AdditionalMethods.showPersons(persons);

            //commit
            mySession.getTransaction().commit();
            //cerrar sesion
            mySession.close();

        }finally{
            myFactory.close();
        }
    }

    //Insert
    public void option_insert(){
        create_factory_session();
        try{
            Persona person=new Persona();
            mySession.beginTransaction();
            mySession.save(person);

            mySession.getTransaction().commit();
            mySession.close();

            System.out.println("Persona INSERTADA");

        }finally {
            myFactory.close();
        }
    }

    //Update
    public void option_update(){
        create_factory_session();
        try{
            int personId=1;
            mySession.beginTransaction();

            Persona person=mySession.get(Persona.class,personId);
            person.setNombre("Pepe");

            //commit
            mySession.getTransaction().commit();
            //cerrar sesion
            mySession.close();

            System.out.println("Persona ACTUALIZADA");

        }finally {
            myFactory.close();
        }
    }

    //Delete
    public void option_delete(){
        create_factory_session();
        try{
            mySession.beginTransaction();

            mySession.createQuery("delete Persona where id=1").executeUpdate();

            //commit
            mySession.getTransaction().commit();
            //cerrar sesion
            mySession.close();

            System.out.println("Persona ELIMINADA");

        }finally {
            myFactory.close();
        }
    }



}

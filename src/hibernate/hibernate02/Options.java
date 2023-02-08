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
            System.out.println("PERSONAS ENCONTRADAS");
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
            Persona person=AdditionalMethods.createPerson();
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
        option_select();
        int idperson=AdditionalMethods.selectIdPerson("actualizar");
        Double newPeso=AdditionalMethods.selectColumnUpdate("peso");

        create_factory_session();
        try{
            mySession.beginTransaction();

            Persona person=mySession.get(Persona.class,idperson);
            person.setPeso(newPeso);

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
        option_select();
        int idperson=AdditionalMethods.selectIdPerson("eliminar");

        create_factory_session();

        try{
            mySession.beginTransaction();

            mySession.createQuery("delete Persona where id="+idperson).executeUpdate();

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

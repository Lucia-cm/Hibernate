package hibernate.pruebas_hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ActualizaClientes02 {
    public static void main(String[] args) {

        SessionFactory myFactory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Clientes.class)
                .buildSessionFactory();

        Session mySession=myFactory.openSession();

        try{
            mySession.beginTransaction();

            mySession.createQuery("UPDATE Clientes SET apellidos='Dominguez' WHERE apellidos LIKE 'D%'").executeUpdate();

            //commit
            mySession.getTransaction().commit();
            //cerrar sesion
            mySession.close();

            System.out.println("Apellidos actualizados");

        }finally{
            myFactory.close();
        }
    }

}

package hibernate.pruebas_hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ActualizaClientes {
    public static void main(String[] args) {

        SessionFactory myFactory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Clientes.class)
                .buildSessionFactory();

        Session mySession=myFactory.openSession();

        try{
            int clienteId=1;
            mySession.beginTransaction();

            Clientes cliente=mySession.get(Clientes.class,clienteId);
            cliente.setNombre("Juan");

            //commit
            mySession.getTransaction().commit();
            //cerrar sesion
            mySession.close();

            System.out.println("Registro actualizado");

        }finally{
            myFactory.close();
        }
    }

}

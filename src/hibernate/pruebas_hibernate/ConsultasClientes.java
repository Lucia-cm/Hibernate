package hibernate.pruebas_hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ConsultasClientes {
    public static void main(String[] args) {

        SessionFactory myFactory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Clientes.class)
                .buildSessionFactory();

        Session mySession=myFactory.openSession();

        try{
            //comenzar sesión
            mySession.beginTransaction();

            //consulta de clientes
            System.out.println("Consulta 1");
            List<Clientes> clientes=mySession.createQuery("from Clientes").getResultList();
            //mostrar los clientes
            showClientes(clientes);

            //consulta: dame los Muñoz
            System.out.println("Consulta 2");
            clientes=mySession.createQuery("from Clientes cl where cl.apellidos='Muñoz'").getResultList();
            //mostrar los clientes
            showClientes(clientes);


            //muestra los que viven en Gran Via o se apellidan Delgado
            System.out.println("Consulta 3");
            clientes=mySession.createQuery("from Clientes cl where cl.apellidos='Delgado' or cl.direccion='Gran Vía'").getResultList();
            //mostrar los clientes
            showClientes(clientes);

            //commit
            mySession.getTransaction().commit();
            //cerrar sesion
            mySession.close();

        }finally{
            myFactory.close();
        }
    }

    private static void showClientes(List<Clientes> clientes) {
        for(Clientes cl: clientes){
            System.out.println(cl);
        }
    }
}

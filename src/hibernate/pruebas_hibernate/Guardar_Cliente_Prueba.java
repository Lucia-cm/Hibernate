/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernate.pruebas_hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author IFC302
 */
public class Guardar_Cliente_Prueba {
    public static void main(String[] args) {
        
        SessionFactory myFactory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Clientes.class)
                .buildSessionFactory();
        Session miSesion=myFactory.openSession();
        try{
            Clientes cl=new Clientes("Pedro","Pajaro","Calle A");

            miSesion.beginTransaction();
            miSesion.save(cl);

            miSesion.getTransaction().commit();
            miSesion.close();

            System.out.println("Registro insertado");
        }finally{
            myFactory.close();
        }
    }
}

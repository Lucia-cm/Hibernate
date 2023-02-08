/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernate.pruebas_hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author IFC302
 */
public class PruebasJDBC {
    public static void main(String[] args) {
        
        String jdbcUrl="jdbc:mysql://localhost:3306/pruebas_hibernate?useSSL=false";        
        String user="root";
        String password="";
        
        try{
            System.out.println("Intentando conectar "+jdbcUrl);
            Connection connection=DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Conexion correcta");
            connection.close();
            System.out.println("\nConnexion cerrada");
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}

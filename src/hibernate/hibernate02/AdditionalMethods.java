package hibernate.hibernate02;

import hibernate.pruebas_hibernate.Clientes;

import java.util.List;
import java.util.Scanner;

public class AdditionalMethods {
    static Scanner sc=new Scanner(System.in);
    static void showPersons(List<Persona> persons) {
        for(Persona person: persons)
            System.out.println(person);
    }
    static Persona createPerson(){
        System.out.println("Indica el nombre:");
        String name= sc.nextLine();
        System.out.println("Indica la fecha de nacimiento:");
        String f_nac= sc.nextLine();


        return new Persona();
    }

}

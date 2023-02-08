package hibernate.hibernate02;

import hibernate.pruebas_hibernate.Clientes;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AdditionalMethods {
    static Scanner sc=new Scanner(System.in);

    //COMPROBAR QUE UN INT ES VÁLIDO
    public static int readInteger(){
        int value=0;
        boolean valid=true;

        while(valid)
            try{
                value=sc.nextInt();
                sc.nextLine();
                valid=false;
            } catch(InputMismatchException e){
                sc.nextLine();
                System.out.println("Esa opción no es válida (entero), introduzca otra:");
            }
        return value;
    }
    public static int checkPossitiveNumber(){
        int number=readInteger();
        while(number<0){
            System.out.println("El número introducido es negativo.\nIntroduzca un número positivo:");
            number=readInteger();
        }
        if(number>0)
            number=number;
        return number;
    }



    static void showPersons(List<Persona> persons) {
        for(Persona person: persons)
            System.out.println(person);
    }
    static Persona createPerson(){
        System.out.println("Indica su nombre:");
        String name= sc.nextLine();
        System.out.println("Indica su fecha de nacimiento con el formato AAAA-MM-DD:");
        String f_nac= sc.nextLine();
        System.out.println("Indica su altura:");
        Double altura=sc.nextDouble();
        System.out.println("Indica su peso:");
        Double peso=sc.nextDouble();

        return new Persona(name,f_nac,altura,peso);
    }

    static int selectIdPerson(String option){
        System.out.println("Indique el id de la persona que desea "+option.toLowerCase());
        int id=readInteger();

        return id;
    }
    static Double selectColumnUpdate(String column){
        System.out.println("Indique el nuevo "+column.toLowerCase());
        Double newValue=sc.nextDouble();

        return newValue;
    }

    //MENÚ DE OPCIONES
    public static void show_menu(){
        System.out.println("\nIndique la opción que desea realizar:");
        System.out.println("\t1. Mostrar los registros." +
                "\n\t2. Insertar un registro." +
                "\n\t3. Modificar un registro."+
                "\n\t4. Eliminar un registro." +
                "\n\t5. Salir." );
        int option=checkPossitiveNumber();

        while(option>5){
            System.out.println("La opción indicada NO es válida.\n");
            show_menu();
        }

        Options options=new Options();

        switch (option){
            case 1:
                options.option_select();
                show_menu();
            case 2:
                options.option_insert();
                show_menu();
            case 3:
                options.option_update();
                show_menu();
            case 4:
                options.option_delete();
                show_menu();
            case 5:
                System.out.println("\n¡HASTA PRONTO!\nFIN DEL PROGRAMA");
                System.exit(0);

        }
    }


}

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Metodos {

    public static int menuPrincipal(Scanner sc){

        System.out.println("""
                ------------------------------[MENU PRINCIPAL]------------------------------
                [1] - Clientes con saldo cero.
                [2] - Clientes con credito.
                [3] - Clientes con debito.
                [4] - Ver clientes VIPS.
                [5] - Ver clientes ROBINSONES.
                [6] - Salir.
                ----------------------------------------------------------------------------
                """);

        return sc.nextInt();
    }

    public static List<Cliente> leerFicheroYObtenerClientesSinDireccion(){

        List<Cliente> listaClientesSinDireccion = new ArrayList<>();
        BufferedReader br = null;
        Scanner sc = null;
        String linea = "";
        int numClie = 0,saldo = 0,ingresoMedio = 0,gastoMedio = 0;
        String nombre = "",apellido = "",apellido2 = "";

        try{
            br = new BufferedReader(new FileReader("Gente.txt"));
            linea = br.readLine(); // Leemos la primera linea del fichero

            while(linea != null){

                sc = new Scanner(linea); // Aqui introducimos en el scanner la linea que hemos leido del fichero.

                // En estos condicionales vamos comprobando si lo que hay en la linea se trata de un entero o string, para asignarlo a una variable.
                if(sc.hasNext()){
                    numClie = sc.nextInt();
                }
                if(sc.hasNext()){
                    nombre = sc.next();
                }
                if(sc.hasNext()){
                    apellido = sc.next();
                }
                if(sc.hasNext()){
                    apellido2 = sc.next();
                }
                if(sc.hasNextInt()){
                    saldo  = sc.nextInt();
                }
                if(sc.hasNextInt()){
                    ingresoMedio = sc.nextInt();
                }
                if(sc.hasNextInt()){
                    gastoMedio = sc.nextInt();
                }

                // Despues de leer la linea y obtener las variables con los datos correspondientes, añadimos a la lista al cliente con las variables obtenidas.
                listaClientesSinDireccion.add(new Cliente(numClie,nombre,apellido,apellido2,saldo,ingresoMedio,gastoMedio));
                linea = br.readLine(); // Volvemos a leer la siguiente linea para que el bucle no sea infinito.
            }
        }catch (FileNotFoundException e) {
            System.out.println("Fichero Gente.txt no encontrado.");
        }catch (IOException e) {
            System.out.println("Error al leer el fichero Gente.txt");
        }finally{
            try{
                br.close();
            }catch (IOException e) {
                System.out.println("Error al cerrar el fichero Gente.txt");
            }
        }

        return listaClientesSinDireccion; // Devolvemos la lista de clientes sin la direccion y codigo postal.
    }

    public static List<ClienteDireccion> leerFicheroYObtenerClientesConDireccion(){

        List<ClienteDireccion> listaClientesDireccion = new ArrayList<>();
        BufferedReader br = null;
        Scanner sc = null;
        String linea = "";
        int numClie = 0,saldo = 0,ingresoMedio = 0,gastoMedio = 0, codPostal = 0;
        String nombre = "",apellido = "",apellido2 = "", direccion = "";

        try{
            br = new BufferedReader(new FileReader("Gente.txt"));
            linea = br.readLine(); // Leemos la primera linea del fichero

            while(linea != null){

                sc = new Scanner(linea); // Aqui introducimos en el scanner la linea que hemos leido del fichero.

                // En estos condicionales vamos comprobando si lo que hay en la linea se trata de un entero o string, para asignarlo a una variable.
                if(sc.hasNext()){
                    numClie = sc.nextInt();
                }
                if(sc.hasNext()){
                    nombre = sc.next();
                }
                if(sc.hasNext()){
                    apellido = sc.next();
                }
                if(sc.hasNext()){
                    apellido2 = sc.next();
                }
                if(sc.hasNextInt()){
                    saldo  = sc.nextInt();
                }
                if(sc.hasNextInt()){
                    ingresoMedio = sc.nextInt();
                }
                if(sc.hasNextInt()){
                    gastoMedio = sc.nextInt();
                }
                if(sc.hasNext()){
                    direccion = sc.next();
                }
                if(sc.hasNextInt()){
                    codPostal = sc.nextInt();
                }

                // Despues de leer la linea y obtener las variables con los datos correspondientes, añadimos a la lista al cliente con las variables obtenidas.
                listaClientesDireccion.add(new ClienteDireccion(numClie,nombre,apellido,apellido2,saldo,ingresoMedio,gastoMedio,direccion,codPostal));
                linea = br.readLine(); // Volvemos a leer la siguiente linea para que el bucle no sea infinito.
            }
        }catch (FileNotFoundException e) {
            System.out.println("Fichero Gente.txt no encontrado.");
        }catch (IOException e) {
            System.out.println("Error al leer el fichero Gente.txt");
        }finally{
            try{
                br.close();
            }catch (IOException e) {
                System.out.println("Error al cerrar el fichero Gente.txt");
            }
        }

        return listaClientesDireccion; // Devolvemos la lista de clientes con direccion.
    }

    public static void añadirClientesSinDireccionAlFichero(List<Cliente> lista){

        ObjectOutputStream oos = null;

        try{

            oos = new ObjectOutputStream(new FileOutputStream("ClientesSin.dat"));

            for (int i = 0; i < lista.size(); i++) {
                oos.writeObject(lista.get(i));
            }

        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero ClientesSin.dat");
        }finally {
            try{
                oos.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el fichero ClientesSin.dat");
            }
        }
    }

    public static void añadirClientesConDireccionAlFichero(List<ClienteDireccion> lista){

        ObjectOutputStream oos = null;

        try{

            oos = new ObjectOutputStream(new FileOutputStream("ClientesCon.dat"));

            for (int i = 0; i < lista.size(); i++) {
                oos.writeObject(lista.get(i));
            }

        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero ClientesCon.dat");
        }finally {
            try{
                oos.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el fichero ClientesCon.dat");
            }
        }
    }

    public static void añadirClientesAlFicheroSaldo0(List<Cliente> lista){

        ObjectOutputStream oos = null;

        try{

            oos = new ObjectOutputStream(new FileOutputStream("ClientesCero.dat"));

            for (int i = 0; i < lista.size(); i++) {
                if(lista.get(i).getGastosMedios()-lista.get(i).getIngresosMedios() == 0){
                    oos.writeObject(lista.get(i));
                }
            }

        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero ClientesCero.dat");
        }finally {
            try{
                oos.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el fichero ClientesCero.dat");
            }
        }
    }

    public static void añadirClientesAlFicheroSaldoCredito(List<Cliente> lista){

        ObjectOutputStream oos = null;

        try{

            oos = new ObjectOutputStream(new FileOutputStream("ClientesCredito.dat"));

            for (int i = 0; i < lista.size(); i++) {
                if(lista.get(i).getSaldo() > 0){
                    oos.writeObject(lista.get(i));
                }
            }

        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero ClientesCredito.dat");
        }finally {
            try{
                oos.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el fichero ClientesCredito.dat");
            }
        }
    }

    public static void añadirClientesAlFicheroSaldoDebito(List<Cliente> lista){

        ObjectOutputStream oos = null;

        try{

            oos = new ObjectOutputStream(new FileOutputStream("ClientesDebito.dat"));

            for (int i = 0; i < lista.size(); i++) {
                if(lista.get(i).getSaldo() < 0){
                    oos.writeObject(lista.get(i));
                }
            }

        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero ClientesDebito.dat");
        }finally {
            try{
                oos.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el fichero ClientesDebito.dat");
            }
        }
    }

    public static void añadirClientesAlFicheroVips(List<ClienteDireccion> lista){

        ObjectOutputStream oos = null;

        try{

            oos = new ObjectOutputStream(new FileOutputStream("ClientesVips.dat"));

            for (int i = 0; i < lista.size(); i++) {
                if(lista.get(i).getSaldo() > 0 && lista.get(i).getIngresosMedios() > 3000){
                    oos.writeObject(lista.get(i));
                }
            }

        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero ClientesVips.dat");
        }finally {
            try{
                oos.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el fichero ClientesVips.dat");
            }
        }
    }

    public static void añadirClientesAlFicheroRobinson(List<ClienteDireccion> lista){

        ObjectOutputStream oos = null;

        try{

            oos = new ObjectOutputStream(new FileOutputStream("ClientesRobinsones.dat"));

            for (int i = 0; i < lista.size(); i++) {
                if(lista.get(i).getSaldo() < 0 && lista.get(i).getGastosMedios() > 3000){
                    oos.writeObject(lista.get(i));
                }
            }

        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero ClientesRobinsones.dat");
        }finally {
            try{
                oos.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el fichero ClientesRobinsones.dat");
            }
        }
    }

    public static void leerEImprimirFicheroClientes(String fichero){

        ObjectInputStream ois = null;

        try{

            ois = new ObjectInputStream(new FileInputStream(fichero));
            Object aux = ois.readObject();

            while(aux != null){
                if(aux != null){
                    System.out.println(aux);
                    aux = ois.readObject();
                }
            }
        }catch (FileNotFoundException e) {
            System.out.println("Fichero " + fichero + " no encontrado.");
        }catch (EOFException eof){
            System.out.println("Fin de fichero.");
        }catch (IOException e){
            System.out.println(e);
        } catch (ClassNotFoundException e){
            System.out.println("Clase no encontrada.");
        }finally{
            try{
                ois.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el fichero " + fichero);
            }
        }
    
    }


}

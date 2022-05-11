import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Cliente> clientesSin = Metodos.leerFicheroYObtenerClientesSinDireccion();
        List<ClienteDireccion> clientesCon = Metodos.leerFicheroYObtenerClientesConDireccion();
        boolean salir = false;

        do{
            try{
                switch (Metodos.menuPrincipal(new Scanner(System.in))){
                    case 1 -> Metodos.leerEImprimirFicheroClientes("ClientesCero.dat");
                    case 2 -> Metodos.leerEImprimirFicheroClientes("ClientesCredito.dat");
                    case 3 -> Metodos.leerEImprimirFicheroClientes("ClientesDebito.dat");
                    case 4 -> Metodos.leerEImprimirFicheroClientes("ClientesVips.dat");
                    case 5 -> Metodos.leerEImprimirFicheroClientes("ClientesRobinsones.dat");
                    case 6 -> salir = true;
                    default -> System.out.println("Esa opcion no existe.");
                }
            }catch (InputMismatchException e){
                System.out.println("ERROR. INTRODUCE UN NUMERO");
            }catch (NullPointerException npe){
                System.out.println("El fichero esta en nulo.");
            }
        }while(!salir);


    }
}

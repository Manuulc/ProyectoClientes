public class ClienteDireccion extends Cliente{

    private String direccion;
    private int codPostal;

    public ClienteDireccion(int numeroCliente, String nombre, String apellido1, String apellido2, int saldo, int ingresosMedios, int gastosMedios, String direccion, int codPostal) {
        super(numeroCliente, nombre, apellido1, apellido2, saldo, ingresosMedios, gastosMedios);
        this.direccion = direccion;
        this.codPostal = codPostal;
    }

    public ClienteDireccion(String direccion, int codPostal) {
        super();
        this.direccion = "";
        this.codPostal = 0;
    }

    @Override
    public String toString() {
        return super.toString() + " | " + "Direccion:" + direccion + " | " + "CP:" + codPostal;
    }
}

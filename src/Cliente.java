import java.io.Serializable;

public class Cliente implements Serializable{

    private int numeroCliente;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int saldo;
    private int ingresosMedios;
    private int gastosMedios;

    public Cliente(int numeroCliente, String nombre, String apellido1, String apellido2, int saldo, int ingresosMedios, int gastosMedios) {
        this.numeroCliente = numeroCliente;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.saldo = saldo;
        this.ingresosMedios = ingresosMedios;
        this.gastosMedios = gastosMedios;
    }

    public Cliente(){
        this.numeroCliente = 0;
        this.nombre = "";
        this.apellido1 = "";
        this.apellido2 = "";
        this.saldo = 0;
        this.ingresosMedios = 0;
        this.gastosMedios = 0;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getIngresosMedios() {
        return ingresosMedios;
    }

    public void setIngresosMedios(int ingresosMedios) {
        this.ingresosMedios = ingresosMedios;
    }

    public int getGastosMedios() {
        return gastosMedios;
    }

    public void setGastosMedios(int gastosMedios) {
        this.gastosMedios = gastosMedios;
    }


    @Override
    public String toString() {
        return "Numero de cliente:" + numeroCliente + " | " + "Nombre:" + nombre + " | " + "Apellidos:" + apellido1 + " " + apellido2 +  " | " + "Saldo:" + saldo
                + " | " + "Ingreso medio:" + ingresosMedios + " | " + "Gasto medio:" + gastosMedios;
    }

}

package Modelo;

public class Empleado {
    private int id;
    private String nombres;
    private String apellidos;
    private String fechaIngreso;
    private double sueldo;

    //Constructor vacio
    public Empleado() {
    }

    //Constructor de inicializacion
    public Empleado(int id, String nombres, String apellidos, String fechaIngreso, double sueldo) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaIngreso = fechaIngreso;
        this.sueldo = sueldo;
    }

    public int getId(){
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}

import java.time.LocalDate;

public class Paciente {
    private String nombre;
    private String numeroIdentificacion;
    private LocalDate fechaNacimiento;
    private String direccion;
    private String correo;
    private boolean genero;

    public Paciente(String nombre, String numeroIdentificacion, LocalDate fechaNacimiento, String direccion, String correo, boolean genero) {
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.correo = correo;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        String generoTexto = genero ? "Femenino" : "Masculino";
        return "Nombre: " + nombre + "\n" +
                "Número de Identificación: " + numeroIdentificacion + "\n" +
                "Fecha de Nacimiento: " + fechaNacimiento + "\n" +
                "Dirección: " + direccion + "\n" +
                "Correo: " + correo + "\n" +
                "Género: " + generoTexto +"\n";
    }
}

package dao;

public class PersonaDAO {

    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private int telefono;

    public PersonaDAO() {
    }

    public PersonaDAO(int id) {
        this.id = id;
    }

    public PersonaDAO(String nombre, String apellido, String email, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    public PersonaDAO(int id, String nombre, String apellido, String email, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getTelefono() {
        return this.telefono;
    }

    @Override
    public String toString() {
        return "ID: [" + this.id + "] \n"
                + "Nombre: [" + this.nombre + "] \n"
                + "Apellido: [" + this.apellido + "] \n"
                + "Email: [" + this.email + "] \n"
                + "Telefono: [" + this.telefono + "] \n"
                + "\n";
    }
}

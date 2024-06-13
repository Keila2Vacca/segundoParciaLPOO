package inquilino;

import java.util.ArrayList;
import java.util.List;

public class Inquilino {

    private String nombre;
    private String apellido;
    private String id;
    private List<String> movimientos; 

    public Inquilino(String nombre, String apellido, String id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.movimientos = new ArrayList<>();
    }

    public void agregarMovimiento(String movimiento) {
        movimientos.add(movimiento);
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getId() {
        return id;
    }

    public List<String> getMovimientos() {
        return movimientos;
    }

    public boolean estaAlDia() {
        return !movimientos.contains("No Pagó");
    }
}

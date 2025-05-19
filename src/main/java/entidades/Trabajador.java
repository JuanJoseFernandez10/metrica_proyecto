/**
 * Clase Trabajador heredada de Usuario
 */
package entidades;

/**
 *
 * @author juanj
 */
public class Trabajador extends Usuario{
    /**
     * Constructor de la clase
     * @param usuario
     * @param nombre 
     */
    public Trabajador(String usuario, String nombre) {
        super(usuario, nombre);
    }

    /**
     * Metodo toString 
     * @return 
     */
    @Override
    public String toString() {
        return getNombre() + ", usuario: " + getUsuario();
    }
    
}

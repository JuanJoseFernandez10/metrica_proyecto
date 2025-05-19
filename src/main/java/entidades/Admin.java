/**
 * Clase admin heredada de Usuario
 */
package entidades;

/**
 *
 * @author juanj
 */
public class Admin extends Usuario{
    /**
     * Constructor de la clase
     * @param usuario
     * @param nombre 
     */
    public Admin(String usuario, String nombre) {
        super(usuario, nombre);
    }
    /**
     * Metodo toString del Admin
     * @return 
     */
    @Override
    public String toString() {
        return "Admin: " + getNombre();
    }
    
    
}

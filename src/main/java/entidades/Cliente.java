/**
 * Clase Cliente heredada de Usuario
 */
package entidades;

/**
 *
 * @author juanj
 */
public class Cliente extends Usuario{
    
    /**
     * Constructor de la clase
     * @param usuario
     * @param nombre 
     */
    public Cliente(String usuario, String nombre ) {
        super(usuario, nombre);
    }
    /**
     * Metodo toString que imprime el Cliente
     * @return 
     */
    @Override
    public String toString() {
        return getNombre() + ", usuario: " + getUsuario();
    }
    
    
}

/**
 * Clase de excecion personalizada para los tratos
 */
package Exceptions;

/**
 *
 * @author juanj
 */
public class TratoNoAceptadoException extends RuntimeException {
    /**
     * Constructor de la Excepcion
     * @param mensaje 
     */
    public TratoNoAceptadoException(String mensaje) {
        super(mensaje);
    }
}


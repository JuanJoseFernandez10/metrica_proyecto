/**
 * Clase Abstracta Usuario
 */
package entidades;

/**
 *
 * @author juanj
 */
public abstract class Usuario {
    
    private String usuario;
    private String nombre;
    /**
     * Contructor de la clase abstracta
     * @param usuario
     * @param nombre 
     */
    public Usuario(String usuario, String nombre){
        this.usuario = usuario;
        this.nombre = nombre;
    }
    /**
     * Getter de usuario
     * @return nombre del usuario
     */
    public String getUsuario() {
        return usuario;
    }
    /**
     * Setter de usuario
     * @param usuario 
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    /**
     * Getter de nombre
     * @return nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Setter de nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Metodo abstracto de toString para asegurar sun implementacion
     * @return 
     */
    @Override
    public abstract String toString();
}

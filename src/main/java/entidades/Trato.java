/**
 * Clase Trato
 */
package entidades;

import Exceptions.TratoNoAceptadoException;
import entidadesDAO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author juanj
 */
public class Trato {
    
    private Tipo_Trato tipo;
    private Cliente c1;
    private Trabajador t1;
    private Mascota m1;
    private String texto_client;
    
    /**
     * Clase enum utilizada para tipos de trato en el Trato
     */
    public enum Tipo_Trato {
        ADOPTAR("adoptar"),
        CEDER("ceder");

        private final String nombre;

        Tipo_Trato(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }
    }
    /**
     * Constructor de la clase
     * @param tipo
     * @param c1
     * @param t1
     * @param m1
     * @param texto_client 
     */
    public Trato(Tipo_Trato tipo, Cliente c1, Trabajador t1, Mascota m1, String texto_client) {
        this.tipo = tipo;
        this.c1 = c1;
        this.t1 = t1;
        this.m1 = m1;
        this.texto_client = texto_client;
    }
    /**
     * Getter del tipo de trato
     * @return 
     */
    public Tipo_Trato getTipo() {
        return tipo;
    }
    /**
     * Getter del Cliente del trato
     * @return 
     */
    public Cliente getC1() {
        return c1;
    }
    /**
     * Getter del Trabajador del trato
     * @return 
     */
    public Trabajador getT1() {
        return t1;
    }
    /**
     * Getter de la Mascota del trato
     * @return 
     */
    public Mascota getM1() {
        return m1;
    }
    /**
     * Getter del texto del cliente
     * @return 
     */
    public String getTexto_client() {
        return texto_client;
    }
      
}

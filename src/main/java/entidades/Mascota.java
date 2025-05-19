/**
 * Clase Mascota
 */
package entidades;

/**
 *
 * @author juanj
 */
public class Mascota {
    private String microchip;
    private Especie especie;
    private String raza;
    private String nombre;
    private int num_vacs;
    /**
     * Clase Enum para saber el tipo de Especie de la Mascota
     */
    public enum Especie {
        PERRO("Perro"),
        GATO("Gato"),
        AVE("Ave");

        private final String nombre;

        Especie(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }
    }
    /**
     * Contructor de la clase 
     * @param microchip
     * @param especie
     * @param raza
     * @param nombre
     * @param num_vacs 
     */
    public Mascota(String microchip, Especie especie, String raza, String nombre, int num_vacs){
        this.microchip = microchip;
        this.especie = especie;
        this.raza = raza;
        this.nombre = nombre;
        this.num_vacs = num_vacs;
    }
    /**
     * Metodo que crea un informe
     * @return 
     */
    public String crear_informe(){
        String res = "El " + especie.getNombre() + ", llamado " + nombre + "\n"
                + ", de raza: " + raza + " , tiene "  + num_vacs + " numero de vaucnas puestas en total";
        return res;
    }
    /**
     * Getter del microchip 
     * @return 
     */
    public String getMicrochip() {
        return microchip;
    }
    /**
     * Getter de la Especie
     * @return 
     */
    public Especie getEspecie() {
        return especie;
    }
    /**
     * Getter de la raza
     * @return 
     */
    public String getRaza() {
        return raza;
    }
    /**
     * Getter del nombre
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Getter del numero de vacunas
     * @return 
     */
    public int getNum_vacs() {
        return num_vacs;
    }
    /**
     * Setter del nombre por si se le cambia
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Setter del numero de vacunas
     * @param num_vacs 
     */
    public void setNum_vacs(int num_vacs) {
        this.num_vacs = num_vacs;
    }
    
    
    
}


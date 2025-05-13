/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
    
    public Mascota(String microchip, Especie especie, String raza, String nombre, int num_vacs){
        this.microchip = microchip;
        this.especie = especie;
        this.raza = raza;
        this.nombre = nombre;
        this.num_vacs = num_vacs;
    }
    
    public String crear_informe(){
        String res = "El " + especie.getNombre() + ", llamado " + nombre + "\n"
                + ", de raza: " + raza + " , tiene "  + num_vacs + " numero de vaucnas puestas en total";
        return res;
    }

    public String getMicrochip() {
        return microchip;
    }

    public Especie getEspecie() {
        return especie;
    }

    public String getRaza() {
        return raza;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNum_vacs() {
        return num_vacs;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNum_vacs(int num_vacs) {
        this.num_vacs = num_vacs;
    }
    
    
    
}


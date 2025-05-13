/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author juanj
 */
public class Cliente extends Usuario{
    
    private String telf;

    public Cliente(String usuario, String nombre, String telf) {
        super(usuario, nombre);
        this.telf = telf;
    }

    public String getTelf() {
        return telf;
    }

    @Override
    public String toString() {
        return getNombre() + ", usuario: " + getUsuario() + ", telefono: " + telf;
    }
    
    
}

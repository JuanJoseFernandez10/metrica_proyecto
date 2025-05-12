/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author juanj
 */
public class Admin extends Usuario{
    
    public Admin(String usuario, String nombre) {
        super(usuario, nombre);
    }
    
    

    @Override
    public String toString() {
        return "Admin: " + getNombre();
    }
    
}

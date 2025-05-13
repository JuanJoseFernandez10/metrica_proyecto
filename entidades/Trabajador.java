/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author juanj
 */
public class Trabajador extends Usuario{

    private Date fecha_contratacion;
    
    public Trabajador(String usuario, String nombre, Date fecha) {
        super(usuario, nombre);
        this.fecha_contratacion = fecha;
    }

    public Date getFecha_contratacion() {
        return fecha_contratacion;
    }

    @Override
    public String toString() {
        return getNombre() + ", usuario: " + getUsuario() + ", contratacion: " + fecha_contratacion;
    }
    
}

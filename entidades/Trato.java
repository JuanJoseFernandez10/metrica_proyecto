/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import Exceptions.TratoNoAceptadoException;
import entidadesDAO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanj
 */
public class Trato {
    
    private Tipo_Trato tipo;
    private Cliente c1;
    private Trabajador t1;
    private Mascota m1;
    private boolean aceptado;
    private String texto_client;
    
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

    public Trato(Tipo_Trato tipo, Cliente c1, Trabajador t1, Mascota m1, boolean aceptado, String texto_client) {
        this.tipo = tipo;
        this.c1 = c1;
        this.t1 = t1;
        this.m1 = m1;
        this.aceptado = aceptado;
        this.texto_client = texto_client;
    }

    public Tipo_Trato getTipo() {
        return tipo;
    }

    public Cliente getC1() {
        return c1;
    }

    public Trabajador getT1() {
        return t1;
    }

    public Mascota getM1() {
        return m1;
    }

    public boolean isAceptado() {
        return aceptado;
    }

    public String getTexto_client() {
        return texto_client;
    }
    
    public void subir_base_de_datos(){
        
        if(aceptado){
            try {
                Connection conn = conectarBD.conectarBD();
                String sql = "INSERT INTO mascotas (fecha_trato, id_trabajador, id_cliente, id_animal, id_tipo) VALUES (sysdate, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, t1.getUsuario());
                stmt.setString(2, c1.getUsuario());
                stmt.setString(3, m1.getMicrochip());
                if(tipo == Tipo_Trato.ADOPTAR){
                    stmt.setInt(4, 1);
                } else {
                    stmt.setInt(4, 2);
                }

                int filas = stmt.executeUpdate();
                System.out.println(filas + " filas insertadas");

            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }

        }else{
            throw new TratoNoAceptadoException("");
        }
    } 
    
    
    
    
    
}

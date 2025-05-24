/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import entidades.Admin;
import java.sql.Date;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author juanj
 */
public class AdminTest {

    Admin a1;

    public AdminTest() {
    }

    @BeforeEach
    public void setUp() {
        a1 = new Admin("admin", "Administrador", "47265506E", Date.valueOf("2019-10-21"));
    }

    /**
     *********************
     * Setters y Getters *
     *********************
     */
    @Test
    @DisplayName("Test para el setter y getter de usuario")
    public void testSetterUsuario() {
        String usuario = "administrador";
        a1.setUsuario(usuario);
        assertEquals(usuario, a1.getUsuario());
    }

    @Test
    @DisplayName("Test para el setter y getter de nombre")
    public void testSetterNombre() {
        String nuevoNombre = "Nuevo Nombre";
        a1.setNombre(nuevoNombre);
        assertEquals(nuevoNombre, a1.getNombre());
    }

    @Test
    @DisplayName("Test para el setter y getter de DNI")
    public void testSetterDNI() {
        String nuevoDni = "12345678Z";
        a1.setDNI(nuevoDni);
        assertEquals(nuevoDni, a1.getDNI());
    }
    
    /**
    ************
    * ToString *
    ************
    */

    @Test
    @DisplayName("Test del método toString")
    public void testToString() {
        String expected = "Administrador, usuario: admin DNI: 47265506E";
        assertEquals(expected, a1.toString());
    }

}

import entidades.Trabajador;
import java.sql.Date;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrabajadorTest {

    Trabajador t1;

    @BeforeEach
    public void setUp() {
        t1 = new Trabajador("adminTest", "Admin Test", "12345678A", Date.valueOf("2020-01-01"));
    }

    /**
     *********************
     * Setters y Getters *
     *********************
     */
    @Test
    @DisplayName("Test para el setter y getter de usuario")
    public void testSetterUsuario() {
        String usuario = "nuevoAdmin";
        t1.setUsuario(usuario);
        assertEquals(usuario, t1.getUsuario());
    }

    @Test
    @DisplayName("Test para el setter y getter de nombre")
    public void testSetterNombre() {
        String nombre = "Nuevo Nombre";
        t1.setNombre(nombre);
        assertEquals(nombre, t1.getNombre());
    }

    @Test
    @DisplayName("Test para el setter y getter de DNI")
    public void testSetterDNI() {
        String dni = "87654321B";
        t1.setDNI(dni);
        assertEquals(dni, t1.getDNI());
    }


    /**
     *******************
     * Test toString() *
     *******************
     */
    @Test
    @DisplayName("Test para método toString")
    public void testToString() {
        String esperado = t1.getNombre() + ", usuario: " + t1.getUsuario() + " DNI: " + t1.getDNI();
        assertEquals(esperado, t1.toString());
    }
}

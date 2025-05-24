import entidades.Cliente;
import entidades.Mascota;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClienteTest {

    Cliente c1;

    @BeforeEach
    public void setUp() {
        c1 = new Cliente("clienteTest", "Cliente Test", "88888888B", "600000000", "Calle Test 123");
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
        c1.setUsuario(usuario);
        assertEquals(usuario, c1.getUsuario());
    }

    @Test
    @DisplayName("Test para el setter y getter de nombre")
    public void testSetterNombre() {
        String nuevoNombre = "Nuevo Nombre";
        c1.setNombre(nuevoNombre);
        assertEquals(nuevoNombre, c1.getNombre());
    }

    @Test
    @DisplayName("Test para el setter y getter de DNI")
    public void testSetterDNI() {
        String nuevoDni = "12345678Z";
        c1.setDNI(nuevoDni);
        assertEquals(nuevoDni, c1.getDNI());
    }
    
    /**
     ************************
     * Test para GetLists() *
     ************************
     */

    @Test
    @DisplayName("Test para el getLista")
    public void testGetLista(){
        List<Mascota> mascotas = c1.getLista();

        assertNotNull(mascotas, "La lista de mascotas no debería ser null");
        assertEquals(3, mascotas.size(), "Debe haber 3 mascotas");
        
        Mascota m = mascotas.get(0);
        assertEquals("MC_TEST_001", m.getMicrochip());
        assertEquals("Rex Test", m.getNombre());
    }
    
    /**
     ******************************
     * Getter de la clase Cliente *
     ******************************
     */

     @Test
    public void testGetTelf() {
        assertEquals("600000000", c1.getTelf());
    }

    @Test
    public void testGetDireccion() {
        assertEquals("Calle Test 123", c1.getDireccion());
    }
}

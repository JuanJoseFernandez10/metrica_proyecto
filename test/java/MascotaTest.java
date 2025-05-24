import entidades.Mascota;
import entidades.Mascota.Especie;
import java.sql.Date;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MascotaTest {

    Mascota m1;

    @BeforeEach
    public void setUp() {
        m1 = new Mascota("MC_TEST_001", "Rex Test", Date.valueOf("2017-06-01"), "Pastor Alemán", Especie.PERRO);
    }
    
    /**
     *********************
     * Setters y Getters *
     *********************
     */
    @Test
    @DisplayName("Test para el getter de microchip")
    public void testGetMicrochip() {
        assertEquals("MC_TEST_001", m1.getMicrochip());
    }

    @Test
    @DisplayName("Test para el getter de nombre")
    public void testGetNombre() {
        assertEquals("Rex Test", m1.getNombre());
    }

    @Test
    @DisplayName("Test para el setter y getter de nombre")
    public void testSetGetNombre() {
        m1.setNombre("Max Test");
        assertEquals("Max Test", m1.getNombre());
    }

    @Test
    @DisplayName("Test para el getter de fecha de nacimiento")
    public void testGetFechaNacimiento() {
        assertEquals(Date.valueOf("2017-06-01"), m1.getFecha_nacimiento());
    }

    @Test
    @DisplayName("Test para el getter de raza")
    public void testGetRaza() {
        assertEquals("Pastor Alemán", m1.getRaza());
    }

    @Test
    @DisplayName("Test para el getter de especie")
    public void testGetEspecie() {
        assertEquals(Especie.PERRO, m1.getEspecie());
    }

    /**
     ********************
     * Test toString()  *
     ********************
     */
    @Test
    @DisplayName("Test para el método toString")
    public void testToString() {
        String esperado = "El Perro, llamado Rex Test\n, de raza: Pastor Alemán , nacido 2017-06-01";
        assertEquals(esperado, m1.toString());
    }
}

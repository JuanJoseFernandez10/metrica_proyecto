package entidadesDAO;

import entidades.Cliente;
import entidades.Mascota;
import entidades.Mascota.Especie;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOTest {

    Cliente c1;
    ClienteDAO clienteDAO;

    @BeforeEach
    public void setUp() {
        c1 = new Cliente("clienteTest", "Cliente Test", "88888888B", "600000000", "Calle Test 123");
        clienteDAO = new ClienteDAO(c1);
    }
    
    /**
     *************************
     * Test Eliminar Cliente *
     *************************
     */
    @Test
    @DisplayName("Eliminar cliente con borrado lógico")
    public void testEliminarCliente() {
        clienteDAO.eliminarCliente();
        try {
            Connection conn = conectarBD.conectarBD();
            PreparedStatement stmt = conn.prepareStatement("SELECT ES_ACTIVO FROM CLIENTE WHERE USUARIO = ?");
            stmt.setString(1, c1.getUsuario());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                assertEquals(0, rs.getInt("ES_ACTIVO"));
            }
            conectarBD.desconectarBD(conn);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *************************
     * Test Insertar Cliente *
     *************************
     */
    @Test
    @DisplayName("Insertar cliente en la base de datos")
    public void testInsertarCliente() {
        c1 = new Cliente("clienteTestDAO", "Testtt", "11111111A", "101010101", "Calle Test 123");
        clienteDAO = new ClienteDAO(c1);  
        clienteDAO.insertarCliente("clientePass");
        try {
            Connection conn = conectarBD.conectarBD();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM CLIENTE WHERE USUARIO = ?");
            stmt.setString(1, c1.getUsuario());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                assertEquals(c1.getUsuario(), rs.getString("USUARIO"));
                assertEquals("clientePass", rs.getString("CONTRASEÑA"));
                assertEquals(c1.getDNI(), rs.getString("DNI"));
                assertEquals(c1.getNombre(), rs.getString("NOMBRE"));
                assertEquals(c1.getTelf(), rs.getString("TELF"));
                assertEquals(c1.getDireccion(), rs.getString("DIRECCION"));
            }
            conectarBD.desconectarBD(conn);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     ******************************
     * Test rellenarListaMascotas *
     ******************************
     */
    @Test
    @DisplayName("Rellenar lista de mascotas del cliente")
    public void testRellenarListaMascotas() {
        List<Mascota> listaMascotas = new ArrayList<>();
        clienteDAO.rellenarListaMascotas(listaMascotas);
        assertNotNull(listaMascotas);
        assertFalse(listaMascotas.isEmpty(), "La lista de mascotas no debería estar vacía");
        Mascota m = listaMascotas.get(0);
        assertNotNull(m.getMicrochip());
        assertNotNull(m.getNombre());
        assertNotNull(m.getFecha_nacimiento());
        assertNotNull(m.getRaza());
        assertNotNull(m.getEspecie());
        assertTrue(m.getEspecie() == Especie.PERRO || m.getEspecie() == Especie.GATO || m.getEspecie() == Especie.CONEJO);
    }
}

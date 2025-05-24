package entidadesDAO;

import entidades.Cliente;
import entidades.Mascota;
import entidades.Mascota.Especie;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class MascotaDAOTest {

    Mascota m1;
    MascotaDAO mascotaDAO;
    Cliente clienteTest;

    @BeforeEach
    public void setUp() {
        m1 = new Mascota("000TEST123", "Firulais", Date.valueOf("2020-06-15"), "Labrador", Especie.PERRO);
        mascotaDAO = new MascotaDAO(m1);
        clienteTest = new Cliente("clienteTest", "Cliente Test", "88888888B", "600000000", "Calle Test 123");
    }

    /**
     *******************************
     * Test insertarMascota Método *
     *******************************
     */
    @Test
    @DisplayName("Insertar mascota en la base de datos")
    public void testInsertarMascota() {
        String resultado = mascotaDAO.insertarMascota();

        try {
            Connection conn = conectarBD.conectarBD();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM MASCOTA WHERE NUMERO_MICROCHIP = ?");
            stmt.setString(1, m1.getMicrochip());
            ResultSet rs = stmt.executeQuery();
            boolean encontrado = false;
            while(rs.next()) {
                encontrado = true;
                assertEquals(m1.getNombre(), rs.getString("NOMBRE"));
                assertEquals(m1.getFecha_nacimiento(), rs.getDate("FECHA_NACIMIENTO"));
                assertEquals(m1.getRaza(), rs.getString("RAZA"));
                assertEquals(m1.getEspecie().getIdEspecie(), rs.getInt("ID_ESPECIE"));
            }
            assertTrue(encontrado, "La mascota debería existir en la base de datos");
            conectarBD.desconectarBD(conn);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     ******************************
     * Test insertAdopcion Método *
     ******************************
     */
    @Test
    @DisplayName("Insertar adopción para mascota y cliente")
    public void testInsertAdopcion() {
        mascotaDAO.insertarMascota();

        String resultado = mascotaDAO.insertAdopcion(clienteTest);

        assertNotNull(resultado);
        assertTrue(resultado.contains(m1.getMicrochip()));
        assertTrue(resultado.contains(clienteTest.getNombre()));

        try {
            Connection conn = conectarBD.conectarBD();
            PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM CLIENTE_POSEE_MASCOTA WHERE id_cliente = ? AND id_mascota = ?");
            stmt.setString(1, clienteTest.getUsuario());
            stmt.setString(2, m1.getMicrochip());
            ResultSet rs = stmt.executeQuery();
            boolean adopcionEncontrada = false;
            while(rs.next()){
                adopcionEncontrada = true;
            }
            assertTrue(adopcionEncontrada, "La adopción debería estar registrada en la tabla CLIENTE_POSEE_MASCOTA");
            conectarBD.desconectarBD(conn);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     ******************************
     * Test eliminarMascotaMuerte *
     ******************************
     */
    @Test
    @DisplayName("Eliminar mascota de la base de datos")
    public void testEliminarMascotaMuerte() {
        mascotaDAO.insertarMascota();

        mascotaDAO.eliminarMascotaMuerte();

        try {
            Connection conn = conectarBD.conectarBD();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM MASCOTA WHERE NUMERO_MICROCHIP = ?");
            stmt.setString(1, m1.getMicrochip());
            ResultSet rs = stmt.executeQuery();
            assertFalse(rs.next(), "La mascota debería haber sido eliminada");
            conectarBD.desconectarBD(conn);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

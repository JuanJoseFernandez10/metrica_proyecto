package entidadesDAO;

import entidades.Trabajador;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.time.LocalDate;

public class TrabajadorDAOTest {

    Trabajador t1;
    TrabajadorDAO trabajadorDAO;

    @BeforeEach
    public void setUp() {
        Date fechaContratacion = Date.valueOf(LocalDate.now());
        t1 = new Trabajador("trabajadorTest", "Juan Pérez", "12345678A", fechaContratacion);
        trabajadorDAO = new TrabajadorDAO(t1);
    }

    /**
     **********************************
     * Test insertarTrabajador Método *
     **********************************
     */
    @Test
    @DisplayName("Insertar trabajador en la base de datos")
    public void testInsertarTrabajador() {
        // Crear un nuevo Trabajador para el test con fecha incluida
        Date fechaContratacion = Date.valueOf(LocalDate.now());
        Trabajador trabajadorNuevo = new Trabajador("trabajadorTestDAO", "Juan Test", "99999999Z", fechaContratacion);
        TrabajadorDAO trabajadorDAOTest = new TrabajadorDAO(trabajadorNuevo);

        int filasInsertadas = trabajadorDAOTest.insertarTrabajador("trabajadorPass");

        try {
            Connection conn = conectarBD.conectarBD();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM TRABAJADOR WHERE USUARIO = ?");
            stmt.setString(1, trabajadorNuevo.getUsuario());
            ResultSet rs = stmt.executeQuery();
            boolean encontrado = false;
            while (rs.next()) {
                encontrado = true;
                assertEquals(trabajadorNuevo.getUsuario(), rs.getString("USUARIO"));
                assertEquals("trabajadorPass", rs.getString("CONTRASEÑA"));
                assertEquals(trabajadorNuevo.getDNI(), rs.getString("DNI"));
                assertEquals(trabajadorNuevo.getNombre(), rs.getString("NOMBRE"));
                assertEquals(1, rs.getInt("ES_ACTIVO")); // Por defecto activo
            }
            assertTrue(encontrado, "El trabajador debería existir en la base de datos");
            conectarBD.desconectarBD(conn);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            fail("Excepción en la consulta SQL");
        }
    }

    /**
     **********************************
     * Test eliminarTrabajador Método *
     **********************************
     */
    @Test
    @DisplayName("Eliminar trabajador mediante borrado lógico")
    public void testEliminarTrabajador() {
        // Insertamos primero para asegurarnos que existe
        trabajadorDAO.insertarTrabajador("trabajadorPass");

        int filasEliminadas = trabajadorDAO.eliminarTrabajador();
        assertEquals(1, filasEliminadas, "Debe modificar exactamente una fila");

        try {
            Connection conn = conectarBD.conectarBD();
            PreparedStatement stmt = conn.prepareStatement("SELECT ES_ACTIVO FROM TRABAJADOR WHERE USUARIO = ?");
            stmt.setString(1, t1.getUsuario());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                assertEquals(0, rs.getInt("ES_ACTIVO"), "El trabajador debe estar marcado como inactivo");
            }
            conectarBD.desconectarBD(conn);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

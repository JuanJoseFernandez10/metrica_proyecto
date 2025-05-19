/**
 * Clase DAO para conectarse a la base de datos
 */
package entidadesDAO;

import oracle.jdbc.driver.OracleDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author juanj
 */
public class conectarBD {
    /**
     * Funcion para conectarse a la base de datos
     * @return Connection conn coneccion a la base de datos
     * @throws SQLException 
     */
    public static Connection conectarBD() throws SQLException  {
        DriverManager.registerDriver(new OracleDriver());
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
                "bsnature", "bsnature");
        System.out.println("Conectado a la base de datos");
        return conn;
    }
    /**
     * Metodo para desconectarse de la base de datos
     * @param conn 
     */
    public static void desconectarBD(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Error al desconectar BD: " + e.getMessage());
        }
    }
}

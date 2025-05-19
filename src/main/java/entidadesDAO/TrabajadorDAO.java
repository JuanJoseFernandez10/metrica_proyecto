/**
 * Clase DAO de Trabajador
 */
package entidadesDAO;

import entidades.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author juanj
 */
public class TrabajadorDAO {
    
    private Admin a1;
    
    /**
     * Constructor que toma una entidad de clase Admin
     * @param admin 
     */
    public TrabajadorDAO(Admin admin){
        this.a1 = admin;
    }   
    /**
     * Constructor vacio para inicializar
     */
    public TrabajadorDAO(){
    }    
    /**
     * Funcion que inserta Trabajadores en la base de datos
     * @param usuario
     * @param contraseña
     * @param DNI
     * @param nombre
     * @return numero de filas que se han insertado normamelte uno
     */
    public int insertarTrabajador(String usuario, String contraseña, String DNI, String nombre){
        int filas = 0;
        try {          
                Connection conn = conectarBD.conectarBD();
                System.out.println("Despues de conectarse");
                String sql = "INSERT INTO TRABAJADOR (USUARIO, CONTRASEÑA, DNI, NOMBRE, FECHA_CONTRATACION) " + "\n"
                        + "VALUES (?, ?, ?, ?, sysdate)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                System.out.println("antes de ejecutarla");
                stmt.setString(1, usuario);
                stmt.setString(2, contraseña);
                stmt.setString(3, DNI);
                stmt.setString(4, nombre);
                filas = stmt.executeUpdate();
                System.out.println("Filas insertadas : " + filas);
                
                /*System.out.println(filas + " filas insertadas");*/
                conectarBD.desconectarBD(conn);
            } catch (SQLException ex) {
                System.out.println("Error insercion: " + ex.getMessage());
            }
        
        return filas;
    }
    /**
     * Funcion que otorga el valor inactivo en la base de datos conocido como borrado logico
     * @param usuario
     * @return devuelve el numero de filas eliminadas normamelte 1
     */
    public int eliminarTrabajador(String usuario){
        int filas = 0;
        try{
            Connection conn = conectarBD.conectarBD();
            String sql = "UPDATE TRABAJADOR\n"
                    + "SET ES_ACTIVO = 0\n"
                    + "WHERE USUARIO = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            System.out.println("Hola");
            stmt.setString(1, usuario);
            
            filas = stmt.executeUpdate();
            
            System.out.println(filas + " filas eliminadas");
            conectarBD.desconectarBD(conn);
        }catch(SQLException e){
            System.out.println("Error eliminacion: " + e.getMessage());
        }
        return filas;
    }
}

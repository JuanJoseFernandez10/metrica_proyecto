/**
 * Clase DAO de Cliente
 */
package entidadesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author juanj
 */
public class ClienteDAO {
    /**
     * Constructo de la clase vacio para inicializarla
     */
    public ClienteDAO(){}
    /**
     * Metodo que inserta un Cliente en la base de datos
     * @param usuario
     * @param contraseña
     * @param DNI
     * @param nombre
     * @param telf
     * @param direccion 
     */
    public void insertarCliente(String usuario, String contraseña, String DNI, String nombre, String telf, String direccion){
    if(telf.length() > 9 || DNI.length() > 9){
        throw new IllegalArgumentException("El telefono o el DNI no puede tener mas de 9 digitos");
    }   
    try{
        Connection conn = conectarBD.conectarBD();
        String sql = "INSERT INTO CLIENTE(USUARIO, CONTRASEÑA, DNI, NOMBRE, TELF, DIRECCION)\n"
                + "VALUES(?,?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, usuario);
        stmt.setString(2, contraseña);
        stmt.setString(3, DNI);
        stmt.setString(4, nombre);
        stmt.setString(5, telf);
        stmt.setString(6, direccion);
        
        int filas = stmt.executeUpdate();
        System.out.println("Filas insertadas: " + filas);
        conectarBD.desconectarBD(conn);
    }catch(SQLException e){
        System.out.println("Error cliente insercion: " + e.getMessage());
    }
    }
    /**
     * Metodo que elimina a un cliente de la base de datos con borrado logico
     * @param usuario 
     */
    public void eliminarCliente(String usuario){
        try{
            Connection conn = conectarBD.conectarBD();
            String sql = "UPDATE CLIENTE\n"
                    + "SET ES_ACTIVO = 0\n"
                    + "WHERE USUARIO = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario);
            
            int filas = stmt.executeUpdate();
            System.out.println("Filas actualizadas: " + filas);
            conectarBD.desconectarBD(conn);
        }catch(SQLException e){
            System.out.println("Error cliente eliminacion: " + e.getMessage());
        }
    }
}

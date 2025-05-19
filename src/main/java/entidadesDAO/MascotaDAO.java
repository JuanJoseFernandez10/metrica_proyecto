/**
 * Clase DAO de Mascota
 */
package entidadesDAO;

import entidades.Cliente;
import entidades.Mascota.Especie;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 *
 * @author juanj
 */
public class MascotaDAO {
    
    /**
     * Constructor vacio para inicializar la clase
     */
    public MascotaDAO(){}

    /**
     * Metodo que inserta una mascota en la tabla Mascota
     * @param microchip
     * @param nombre
     * @param fecha_nacimiento
     * @param raza
     * @param especie
     * @return Texto para crear un fichero posiblemente.
     */
    public String insertarMascota(String microchip, String nombre, String fecha_nacimiento, String raza, Especie especie){
        int filas = 0;
        try{
            Connection conn = conectarBD.conectarBD();
            String sql = "INSERT INTO MASCOTA(NUMERO_MICROCHIP, NOMBRE, FECHA_NACIMIENTO, RAZA, ID_ESPECIE)"
                    + "VALUES(?,?,TO_DATE(?, 'YYYY-MM-DD'),?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, microchip);
            stmt.setString(2, nombre);
            stmt.setString(3, fecha_nacimiento);
            stmt.setString(4, raza);
            int id = 0;
            if(null != especie)switch (especie) {
                case PERRO:
                    id = 1;
                    break;
                case GATO:
                    id = 2;
                    break;
                case AVE:
                    id = 3;
                    break;
                default:
                    break;
            }
            stmt.setInt(5, id);
            filas = stmt.executeUpdate();
            System.out.println("Filas insertadas: " + filas);
            conectarBD.desconectarBD(conn);
        }catch(SQLException e){
            System.out.println("Error insercion mascotas: " + e.getMessage());
        }
        LocalDate date = LocalDate.now();
        String res = "";
        if(filas > 0){
            res = "Fecha: " + date.toString() + "\n" + "Se deja en el refugio BSNature a la mascota citada a continuacion\n" + nombre + ", con el numero de microchip: " + microchip + ", nacida el " + fecha_nacimiento + ".";
        }else{
            res = "Ha habido un error";
        }
        return res;
    }
    /**
     * Metodo que inserta los valores en la tabla Cliente_posee_Mascota para inicializar que es suya y actualiza el atributo ADOPTADA en la Tabla Mascota ademas de generar un trato en la bse de datos
     * @param user
     * @param microchip
     * @return Texto para cargar posiblemente un fichero
     */
    public String insertAdopcion(Cliente user, String microchip){
        LocalDate date = LocalDate.now();
        String res = "Fecha: " + date.toString() + "\n" + "Se coge en adopcion a la suigiente mascota\n" + microchip + ", departe del cliente " + user.getNombre() + "\n Cuidalo mucho.";
;
        try{
            Connection conn = conectarBD.conectarBD();
            String sql = "INSERT INTO CLIENTE_POSEE_MASCOTA(id_cliente, id_mascota, fecha) VALUES(?,?,sysdate)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            System.out.println("cargada la statement");
            stmt.setString(1, user.getUsuario());
            System.out.println("cargada la primera");
            stmt.setString(2, microchip);
            System.out.println("carga las variables");
            int filas = stmt.executeUpdate();
            System.out.println("ejecuta la consulta");
            if(filas > 0 ){
                JDialog dialog = new JDialog();
                dialog.setLayout(new FlowLayout());
                dialog.setSize(280, 200);
                dialog.add(new JLabel("Has adoptado correctamente, disfrutalo y cuidalo"));
                dialog.setVisible(true);
                dialog.toFront();
                System.out.println("lo hace correcto");
                actualizarTablaMascota(microchip);
            }else{
                JDialog dialog = new JDialog();
                dialog.setLayout(new FlowLayout());
                dialog.setSize(280, 200);
                dialog.add(new JLabel("No has adoptado correctamente, parece que ha habido un error"));
                dialog.setVisible(true);
                dialog.toFront();
                res = "Ha habido un error";
            }
        } catch(Exception e) { 
            e.printStackTrace(); 
        }
        System.out.println("entra en la funcion");
        insertarTrato(user, microchip);
        return res;
    }
    /**
     * Actualiza la tabla mascota utilizado en el metodo insertar adopcion
     * @param microchip 
     */
    private void actualizarTablaMascota(String microchip){
        try{
            Connection conn = conectarBD.conectarBD();
            String sql = "UPDATE MASCOTA\n"
                    + "SET ADOPTADA = 1\n"
                    + "WHERE NUMERO_MICROCHIP = ?\n";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, microchip);
            int filas = stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Metodo utilizado en el metodo insertarAdopcion el cual insertar Un trato en la tabla Trato
     * @param user
     * @param microchip 
     */
    private void insertarTrato(Cliente user, String microchip){
        String trabajador = null;
        try{
            String sqlTrabajador = "SELECT usuario FROM (" +
                                   "  SELECT usuario FROM Trabajador " +
                                   "  WHERE es_activo = 1 AND id_administrador IS NULL " +
                                   "  ORDER BY DBMS_RANDOM.VALUE" +
                                   ") WHERE ROWNUM = 1";

           
            Connection conn = conectarBD.conectarBD();
            PreparedStatement stmt = conn.prepareStatement(sqlTrabajador);
            ResultSet rs = stmt.executeQuery(); 
            while(rs.next()) {
                trabajador = rs.getString("usuario");
            } 
            if(trabajador.isEmpty()){
                System.out.println("El trabajador no ha sido escpgido");
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        try{
        String sqlInsert = "INSERT INTO Trato (fecha_trato, id_trabajador, id_cliente, id_animal, id_tipo) " +
                           "VALUES (SYSDATE, ?, ?, ?, ?)";
                         
            Connection conn = conectarBD.conectarBD();
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);
            stmt.setString(1, trabajador);
            stmt.setString(2, user.getUsuario());
            stmt.setString(3, microchip);
            stmt.setInt(4, 1);

            int filas = stmt.executeUpdate();
            if(filas > 0){
                System.out.println("ha ido correcto");
            }else {
                System.out.println("NO ha ido correcto");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    /**
     * Este metodo hace un borrado fisico de la Mascota
     * @param microchip 
     */
    public void eliminarMascotaMuerte(String microchip){
        try{
            Connection conn = conectarBD.conectarBD();
            String sql = "DELETE FROM MASCOTA \n" +
                         "WHERE NUMERO_MICROCHIP = '?')";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, microchip);
        }catch(SQLException e){
            System.out.println("Error eliminacion mascotas: " + e.getMessage());
        }
    }
    
}

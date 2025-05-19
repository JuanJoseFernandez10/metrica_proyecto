/**
 * Clase Date para formalizar fechas
 */
package entidades;

/**
 *
 * @author juanj
 */
public class Date {
    int dia;
    int mes;
    int año;
    /**
     * Constructor de la clase
     * @param dia
     * @param mes
     * @param año 
     */
    public Date(int dia, int mes, int año){
        if(dia <= 31 || dia > 1){
            this.dia = dia;    
        }else{
            throw new IllegalArgumentException("ERROR: La fecha es invalida");
        }
        if(mes <= 12 || mes > 1){
            this.mes = mes;    
        }else{
            throw new IllegalArgumentException("ERROR: La fecha es invalida");
        }
        this.año = año;
    }
    /**
     * Getter del dia
     * @return 
     */
    public int getDia() {
        return dia;
    }
    /**
     * Getter del mes
     * @return 
     */
    public int getMes() {
        return mes;
    }
    /**
     * Getter del año
     * @return 
     */
    public int getAño() {
        return año;
    }
    /**
     * Metodo toStrng que imprime la fecha
     * @return 
     */
    @Override
    public String toString() {
        return año + "-" + mes + "-" + dia;
    }
    
    

}

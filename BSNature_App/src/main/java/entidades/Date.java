/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }

    @Override
    public String toString() {
        return dia + "|" + mes + "|" + año;
    }
    
    

}

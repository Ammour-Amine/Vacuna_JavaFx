/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaut8.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author mac
 */
    public abstract class EventoCovid {
    //Atributo
    protected LocalDate fecha;
    
    //Constructor sin parametros.
    public EventoCovid() {
    }

    //Constructor con paramertos
    public EventoCovid(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    //Getters and setters
    public String getFecha() {
        DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String mi_date=fecha.format(forma);
        return mi_date;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    //Metodo toString.
    @Override
    public String toString() {
        
        DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String mi_date=fecha.format(forma);
        
        return " fecha: " + mi_date;
    }
    
    
    
}

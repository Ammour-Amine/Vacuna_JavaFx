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
public class Vacunacion extends EventoCovid {
    
    //Atributos.
    private Integer numDosis;
    private String nombreVacuna;

    //Constructor sin parametros.
    public Vacunacion() {
    }
    
    //Constructor con parametros.
    public Vacunacion(Integer numDosis, String nombreVacuna, LocalDate fecha) {
        super(fecha);
        this.numDosis = numDosis;
        this.nombreVacuna = nombreVacuna;
        
    }
    
    //Los getters and setters.
    public Integer getNumDosis() {
        return numDosis;
    }

    public void setNumDosis(Integer numDosis) {
        this.numDosis = numDosis;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

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
        return "Numero de dosis=" + numDosis + ", nombre de la vacuna: " + nombreVacuna +super.toString();
    }
    
    
    
    
    
    
    
    
}

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
public class PruebaContagio extends EventoCovid{
    
    //Los atributos.
    private TipoPrueba prueba;
    private boolean positivo;
    
    //Constructor sin parametros.

    public PruebaContagio() {
    }
    
    //Constructos con parametros.
    public PruebaContagio(TipoPrueba prueba, boolean positivo, LocalDate fecha) {
        super(fecha);
        this.prueba = prueba;
        this.positivo = positivo;
    }
    
    //Los getters and setters.

    public TipoPrueba getPrueba() {
        return prueba;
    }

    public void setPrueba(TipoPrueba prueba) {
        this.prueba = prueba;
    }

    public boolean isPositivo() {
        return positivo;
    }

    public void setPositivo(boolean positivo) {
        this.positivo = positivo;
    }

    public String getFecha() {
        DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String mi_date=fecha.format(forma);
        return mi_date;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        String resultado;
        
        if(positivo) resultado="Positivo";
        else    resultado ="Negativo";
        
        return "Prueba: " + prueba + ", resultado: " + resultado + super.toString();
    }
    
    
    
    
    
}

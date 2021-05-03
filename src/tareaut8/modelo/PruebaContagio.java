/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaut8.modelo;

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
    public PruebaContagio(TipoPrueba prueba, boolean positivo, String fecha) {
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
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "PruebaContagio{" + "prueba=" + prueba + ", positivo=" + positivo + super.toString()+'}';
    }
    
    
    
    
    
}

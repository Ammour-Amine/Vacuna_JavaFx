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
abstract class EventoCovid {
    //Atributo
    protected String fecha;
    
    //Constructor sin parametros.
    public EventoCovid() {
    }

    //Constructor con paramertos
    public EventoCovid(String fecha) {
        this.fecha = fecha;
    }
    
    //Getters and setters
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    //Metodo toString.
    @Override
    public String toString() {
        return "EventoCovid{" + "fecha=" + fecha + '}';
    }
    
    
    
}

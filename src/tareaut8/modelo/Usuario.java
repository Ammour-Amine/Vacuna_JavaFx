/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaut8.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

/**
 *
 * @author mac
 */
public class Usuario {
    //Declarar los variables del usuario.
    private String nombre;
    private String apellidos;
    private String dni;
    private LocalDate fechaNac;
    private String grupo;
    private String sexo;
    private LinkedList<EventoCovid> listaEventos;
    
    //Constructor por defecto.
    public Usuario() {
        this.listaEventos=new LinkedList<EventoCovid>();
    }
    
    //Constructor con parametros.
    public Usuario(String nombre, String apellidos, String dni, LocalDate fechaNac, String grupo, String sexo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechaNac = fechaNac;
        this.grupo = grupo;
        this.sexo = sexo;
        this.listaEventos=new LinkedList();
    }
    
    //Los getters and setters.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaNac() {
        DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String mi_date=fechaNac.format(forma);
        return mi_date;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    //Methodo getListaEventos.
    
    public LinkedList<EventoCovid> getListaEventos(){
        
        return new LinkedList(listaEventos);
    }
    
    //Methodo añadirEventosCovid.
    
    public void añadirEventoCovid(EventoCovid ev){
        this.listaEventos.add(ev);
    }
    
    //Metodo eliminarEventos.
    
    public void eliminarEventoCovid(EventoCovid ev){
        this.listaEventos.remove(ev);
    }
    
    //El metodo toString.
    @Override
    public String toString() {
        
        DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String mi_date=fechaNac.format(forma);
        
        return "Usuario{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", fechaNac=" + mi_date + ", grupo=" + grupo + ", sexo=" + sexo + '}';
    }
    
    
    
}

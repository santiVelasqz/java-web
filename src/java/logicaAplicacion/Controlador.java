/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicaAplicacion;

import java.util.List;
import ClasesPOJO.Empleados;
import ClasesPOJO.Incidencias;
import java.util.ArrayList;
import jpaPersistence.ControladoraPersistence;

/**
 *
 * @author Usuario
 */
public class Controlador {
    
    ControladoraPersistence controlPersis = new ControladoraPersistence(); 
    
    
     public void crearEmpleado(Empleados e){
        
        controlPersis.crearEmpleado(e);
    }
    
    public List<Empleados> mostrarEmpleados(){
        return controlPersis.mostrarEmpleados();
    }
    
    public void borrarEmpleado(int id){       
        controlPersis.borrarEmpleado(id);
    }
    
    public Empleados traerEmpleado(int id){
        return controlPersis.traerEmpleado(id);
    }
    
    public void modificarEmpleado(Empleados e){
        controlPersis.modificarEmpleado(e);
    }
    
    public void modificarContrasena(Empleados e){
        controlPersis.modificarContrasena(e);
    }
    
    public boolean comprobarIngreso(String usuario, String contrasena){
        
        boolean ingreso = false;
        List<Empleados> listaEmpleados = new ArrayList<>();
        
        listaEmpleados = controlPersis.mostrarEmpleados();
        
        for(Empleados e : listaEmpleados){
            if(e.getNombreUsuario().equals(usuario)){
                if(e.getContrasena().equals(contrasena)){
                    ingreso = true;
                }
            }
        }
        return ingreso;
    }
    
    
    
    //-------------------------- metodos para las incidencias ---------------------
    
    public Incidencias mostrarIncidencia(int id){
        return controlPersis.mostrarIncidencia(id);
    }
    
    public List<Incidencias> mostrarIncidencias(){
        return controlPersis.mostrarIncidencias();
    }
     
    public void crearIncidencia(Incidencias i){
        
        controlPersis.crearIncidencia(i);
    }
     
    public List<Incidencias> mostrarIncidenciaEmpleadoOrigen(String empleadoOrigen){
        return controlPersis.mostrarIncidenciaEmpleadoOrigen(empleadoOrigen);
    }
    public List<Incidencias> mostrarIncidenciaEmpleadoDestino(String empleadoDestino){
        return controlPersis.mostrarIncidenciaEmpleadoDestino(empleadoDestino);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpaPersistence;
import java.util.List;
import ClasesPOJO.Empleados;
import ClasesPOJO.Incidencias;
import javax.persistence.EntityManager;
import jpaPersistence.exceptions.NonexistentEntityException;
/**
 *
 * @author Usuario
 */
public class ControladoraPersistence {
    
    EmpleadosJpaController empleadoJpa = new EmpleadosJpaController();
    IncidenciasJpaController incidenciaJpa = new IncidenciasJpaController();
    
    public Empleados findEmpleadoByNombreCompleto(String nombreCompleto) {
    return empleadoJpa.findEmpleadoByNombreCompleto(nombreCompleto);
}
    
    public void crearEmpleado(Empleados e){
        
        empleadoJpa.create(e);        
    }
    
    public List<Empleados> mostrarEmpleados(){
        return empleadoJpa.findEmpleadosEntities();
    }
    
    public void borrarEmpleado(int id){
        try{
            empleadoJpa.destroy(id);
        }catch(NonexistentEntityException ex){
            ex.printStackTrace();
        }
    }
    
    public Empleados traerEmpleado(int id){
        return empleadoJpa.findEmpleados(id);
    }
    
    public void modificarEmpleado(Empleados e){
        try{
            empleadoJpa.edit(e);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void modificarContrasena (Empleados e){
        try{
            empleadoJpa.edit(e);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    // -------------- metodos para las incidencias --------------------------
    
    public Incidencias mostrarIncidencia(int id){
        return incidenciaJpa.findIncidencias(id);
    }
    
    public List<Incidencias> mostrarIncidencias(){
        return incidenciaJpa.findIncidenciasEntities();
    }
    
     public void crearIncidencia(Incidencias i){
        
        incidenciaJpa.create(i);
    }
     
    public List<Incidencias> mostrarIncidenciaEmpleadoOrigen(String empleadoOrigen){
        return incidenciaJpa.mostrarIncidenciaEmpleadoOrigen(empleadoOrigen);
    }
    public List<Incidencias> mostrarIncidenciaEmpleadoDestino(String empleadoDestino){
        return incidenciaJpa.mostrarIncidenciaEmpleadoDestino(empleadoDestino);
    }
}

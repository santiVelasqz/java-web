/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesPOJO;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "empleados")
public class Empleados implements Serializable {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre_usuario", length = 50, nullable = false)
    private String nombreUsuario;

    @Column(name = "contrasena", length = 50, nullable = false)
    private String contrasena;

    @Column(name = "nombre_completo", length = 100, nullable = false)
    private String nombreCompleto;

    @Column(name = "telefono", length = 20, nullable = false)
    private String telefono;

    @OneToMany(mappedBy = "empleadoOrigen", cascade = {}, orphanRemoval = false)
    private List<Incidencias> incidenciasOrigen;

    @OneToMany(mappedBy = "empleadoDestino", cascade = {}, orphanRemoval = false)
    private List<Incidencias> incidenciasDestino;

    public List<Incidencias> getIncidenciasOrigen() {
        return incidenciasOrigen;
    }

    public void setIncidenciasOrigen(List<Incidencias> incidenciasOrigen) {
        this.incidenciasOrigen = incidenciasOrigen;
    }

    public List<Incidencias> getIncidenciasDestino() {
        return incidenciasDestino;
    }

    public void setIncidenciasDestino(List<Incidencias> incidenciasDestino) {
        this.incidenciasDestino = incidenciasDestino;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return  nombreCompleto;
    }
    
    
}

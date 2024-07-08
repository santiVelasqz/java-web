/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import ClasesPOJO.Empleados;
import ClasesPOJO.Incidencias;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jpaPersistence.ControladoraPersistence;
import jpaPersistence.EmpleadosJpaController;
import logicaAplicacion.Controlador;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "SvIncidencias", urlPatterns = {"/SvIncidencias"})
public class SvIncidencias extends HttpServlet {
    
    Controlador control = new Controlador();
    ControladoraPersistence controlPersis = new ControladoraPersistence();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Incidencias> listaIncidencias = new ArrayList<>();
        listaIncidencias = control.mostrarIncidencias();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaIncidencias", listaIncidencias);
        
        response.sendRedirect("mostrarIncidencias.jsp");
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String empleadoOrigen = request.getParameter("empleadoOrigen");
        String empleadoDestino = request.getParameter("empleadoDestino");
        String detalle = request.getParameter("detalle");
        String tipo = request.getParameter("tipo");
        
        // Recupera los objetos Empleados existentes
        Empleados eOrigen = controlPersis.findEmpleadoByNombreCompleto(empleadoOrigen);
        Empleados eDestino = controlPersis.findEmpleadoByNombreCompleto(empleadoDestino);


        
        Incidencias i = new Incidencias();
        i.setFechaHora(LocalDateTime.now());
        i.setEmpleadoOrigen(eOrigen);
        i.setEmpleadoDestino(eDestino);
        i.setDetalle(detalle);
        i.setTipo(tipo);
        
        control.crearIncidencia(i);
        response.sendRedirect("index.jsp");
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import ClasesPOJO.Empleados;
import ClasesPOJO.Incidencias;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logicaAplicacion.Controlador;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "SvMostrarInciId", urlPatterns = {"/SvMostrarInciId"})
public class SvMostrarInciId extends HttpServlet {
    
    Controlador control = new Controlador();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        int idIncidencia = Integer.parseInt(request.getParameter("id_incidencia"));
        
        Incidencias i = control.mostrarIncidencia(idIncidencia);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("idIncidencia", i);
        
        response.sendRedirect("mostrarIncidenciaId.jsp");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

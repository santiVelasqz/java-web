/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

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
import ClasesPOJO.Empleados;
import logicaAplicacion.Controlador;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "SvEmpleados", urlPatterns = {"/SvEmpleados"})
public class SvEmpleados extends HttpServlet {
    Controlador control = new Controlador();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Empleados> listaEmpleados = new ArrayList<>();
        listaEmpleados = control.mostrarEmpleados();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaEmpleados", listaEmpleados);
        
        response.sendRedirect("verEmpleados.jsp");
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //aqui se recojen los datos del formulario
            String user = request.getParameter("user");
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String telefono = request.getParameter("telefono");
            
            Empleados e = new Empleados();
            e.setNombreUsuario(user);
            e.setContrasena(password);
            e.setNombreCompleto(name);
            e.setTelefono(telefono);
            
            control.crearEmpleado(e);
            
           response.sendRedirect("index.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

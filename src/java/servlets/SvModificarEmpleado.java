/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import ClasesPOJO.Empleados;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "SvModificarEmpleado", urlPatterns = {"/SvModificarEmpleado"})
public class SvModificarEmpleado extends HttpServlet {
    Controlador control = new Controlador();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {   
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idModificar = Integer.parseInt(request.getParameter("id"));
        
        Empleados e = control.traerEmpleado(idModificar);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("empleadoEditar", e);
        
        response.sendRedirect("editarEmpleados.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //aqui se recojen los datos del formulario
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String telefono = request.getParameter("telefono");

        Empleados e = (Empleados) request.getSession().getAttribute("empleadoEditar");
        e.setNombreUsuario(user);
        e.setContrasena(password);
        e.setNombreCompleto(name);
        e.setTelefono(telefono);

        control.modificarEmpleado(e);

       response.sendRedirect("SvEmpleados");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

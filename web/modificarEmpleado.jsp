<%-- 
    Document   : modificarEmpleado
    Created on : 27 abr 2024, 12:24:39
    Author     : Usuario
--%>

<%@page import="ClasesPOJO.Empleados"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aplicacion web empresa</title>
        <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            padding: 2rem;
        }

        h1 {
            text-align: center;
            color: #333;
            font-size: 2.5rem;
            margin-bottom: 2rem;
            text-transform: uppercase;
            letter-spacing: 2px;
            font-weight: bold;
        }

        form {
            background-color: white;
            padding: 2rem;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            margin: 0 auto 2rem;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 0.5rem;
            color: #333;
        }

        input[type="text"] {
            width: 100%;
            padding: 0.5rem;
            border: 1px solid #ccc;
            border-radius: 3px;
            font-size: 1rem;
            margin-bottom: 1rem;
        }

        button {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 0.75rem 1.5rem;
            font-size: 1rem;
            border-radius: 3px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #0056b3;
        }
        p {
            color: #333;
            margin-bottom: 1rem;
        }
    </style>
    </head>
    <body>
        <% Empleados e = (Empleados) request.getSession().getAttribute("empleadoEditar"); %>
        <h1>Datos del Empleado</h1>
        <form action="SvModificarEmpleado" method="POST">
            <p>Ingrese los datos del empleado:</p>
            <label for="user">Usuario: </label><br>
            <input type="text" id="user" name="user" value="<%=e.getNombreUsuario()%>"><br>
            <label for="password">Contraseña: </label><br>
            <input type="text" id="password" name="password" value="<%=e.getContrasena()%>"><br>
            <label for="name">Nombre empleado: </label><br>
            <input type="text" id="name" name="name" value="<%=e.getNombreCompleto()%>"><br>
            <label for="telefono">Teléfono: </label><br>
            <input type="text" id="telefono" name="telefono" value="<%=e.getTelefono()%>"><br>
            <Button type="submit" value="insertar">Guardar los cambios</button>
        </form>
    </body>
</html>

<%@page import="ClasesPOJO.Empleados"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="components/header.jsp"%>
<%@include file="components/bodytop.jsp"%>

<h1>Modificar de Empleados</h1>

    <% Empleados e = (Empleados) request.getSession().getAttribute("empleadoEditar");%>

                            <form class="user" action="SvModificarEmpleado" method="POST">
                                <div class="form-group col">
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" name="user" class="form-control form-control-user" id="user"
                                            placeholder="Nombre usuario" value="<%=e.getNombreUsuario()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="password" name="password" class="form-control form-control-user"
                                            id="password" placeholder="Contraseña" value="<%=e.getContrasena()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" name="name" class="form-control form-control-user" id="name"
                                            placeholder="Nombre" value="<%=e.getNombreCompleto()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" name="telefono" class="form-control form-control-user" id="telefono"
                                            placeholder="Teléfono" value="<%=e.getTelefono()%>">
                                    </div>
                                    
                                    
                                </div>
                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                    Guardar empleado
                                </button>                              
                            </form>

<%@include file="components/bodydown.jsp"%>


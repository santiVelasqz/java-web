<%@page import="ClasesPOJO.Empleados"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="components/header.jsp"%>
<%@include file="components/bodytop.jsp"%>


<!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Ver empleados</h1>
                    <p class="mb-4">Visualización completa de los empleados</p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Empleados</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>id</th>
                                            <th>Usuario</th>
                                            <th>Contraseña</th>
                                            <th>Nombre</th>
                                            <th>Teléfono</th>
                                            <th style=" width: 210px">Acción</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>id</th>
                                            <th>Usuario</th>
                                            <th>Nombre</th>
                                            <th>Contraseña</th>
                                            <th>Telefono</th>
                                            <th style=" width: 210px">Acción</th>
                                        </tr>
                                    </tfoot>
                                    <%
                                    List<Empleados> listaEmpleados = (List) request.getSession().getAttribute("listaEmpleados");      
                                    %>
                                    <tbody>
                                        
                                        <% for(Empleados e: listaEmpleados) {%>
                                        <tr> 
                                            <td id="id_empleado<%=e.getId()%>" ><%=e.getId()%> </td>
                                            <td><%=e.getNombreUsuario()%></td>
                                            <td><%=e.getNombreCompleto()%></td>
                                            <td><%=e.getContrasena()%></td>
                                            <td><%=e.getTelefono()%></td>
                                            <td style="display: flex; width: 230px;">
                                                <form name="eliminar" action="SvEliminarEmpleado" method="POST">
                                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:red; margin-right: 5px;">
                                                        <i class="fas fa-trash-alt"></i> Eliminar
                                                    </button>
                                                    <input type="hidden" name="id" value="<%=e.getId()%>">
                                                </form>
                                                <form name="editar" action="SvModificarEmpleado" method="GET">
                                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px;">
                                                        <i class="fas fa-pencil-alt"></i> Editar
                                                    </button>
                                                    <input type="hidden" name="id" value="<%=e.getId()%>">
                                                </form>
                                            </td>
                                        </tr>
                                        <%}%>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->
          

<%@include file="components/bodydown.jsp"%>


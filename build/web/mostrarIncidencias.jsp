<%@page import="ClasesPOJO.Incidencias"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="components/header.jsp"%>
<%@include file="components/bodytop.jsp"%>


<!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Ver incidencias</h1>
                    <p class="mb-4">Visualización completa de los incidencias</p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Incidencias</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>id</th>
                                            <th>Fecha</th>
                                            <th>Empleado de origen</th>
                                            <th>Empleado de destino</th>
                                            <th>Detalle</th>
                                            <th>Tipo</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>id</th>
                                            <th>Fecha</th>
                                            <th>Empleado de origen</th>
                                            <th>Empleado de destino</th>
                                            <th>Detalle</th>
                                            <th>Tipo</th>
                                        </tr>
                                    </tfoot>
                                    <%
                                    List<Incidencias> listaIncidencias = (List) request.getSession().getAttribute("listaIncidencias");      
                                    %>
                                    <tbody>
                                        
                                        <% for(Incidencias i: listaIncidencias) {%>
                                        <tr> 
                                            <td id="id_incidencia<%=i.getId()%>" ><%=i.getId()%> </td>
                                            <td><%=i.getFechaHora()%></td>
                                            <td><%=i.getEmpleadoOrigen()%></td>
                                            <td><%=i.getEmpleadoDestino()%></td>
                                            <td><%=i.getDetalle()%></td>
                                            <td><%=i.getTipo()%></td>
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


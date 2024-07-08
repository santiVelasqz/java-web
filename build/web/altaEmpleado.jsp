<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="components/header.jsp"%>
<%@include file="components/bodytop.jsp"%>

<h1>Alta de Empleados</h1>



                            <form class="user" action="SvEmpleados" method="POST">
                                <div class="form-group col">
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" name="user" class="form-control form-control-user" id="user"
                                            placeholder="Nombre usuario">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="password" name="password" class="form-control form-control-user"
                                            id="password" placeholder="Contraseña">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" name="name" class="form-control form-control-user" id="name"
                                            placeholder="Nombre">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" name="telefono" class="form-control form-control-user" id="telefono"
                                            placeholder="Teléfono">
                                    </div>
                                    
                                    
                                </div>
                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                    Crear empleado
                                </button>                              
                            </form>

<%@include file="components/bodydown.jsp"%>


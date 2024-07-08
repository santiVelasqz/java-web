<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="components/header.jsp"%>
<%@include file="components/bodytop.jsp"%>

<h1>Crear Incidencia</h1>



                            <form class="user" action="SvIncidencias" method="POST">
                                <div class="form-group col">
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" name="empleadoOrigen" class="form-control form-control-user" id="user"
                                            placeholder="Empleado de origen">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" name="empleadoDestino" class="form-control form-control-user"
                                            id="password" placeholder="Empleado de destino">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" name="detalle" class="form-control form-control-user" id="name"
                                            placeholder="Detalle">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" name="tipo" class="form-control form-control-user" id="telefono"
                                            placeholder="Tipo">
                                    </div>
                                    
                                    
                                </div>
                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                    Crear incidencia
                                </button>                              
                            </form>

<%@include file="components/bodydown.jsp"%>



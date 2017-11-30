<%--
  Created by IntelliJ IDEA.
  User: ihack
  Date: 25/12/2016
  Time: 08:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ include file="/WEB-INF/views/include/include.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <title>SGAD</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <spt:url value="/resources/css/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />
        <spt:url value="/resources/css/bootstrap/js/bootstrap.min.js" var="bootstrapJS" />
        <spt:url value="/resources/css/layout/layout.css" var="layoutCss" />
        <%-- Bootstrap --%>
        <link rel="stylesheet" type="text/css" href="${bootstrapCss}"/>
        <%-- Layout --%>
        <link rel="stylesheet" type="text/css" href="${layoutCss}">

    </head>
    <body>
        <div class="container">
            <div id="cabecera" class="navbar navbar-inverse">
                <a class="navbar-brand" style="color: white">
                    <t:insertAttribute name="header" />
                </a>
            </div>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <div class="panel panel-primary">
                        <div class="panel-heading">Operaciones</div>
                        <%--<div class="panel-body">--%>
                        <%--</div>--%>
                        <ul class="list-group">
                            <a href="#" class="list-group-item"><span class="glyphicon glyphicon-plus"></span> Registrar acuerdo</a>
                            <a href="#" class="list-group-item"><span class="glyphicon glyphicon-sort"></span> Ordenar acuerdos</a>
                            <a href="#" class="list-group-item"><span class="glyphicon glyphicon-search"></span> Buscar acuerdos</a>
                            <a href="#" class="list-group-item"><span class="glyphicon glyphicon-file"></span> Consultar reportes de AC</a>
                            <a href="#" class="list-group-item"><span class="glyphicon glyphicon-list"></span> Listar acuerdos</a>
                            <%--<t:insertAttribute name="body" />--%>
                        </ul>
                    </div>

                    <div class="panel panel-primary">
                        <div class="panel-heading">Administraci&oacute;n</div>
                        <%--<div class="panel-body">--%>
                        <%--</div>--%>
                        <ul class="list-group">
                            <a href="<c:url value="/user/register" />" class="list-group-item"><span class="glyphicon glyphicon-plus-sign"></span> Registrar usuario</a>
                            <a href="#" class="list-group-item"><span class="glyphicon glyphicon-plus-sign"></span> Registrar responsable</a>
                            <a href="#" class="list-group-item"><span class="glyphicon glyphicon-list"></span> Listar usuarios</a>
                            <a href="#" class="list-group-item"><span class="glyphicon glyphicon-list"></span> Listar responsables</a>
                        </ul>
                    </div>
                    <%--<div class="list-group">--%>
                        <%--<a href="#" class="list-group-item active">Operaciones</a>--%>
                        <%--<a href="#" class="list-group-item">Operacion 1</a>--%>
                        <%--<a href="#" class="list-group-item">Operacion 2</a>--%>
                        <%--<a href="#" class="list-group-item">Operacion 3</a>--%>
                        <%--<a href="#" class="list-group-item">Operacion 4</a>--%>
                        <%--<a href="#" class="list-group-item">Operacion 5</a>--%>
                        <%--&lt;%&ndash;<t:insertAttribute name="body" />&ndash;%&gt;--%>
                    <%--</div>--%>

                    <%--<div class="list-group">--%>
                        <%--<a href="#" class="list-group-item active">Administracion</a>--%>
                        <%--<a href="#" class="list-group-item">Administracion 1</a>--%>
                        <%--<a href="#" class="list-group-item">Administracion 2</a>--%>
                        <%--<a href="#" class="list-group-item">Administracion 3</a>--%>
                    <%--</div>--%>
                </div>

                <div class="col-md-9">
                    <t:insertAttribute name="main" />
                </div>
            </div>

        </div>

        <div class="container">
            <div class="panel-footer">
                <div class="row">
                    <t:insertAttribute name="footer" />
                </div>
            </div>
        </div>

        <spt:url value="/resources/js/jquery.1.10.2.min.js" var="jqueryJS" />
        <%-- JQuery --%>
        <script src="${jqueryJS}"></script>
        <script src="${bootstrapJS}"></script>
    </body>
</html>

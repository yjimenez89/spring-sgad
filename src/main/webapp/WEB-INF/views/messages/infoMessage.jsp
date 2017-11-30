<%--
  Created by IntelliJ IDEA.
  User: ihack
  Date: 28/12/2016
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../include/include.jsp" %>
<%@ page session="false" %>

<div class="panel panel-success">
    <div class="panel-heading">Informaci&oacute;n</div>
    <div class="panel-body">
        El usuario <span class="label label-default"><c:out value="${registeredUser}" /></span> se ha registrado correctamente
    </div>
</div>
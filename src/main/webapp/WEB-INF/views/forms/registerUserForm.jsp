<%--
  Created by IntelliJ IDEA.
  User: ihack
  Date: 28/12/2016
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/views/include/include.jsp" %>

<h2>Registrar usuario</h2>

<form role="form" method="post">
    <div class="form-group">
        <label for="userName">Usuario</label>
        <input type="text" name="username" class="form-control" id="userName" placeholder="yjimenez" style="width: 50%">
    </div>
    <div class="form-group">
        <label for="password">Clave</label>
        <input type="password" class="form-control" id="password" style="width: 50%">
    </div>
    <div class="form-group">
        <label for="repeatPassword">Repetir clave</label>
        <input type="password" name="password" class="form-control" id="repeatPassword" style="width: 50%">
    </div>
    <div class="form-group">
        <label for="userEmail">Correo electr&oacute;nico</label>
        <input type="email" name="email" class="form-control" id="userEmail" placeholder="yjimenez@uci.cu" style="width: 50%">
    </div>

    <div class="form-group">
        <label for="userRole">Rol</label>
        <select class="form-control" name="rol" id="userRole" style="width: 50%">
            <option value="Administrador" >Administrador</option>
            <option value = "Jefe" >Jefe-Departamento</option>
            <option value = "Consultor" >Consultor</option>
        </select>
    </div>

    <button type="submit" class="btn btn-primary" value="register">Registrar</button>
</form>
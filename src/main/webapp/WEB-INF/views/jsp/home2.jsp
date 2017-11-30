<%--<%@ include file="commons/header.jsp"%>--%>

<%--<h1>Home Page</h1>--%>

<%--<%@ include file="commons/footer.jsp"%>--%>

<%@page session="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <c:url var="home" value="/" scope="request" />

    <spring:url value="/resources/css/bootstrap/bootstrap.min.css" var="bootstrapCss" />
    <spring:url value="/resources/js/jquery.1.10.2.min.js" var="jqueryJs" />

    <link href="${bootstrapCss}" rel="stylesheet" />
    <script src="${jqueryJs}"></script>
</head>

<body>
    <nav class="navbar navbar-inverse">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand">Spring 4 MVC Ajax Hello World</a>
            </div>
        </div>
    </nav>

    <div class="container" style="min-height: 500px">

        <div class="starter-template">
            <h1>Search Form</h1>
            <br>

            <div id="feedback"></div>

            <form class="form-horizontal" id="search-form" style="max-width: 600px">
                <div class="form-group form-group-lg">
                    <label class="col-sm-2 control-label">Username</label>
                    <div class="col-sm-10">
                        <input type=text class="form-control" id="username">
                    </div>
                </div>
                <div class="form-group form-group-lg">
                    <label class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="email">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" id="bth-search"
                                class="btn btn-primary btn-lg">Search</button>
                    </div>
                </div>
            </form>

        </div>

    </div>

</body>
</html>
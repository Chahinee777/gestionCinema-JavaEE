<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="styles/great-movies-collection-styles.css">
    <title>Movie Time!</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">
        <img src="styles/logo.png" alt="Logo" style="width:80px;">
    </a>
    <div class="navbar-nav ml-auto">
        <a class="nav-link" href="logout">Deconnexion</a>
    </div>
</nav>

<h1>Movies</h1>
<div>
    <c:out value="${requestScope.table}" escapeXml="false"/>
</div>

<h1>Salles</h1>
<table>
    <tbody>
    <c:forEach var="salle" items="${salles}">
        <tr style="color: white; font-size: 30px;">
            <td>${salle.id}</td>
            <td>${salle.nom}</td>
            <td>${salle.capacite}</td>
            <td>${salle.localisation}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>

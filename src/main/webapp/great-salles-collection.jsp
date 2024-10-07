<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="styles/great-movies-collection-styles.css">
    <style>
        /* Add style to make text white */
        table td {
            color: white;
        }
    </style>
    <title>Movie Time!</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">
        <img src="styles/logo.png" alt="Logo" style="width:80px;">
    </a>
    <div class="navbar-nav ml-auto">
        <a class="nav-link" href="great-movies-collection.jsp">Visit Movies</a>
        <a class="nav-link" href="logout">Deconnexion</a>
    </div>
</nav>

<h1>Salles List</h1>
<div class="app-container">
    <!-- Output table -->
    <table>
        <c:forEach var="salle" items="${salles}">
            <tr>
                <td>${salle.id}</td>
                <td>${salle.nom}</td>
                <td>${salle.capacite}</td>
                <td>${salle.localisation}</td>
                <td>
                    <!-- Update form -->
                    <form action="${pageContext.request.contextPath}/great-salles-collection-update.jsp" method="post" style="display: inline;">
                        <input type="hidden" name="id" value="${salle.id}">
                        <input type="submit" value="Update">
                    </form>
                    <!-- Delete form -->
                    <form action="${pageContext.request.contextPath}/delete-salle" method="post" style="display: inline;">
                        <input type="hidden" name="id" value="${salle.id}">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <img src="styles/salle.jpg" width="700" height="300">
    <a href="${pageContext.request.contextPath}/great-salles-collection-add.html">Add a Salle</a>
    <a href="${pageContext.request.contextPath}/view-salles" class="btn btn-primary">View All Salles</a>
</div>
</body>
</html>

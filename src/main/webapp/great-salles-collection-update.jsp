<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="styles/great-movies-collection-styles.css">
    <title>Update Salle</title>
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
<h1>Update Salle</h1>
<div class="app-container">
    <form name="updateForm" action="${pageContext.request.contextPath}/salle-update" method="post">
        <label>
            <input type="number" hidden readonly name="id" value="${salle.id}"/>
        </label>
        <label>
            Salle name:
            <input type="text" name="nom" value="${salle.nom}" required/>
        </label>
        <label>
            Salle capacity:
            <input type="number" name="capacite" value="${salle.capacite}" required/>
        </label>
        <label>
            Salle location:
            <input type="text" name="localisation" value="${salle.localisation}" required/>
        </label>
        <input type="submit" name="submit" value="Update"/>
    </form>
    <img src="styles/salle.jpg" width="700" height="300">
</div>
</body>
</html>

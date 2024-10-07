<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
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
        <a class="nav-link" href="great-salles-collection.jsp">Visit Salles</a>
        <a class="nav-link" href="logout">Deconnexion</a>
    </div>
</nav>

<h1>Movies List</h1>
<div class="app-container">

    <!-- Output table -->
    ${requestScope.table}
    <img src="styles/movies.jpg" width="700" height="300">
    <a href="great-movies-collection-add.html">Add a Movie</a>
    <a href="${pageContext.request.contextPath}/view-movies" class="btn btn-primary">View All Movies</a>
</div>
</body>
</html>

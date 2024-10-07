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
<h1>List Movies - Update Movie</h1>
<div class="app-container">
    <form name="updateForm" action="update-movie" method="post">
        <!-- Need to pass id, but do not want user to modify (so it is a hidden field) -->
        <label>
            <input type="number" hidden readonly name="id" value="${requestScope.movie.getId()}"/>
        </label>

        <label>
            Movie title:
            <input type="text" name="title" value="${requestScope.movie.getTitle()}"/>
        </label>

        <label>
            Movie revenue:
            <input type="text" name="revenue" value="${requestScope.movie.getRevenue()}"/>
        </label>

        <input type="submit" name="submit" value="Update"/>
    </form>
    <img src="styles/movies.jpg" width="700" height="300">
</div>
</body>
</html>

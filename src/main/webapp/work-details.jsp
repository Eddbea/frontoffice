<%--
  Created by IntelliJ IDEA.
  User: eddbea
  Date: 12/02/2024
  Time: 7:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Descritif de l'oeuvre</title>
</head>
<body>
<h1>Descriptif de l'oeuvre</h1><br/>

Titre : ${work.title}<br/>
Annee de parution : ${work.release}<br/>
Genre : ${work.genre}<br/>
Artiste : ${work.mainArtist.name}<br/>
Resume : ${work.summary}<br/>

<form action="addToCart" method="POST">
<input type="hidden" name=identifiant" value="work.id"/>
<input type="submit" value="Ajouter au caddie"/>
</form>
</body>
</html>
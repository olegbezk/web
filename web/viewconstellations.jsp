<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : viewconstellations
    Created on : Nov 26, 2012, 9:11:27 PM
    Author     : Eugeny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Звезды и созвездия</title>
    </head>
    <body>
        <h1>Созвездия &nbsp;&nbsp; и &nbsp;&nbsp; <a href="ViewStars">Звезды</a></h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Латинское название</th>
                    <th>Русское название</th>
                    <th>Звезды</th>
                    <th>-</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${constellations}">
                <tr>
                    <td>${item.latinName}</td>
                    <td>${item.russianName}</td>
                    <td><a href="ViewStars?id=${item.id}">звезды</a></td>
                    <td><a href="EditConstellation?id=${item.id}">правка</a></td>
                </tr>                
            </c:forEach>
            </tbody>
        </table>
        <form action="AddConstellation" method="POST">
            Латинское название <input type="text" name="latinName" value="" size="20" /><br/>
            Русское название <input type="text" name="russianName" value="" size="20" /><br/>
            <input type="submit" value="Добавить" />
        </form>
    </body>
</html>

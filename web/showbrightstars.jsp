<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : showbrightstars
    Created on : Nov 27, 2012, 1:45:43 AM
    Author     : Eugeny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Созвездия и Звезды</title>
    </head>
    <body>
        <h1><a href="ViewConstellations">Созвездия</a> &nbsp;&nbsp; и &nbsp;&nbsp;
        <a href="ViewStars">Звезды</a></h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Лат.название</th>
                    <th>Рус.название</th>
                    <th>Склонение</th>
                    <th>Пр.восхождение</th>
                    <th>Величина</th>
                    <th>Расстояние</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${stars}">
                <tr>
                    <td>${item.latinName}</td>
                    <td>${item.russianName}</td>
                    <td>${item.declination}</td>
                    <td>${item.rightAscension}</td>
                    <td>${item.magnitude}</td>
                    <td>${item.distance}</td>
                </tr>                
            </c:forEach>
            </tbody>
        </table>
        <a href="index.jsp">К началу</a>
    </body>
</html>

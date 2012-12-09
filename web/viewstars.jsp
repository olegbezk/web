<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : viewstars
    Created on : Nov 26, 2012, 9:57:23 PM
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
        <h1><a href="ViewConstellations">Созведия</a> &nbsp;&nbsp; и &nbsp;&nbsp; Звезды </h1>
        <c:if test="${not empty constellation}">
            <h2>Созвездие ${constellation.latinName} / ${constellation.russianName}</h2>
        </c:if>
        <table border="1">
            <thead>
                <tr>
                    <th>Лат.название</th>
                    <th>Рус.название</th>
                    <th>Склонение</th>
                    <th>Пр.восхождение</th>
                    <th>Величина</th>
                    <th>Расстояние</th>
                    <c:if test="${not empty constellation}">
                    <th>-</th>
                    </c:if>
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
                        <c:if test="${not empty constellation}">
                            <td><a href="EditStar?id=${item.starPK.id}">Правка</a></td>
                        </c:if>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <c:if test="${not empty constellation}">
            <a href="AddStar?id=${constellation.id}">Добавить звезду</a>
        </c:if>


    </body>
</html>

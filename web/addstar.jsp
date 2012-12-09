<%-- 
    Document   : addstar
    Created on : Nov 26, 2012, 11:01:19 PM
    Author     : Eugeny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Звезды и Созвездия</title>
    </head>
    <body>
        <h1>Добавление звезды</h1>
        <h2>Созвездие ${constellation.latinName} / ${constellation.russianName}</h2>
        <form action="AddStar" method="POST">
            <input type="hidden" name="id" value="${id}" />
            Лат.название<input type="text" name="latinName" value="" size="30" /><br/>
            Рус.название<input type="text" name="russianName" value="" size="30" /><br/>
            Склонение<input type="text" name="declination" value="" size="10" /><br/>
            Пр.восхождение<input type="text" name="ascension" value="" size="10" /><br/>
            Величина<input type="text" name="magnitude" value="" size="10" /><br/>
            Расстояние<input type="text" name="distance" value="" size="10" /><br/>
            <input type="submit" value="Добавить" />
        </form>
    </body>
</html>

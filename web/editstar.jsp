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
        <h1>Правка данных звезды</h1>
        <h2>Созвездие ${constellation.latinName} / ${constellation.russianName}</h2>
        <form action="EditStar" method="POST">
            <input type="hidden" name="id" value="${star.starPK.id}" />
            Лат.название<input type="text" name="latinName" value="${star.latinName}" size="30" /><br/>
            Рус.название<input type="text" name="russianName" value="${star.russianName}" size="30" /><br/>
            Склонение<input type="text" name="declination" value="${star.declination}" size="10" /><br/>
            Пр.восхождение<input type="text" name="ascension" value="${star.rightAscension}" size="10" /><br/>
            Величина<input type="text" name="magnitude" value="${star.magnitude}" size="10" /><br/>
            Расстояние<input type="text" name="distance" value="${star.distance}" size="10" /><br/>
            <input type="submit" value="Готово" />
        </form>
    </body>
</html>

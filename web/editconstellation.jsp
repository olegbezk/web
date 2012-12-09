<%-- 
    Document   : editconstellation
    Created on : Nov 26, 2012, 10:26:00 PM
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
        <h1>Правка созвездия</h1>
        <form action="EditConstellation" method="POST">
            <input type="hidden" name="id" value="${constellation.id}" />
            Лат.название<input type="text" name="latinName" value="${constellation.latinName}" size="30" /><br/>
            Рус.название<input type="text" name="russianName" value="${constellation.russianName}" size="30" /><br/>
            <input type="submit" value="Готово" />
        </form>
    </body>
</html>

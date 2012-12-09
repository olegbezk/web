<%-- 
    Document   : index
    Created on : Nov 26, 2012, 8:47:55 PM
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
        <h1><a href="ViewConstellations">Созвездия</a> &nbsp;&nbsp; и &nbsp;&nbsp;
        <a href="ViewStars">Звезды</a> </h1>
        <form action="BrightStars" method="POST">
            Звезды, ярче чем <input type="text" name="magnitude" value="" size="5" />
            <input type="submit" value="Ok" />
        </form>
        <form action="VisibleStars" method="POST">
            Звезды, видимые на широте <input type="text" name="latitude" value="" size="5" />
            <input type="submit" value="Ok" />
        </form>
    </body>
</html>

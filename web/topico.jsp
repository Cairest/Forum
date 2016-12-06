<%-- 
    Document   : topico
    Created on : 27/11/2016, 21:20:17
    Author     : cassiano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tópico ${topico.getId_Topico()}</title>
    </head>
    <body>
        <h3>${topico.getTitulo()}<br><br></h3>
        <h4>${topico.getConteudo()}<br></h4>
        
    </body>
</html>

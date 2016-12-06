<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ranking dos Usuários</title>
    </head>
    <body>
        <ol>
            <c:forEach items="${rankingUsuarios}" var="usuario">
                <li>
                    ${usuario.getLogin()} : ${usuario.getPontos()}
                </li>
            </c:forEach>
        </ol>

        <button type="button" name="back" onclick="history.back()">Voltar</button>
    </body>
</html>

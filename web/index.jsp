

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Acesso ao Fórum</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h3>Entre com login e senha para acessar o Fórum:</h3>
        <form method='post' action="login">
            Login: <input type='text' name='login'/>
            Senha: <input type="password" name="senha"/>
            <input type="submit" value='Fazer Login'/><br><br>
        </form>
        <c:if test="${mensagem != null}">
            <p>${mensagem}</p><br><br>
        </c:if>
            
        <input type="button" onclick="window.location.href='cadastro.jsp'" 
               value="Clique aqui para se cadastrar"> 
    </body>
</html>

<%-- 
    Comment
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro - Fórum</title>
    </head>
    <body>
        <form method="post" action="cadastro">
            <h3>Preencha as informações solicitadas para realizar o cadastro e acessar o Fórum:</h3>
            Login: <input type='text' name='login'/><br>
            Senha: <input type="password" name="senha"/><br>
            Nome Completo: <input type="text" name="nome"/><br>
            Email: <input type="text" name="email"/><br>
            <input type="submit" value='Cadastrar'/><br>
        </form>
    </body>
</html>

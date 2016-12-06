
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo tópico</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/insereTopico" method="post">
            Título<br> <input type="text" name="titulo" /><br><br>
            Comentários <br> <textarea name="conteudo" rows="10" cols="100"></textarea><br>
            <input type="submit" name="Criar tópico" />
        </form>
    </body>
</html>

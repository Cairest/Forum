<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fórum - Tela Inicial</title>
    </head>
    <body>
        <h3>Seja bem vindo ${nome} !</h3>
        
    
        <c:forEach items="${listaTopicos}" var="topico">
            <ul>
                <li>Autor: ${topico.getLogin()} / 
                    <a href="${pageContext.request.contextPath}/exibeTopico?id=${topico.getId_Topico()}">${topico.getTitulo()}</a></li>
            </ul>
    </c:forEach>
        <a  href="insereTopico.jsp"><font size ='2'> Inserir novo tópico<br></a>
        <a href="${pageContext.request.contextPath}/exibeRanking">Exibir ranking</a>
        
    </body>
    
    
    
</html>

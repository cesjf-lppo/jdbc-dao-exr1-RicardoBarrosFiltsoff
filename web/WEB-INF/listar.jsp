<%-- 
    Document   : listar
    Created on : 11/04/2016, 21:03:06
    Author     : aluno
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Anuncio</title>
    </head>
    <body>
        <h1>Listar Anuncio</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Descrição</th>
                    <th>Preço</th>                    
                </tr>   
            <c:forEach items="${anuncios}" var="anuncio">
                  <tr>
                    <th>${anuncio.id}</th>
                    <th>${anuncio.nome}</th>
                    <th>${anuncio.descricao}</th>
                    <th>${anuncio.preco}</th>                    
                </tr>  
            </c:forEach>    
            </thead>
        </table>
        <a href="./novo.html">Novo Anuncio</a> 
    </body>
</html>

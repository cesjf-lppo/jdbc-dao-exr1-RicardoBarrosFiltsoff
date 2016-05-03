<%-- 
    Document   : novo
    Created on : 11/04/2016, 21:50:09
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Anuncio</title>
    </head>
    <body>
        <h1>Novo Anuncio</h1>
        <form method="post">
            <div>
                <label>Nome:
                    <input type="text" name="nome"/>                    
                </label>                
            </div>
            <div>
                <label>Descrição:
                    <textarea name="descricao"></textarea>                    
                </label>                
            </div>
            <div>
                <label>Preço:
                     <input type="text" name="preco"/>                         
                </label>                
            </div>
            <div>
                <input type="submit" name="submit"/>        
            </div>
        </form>
         <a href="./listar.html">Listar Anuncios</a> 
    </body>
</html>

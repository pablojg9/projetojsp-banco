<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>ERRO AO ACESSAR O SITE</title>
</head>
<body>
    <h1>Parece que você tentou encontrar um site indisponivel</h1>

    <%
        out.println(request.getAttribute("message"));
    %>

</body>
</html>

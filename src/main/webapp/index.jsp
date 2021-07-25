<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h1>Login</h1>
    <form action="ServletLogin" method="post">
        <input type="hidden" value="<%= request.getParameter("url")%>" name="url">

        <table>
            <tr>
                <td><label>Login:</label></td>
                <td> <input name="login" type="text"></td>
            </tr>
            <tr>
                <td><label>Senha:</label></td>
                <td><input name="password" type="password"></td>
            </tr>
            <tr>
                <td><button name="enviar" type="submit">Enviar</button></td>
            </tr>
        </table>
    </form>

    <form method="post" action="">
        <button>Cadastrar</button>


    </form>

    <h4>${message}</h4>

</body>
</html>
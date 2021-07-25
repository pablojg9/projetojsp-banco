<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro</title>
</head>
<body>
    <form action="ServletRegister" method="post">
        <input type="hidden" value="<%= request.getParameter("url")%>" name="url">

        <h1>Cadastrar</h1>

        <table>
            <tr>
                <td><label>Login:</label></td>
                <td> <input name="loginRegister" type="text"></td>
            </tr>
            <tr>
                <td><label>Senha:</label></td>
                <td><input name="passwordRegister" type="password"></td>
            </tr>
            <tr>
                <td><button name="enviar" type="submit">Enviar</button></td>
            </tr>
        </table>
    </form>

    <h4>${message}</h4>


</body>
</html>

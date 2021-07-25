<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro</title>
</head>
<body>
    <h1>Cadastrar</h1>

    <form method="post">
        <input type="hidden" value="<% request.getParameter("url"); %>" name="url">
        <table>
            <tr>
                <td><label>Login: </label></td>
                <td><input name="loginRegister" type="text"></td>
            </tr>
            <tr>
                <td><label>Senha: </label></td>
                <td><input name="passwordRegister" type="password"></td>
            </tr>
        </table>

        <button type="submit">Cadastrar</button>
    </form>
    <h4>${message}</h4>
</body>
</html>

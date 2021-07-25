<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <td><input name="passwordRegister" type="text"></td>
            </tr>
        </table>

        <button type="submit">Cadastrar</button>
    </form>
    <h4>${msg}</h4>
</body>
</html>

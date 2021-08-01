<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <title>JSP - Hello World</title>


</head>
<body>
    <div class="container">
        <h1>Login</h1>

        <form action="ServletLogin" method="post">
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Email address</label>
                <input  name="login" type="text" class="form-control" class="form-check-input" id="exampleInputEmail1" aria-describedby="emailHelp" required>
                <div id="emailHelp" class="form-text">Coloque o seu email</div>
            </div>
            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Password</label>
                <input name="password" type="password" class="form-control" class="form-check-input" id="exampleInputPassword1" required>
            </div>

            <button name="enviar" type="submit" class="btn btn-primary">Enviar</button>
        </form>

        <form method="post" action="ServletRegister">
            <button type="submit" class="btn btn-success">Cadastrar</button>
        </form>

    </div>


    <h4>${message}</h4>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</body>
</html>
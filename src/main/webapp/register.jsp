<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <title>Cadastro</title>
</head>
<body>
    <div class="container">
        <h1 style="text-align: center">Registrar</h1>
        <form action="ServletRegister" method="post">
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Email address</label>
                <input name="loginRegister" type="email" class="form-control" class="form-check-input" id="exampleInputEmail1" aria-describedby="emailHelp" required>
                <div id="emailHelp" class="form-text">Coloque o seu email<div><br>
            </div>
            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Password</label>
                <input name="passwordRegister" type="password" class="form-control" id="exampleInputPassword1" class="form-check-input" required>
            </div>

            <button name="sendRegistration" type="submit" class="btn btn-primary">Registrar</button>
        </form>

    </div>
    <h4>${message}</h4>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>

</body>
</html>

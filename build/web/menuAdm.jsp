<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
    <meta content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" name="viewport">
    <title>Menu do Adm</title>
</head>

<body style="background-color: rgb(210, 240, 245);">
    <header>
        <nav class="navbar navbar-light bg-faded" style="background-color: rgb(0, 0, 0); border-color: #000; justify-content: normal;">
            <a class="navbar-brand" href="#">
                <img src="imagens/download.png" width="100" height="100">
            </a>
            <div>
                <a class="nav-link" href="./menuAdm.jsp">Home</a>
            </div>
            <div>
                <a class="nav-link" href="./cadastroMedico.jsp">Cadastrar Médico</a>
            </div>
            <div>
                <a class="nav-link" href="./cadastroPacienteAdm.jsp">Cadastrar Paciente</a>
            </div>
            <div>
                <a class="nav-link" href="./cadastroTipoPlano.jsp">Cadastrar Plano</a>
            </div>
            <div>
                <a class="nav-link" href="./cadastroEspecialidade.jsp">Cadastrar Especialidade</a>
            </div>
            <div>
                <a class="nav-link" href="./cadastroAdministrador.jsp">Cadastrar Administrador</a>
            </div>
            <div>
                <a class="nav-link" href="./login.jsp">Logout</a>
            </div>
        </nav>
    </header>
</body>
</html>

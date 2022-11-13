<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
    <meta content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" name="viewport">
    <title>Login</title>
</head>

<body style="background-color: rgb(210, 240, 245);">
    <header>
        <nav class="navbar navbar-light bg-faded" style="background-color: rgb(0, 0, 0); border-color: #000;">
            <a class="navbar-brand" href="#">
                <img src="imagens/download.png" width="100" height="100">
            </a>
            <li>
                <a class="nav-link" href="./login.jsp">Login</a> 
            </li>
            <li>
                <a class="nav-link" href="./cadastroAdministrador.jsp">Adm</a> 
            </li>
            <li>
                <a class="nav-link" href="./cadastroConsulta.jsp">Consulta</a> 
            </li>
            <li>
                <a class="nav-link" href="./cadastroEspecialidade.jsp">Especialidade</a> 
            </li>
            <li>
                <a class="nav-link" href="./cadastroExame.jsp">Exame</a> 
            </li>
            <li>
                <a class="nav-link" href="./cadastroMedico.jsp">Medico</a> 
            </li>
            <li>
                <a class="nav-link" href="./cadastroTipoExame.jsp">Tipo exame</a> 
            </li>
            <li>
                <a class="nav-link" href="./cadastroPaciente.jsp">Paciente</a> 
            </li>
            <li>
                <a class="nav-link" href="./cadastroTipoPlano.jsp">Tipo plano</a> 
            </li>
        </nav>
    </header>
    <section id="formLogin">
        <h2 style="text-align: center;" class="margin">Login no sistema</h2>
        <div class="container-fluid formLogin">
            <form  action="/login" method="post">
                <div class="container">
                    <div class="row">
                        <div class="container-fluid col-lg-3 mx-auto margin">
                            <label for="CPFFuncLogin" class="form-label"><b>CPF</b></label>
                            <input name="cpf" class="form-control" id="inputCPFFuncLogin">
                        </div>
                    </div>
                    <div class="row">
                        <div class="container-fluid col-lg-3 mx-auto margin">
                            <label for="senhaFuncLogin" class="form-label"><b>Senha</b></label>
                            <input name="senha" type="password" class="form-control" id="inputSenhaFuncLogin">
                        </div>
                    </div>
                    <div class="form-group col-lg-3 mx-auto margin">
                        <label><b>Selecione a especialidade</b></label>
                        <select name="roles">
                            <option value="paciente">Admnistrador</option>
                            <option value="paciente">Médico</option>
                            <option value="paciente">Paciente</option>
                        </select><br><br>
                    </div>
                    <div class="container-fluid">
                        <div class="mx-auto margin" style="width: 200px;">
                            <input type="submit" value="Fazer login" class="btn btn-primary"/>
                        </div>
                        <div class="mx-auto margin" style="width: 200px;">
                            <a class="btn btn-primary" href="./cadastroPaciente.jsp" role="button">Cadastre-se</a>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </section>
</body>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
    <meta content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" name="viewport">
    <title>Cadastro do Tipo do Plano</title>
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
    <section id="formCadastroTipoPlano">
        <h2 style="text-align: center;" class="margin">Cadastro do tipo de um Plano</h2>
        <div class="container-fluid formCadastroTipoPlano">
                <div class="container">
                    <div class="row">
                        <div class="container-fluid col-lg-8 mx-auto margin">
                            <label for="descricaoDaEspecialidade" class="form-label"><b>DescriÃ§Ã£o do Tipo do Plano</b></label>
                            <input name="tipoPlano" class="form-control" id="inputTipoPlano">
                        </div>
                    </div>
                    <div class="container-fluid">
                        <div class="mx-auto margin" style="width: 200px;">
                            <input type="submit" value="Cadastrar tipo de Plano" class="btn btn-primary"/>
                        </div>
                    </div>
                </div>
        </div>
    </section>
</body>
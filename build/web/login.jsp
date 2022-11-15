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
        <nav class="navbar navbar-light bg-faded" style="background-color: rgb(0, 0, 0); border-color: #000; justify-content: normal;">
            <a class="navbar-brand" href="#">
                <img src="imagens/download.png" width="100" height="100">
            </a>
            <div>
                <a class="nav-link" href="./login.jsp">Login</a>
            </div>
            <div>
               <a class="nav-link" href="./cadastroPaciente.jsp">Cadastro</a>  
            </div>
            <div>
               <a class="nav-link" href="./listaDeEspecialidades.jsp">Especialidades</a>  
            </div>
            <div>
                <a class="nav-link" href="./menuPaciente.jsp">Menu paciente</a>
            </div>
            <div>
                <a class="nav-link" href="./menuMedicoConsulta.jsp">Menu médico</a>
            </div>
        </nav>
    </header>
    <section id="formLogin">
        <h2 style="text-align: center;" class="margin">Login no sistema</h2>
        <div class="container-fluid formLogin">
            <form  action="Autentica?acao=logar" method="POST">
                <div class="container">
                    <div class="row">
                        <div class="container-fluid col-lg-3 mx-auto margin">
                            <label for="cpf" class="form-label"><b>CPF</b></label>
                            <input name="cpf" class="form-control">
                        </div>
                    </div>
                    <div class="row">
                        <div class="container-fluid col-lg-3 mx-auto margin">
                            <label for="senha" class="form-label"><b>Senha</b></label>
                            <input name="senha" type="password" class="form-control">
                        </div>
                    </div>
                    <div class="form-group col-lg-3 mx-auto margin">
                        <label><b>Selecione a especialidade</b></label>
                        <select name="roles">
                            <option value="paciente">Paciente</option>
                            <option value="medico">Médico</option>
                            <option value="administrador">Administrador</option>
                        </select><br><br>
                    </div>
                    <div class="container-fluid">
                        <div class="mx-auto margin" style="width: 200px;">
                            <input type="submit" value="Enviar" class="btn btn-primary"/>
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
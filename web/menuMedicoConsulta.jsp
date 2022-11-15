<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <html lang="pt-br">

    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
        <meta content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" name="viewport">
        <title>Cadastro da consulta</title>
    </head>

    <body style="background-color: rgb(210, 240, 245);">
        <header>
            <nav class="navbar navbar-light bg-faded" style="background-color: rgb(0, 0, 0); border-color: #000; justify-content: normal;">
                <a class="navbar-brand" href="#">
                <img src="imagens/download.png" width="100" height="100">
            </a>
            <div>
                <a class="nav-link" href="./menuMedicoConsulta.jsp">Menu</a>
            </div>
            <div>
                <a class="nav-link" href="./login.jsp">Logout</a>
            </div>
            </nav>
        </header>

        <section id="formCadastroConsulta">
            <h2 style="text-align: center;" class="margin">Cadastro de uma consulta</h2>
            <div class="container-fluid formCadastroConsulta">
                <form>
                    <div class="container">
                        <div class="row">
                            <div class="container-fluid col-sm-2 mx-auto margin">
                                <label for="dataConsulta" class="form-label"><b>Data da consulta</b></label>
                                <input class="form-control" id="inputDataConsulta" placeholder="dd/mm/aaaa">
                            </div>
                            <div class="container-fluid col-md-8 mx-auto margin">
                                <label for="descricaoConsulta" class="form-label"><b>Descrição da consulta</b></label>
                                <input class="form-control" id="inputDescricaoConsulta">
                            </div>
                            <div class="container-fluid col-lg-2 mx-auto margin">
                                <label for="realizadaConsulta" class="form-label"><b>Consulta realizada?</b></label>
                                <input class="form-control" id="inputRealizadaConsulta">
                            </div>
                            <div class="container-fluid col-lg-2 mx-auto margin">
                                <label for="idMedicoConsulta" class="form-label"><b>ID do médico</b></label>
                                <input class="form-control" id="inputIDMedicoConsulta">
                            </div>
                            <div class="container-fluid col-lg-2 mx-auto margin">
                                <label for="idPacienteConsulta" class="form-label"><b>ID do paciente</b></label>
                                <input class="form-control" id="inputIDPacienteConsulta">
                            </div>
                        <div class="container-fluid">
                            <div class="mx-auto margin" style="width: 200px;">
                                <button type="submit" class="btn btn-primary">Cadastrar Consulta</button>
                            </div>
                        </div>
                    </div>
                        <h1>Fazer a tabela do programa do trabalho de eng de soft</h1>
                </form>
            </div>
        </section>
    </body>
</html>
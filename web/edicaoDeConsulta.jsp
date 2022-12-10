<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
        <meta content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" name="viewport">
        <title>Edição de consulta</title>
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
                <div>
                    <a class="nav-link" href="./edicaoDeConsulta.jsp">Edição</a>
                </div>
            </nav>
        </header>

        <section id="formCadastroConsulta">
            <h2 style="text-align: center;" class="margin">Cadastro de uma consulta</h2>
            <div class="container-fluid formCadastroConsulta">
                <form action="MedicoServletConsulta" method="POST">
                    <div class="container">
                        <input hidden name ="acao" id="acao" value="cadastrar">
                        <div class="row">
                            <div class="container-fluid col-md-8 mx-auto margin">
                                <label for="descricao" class="form-label"><b>Descrição da consulta</b></label>
                                <input class="form-control" name="descricao" id="descricao">
                            </div>
                            <div class="form-group col-lg-3 mx-auto margin">
                                <label><b>Consulta realizada?</b></label>
                                <select name="realizada">
                                    <option value="S">Sim</option>
                                    <option value="N">Não</option>
                                </select>
                            </div>
                            <div class="container-fluid">
                                <div class="mx-auto margin" style="width: 200px;">
                                    <button type="submit" name="btEnviar" class="btn btn-primary">Cadastrar Consulta</button>
                                </div>
                            </div>
                        </div>
                </form>
            </div>
        </section>
    </body>
</html>
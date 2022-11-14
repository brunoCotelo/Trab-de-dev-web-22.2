<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <html lang="pt-br">

    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
        <meta content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" name="viewport">
        <title>Cadastro do exame</title>
    </head>

    <body style="background-color: rgb(210, 240, 245);">
        <header>
            <nav class="navbar navbar-light bg-faded" style="background-color: rgb(0, 0, 0); border-color: #000;">
                <a class="navbar-brand" href="#">
                <img src="imagens/download.png" width="100" height="100">
            </a>
            <div>
                <a class="nav-link" href="./menuPaciente.jsp">Menu</a>
            </div>
            <div>
                <a class="nav-link" href="./login.jsp">Logout</a>
            </div>
            </nav>
        </header>

        <section id="formCadastroExame">
            <h2 style="text-align: center;" class="margin">Cadastro de um exame</h2>
            <div class="container-fluid formCadastroCategoria">
                <form>
                    <div class="container">
                        <div class="row">
                            <div class="container-fluid col-lg-3 mx-auto margin">
                                <label for="IDExame" class="form-label"><b>ID do exame</b></label>
                                <input class="form-control" id="inputIDExame">
                            </div>
                            <div class="container-fluid col-lg-3 mx-auto margin">
                                <label for="IDTipoExame" class="form-label"><b>ID do tipo do exame</b></label>
                                <input class="form-control" id="IDTipoExame">
                            </div> 
                            <div class="container-fluid col-lg-3 mx-auto margin">
                                <label for="IDConsultaExame" class="form-label"><b>ID da consulta</b></label>
                                <input class="form-control" id="IDConsultaExame">
                            </div>   
                        </div>
                        <div class="container-fluid">
                            <div class="mx-auto margin" style="width: 200px;">
                                <button type="submit" class="btn btn-primary">Cadastrar Exame</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </section>
    </body>
</html>
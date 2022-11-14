<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
    <meta content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" name="viewport">
    <title>Cadastro do Tipo do Exame</title>
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
    <section id="formCadastroTipoExame">
        <h2 style="text-align: center;" class="margin">Cadastro do tipo de um exame</h2>
        <div class="container-fluid formCadastroTipoExame">
                <div class="container">
                    <div class="row">
                        <div class="container-fluid col-lg-8 mx-auto margin">
                            <label for="descricaoDaEspecialidade" class="form-label"><b>DescriÃ§Ã£o do Tipo do Exame</b></label>
                            <input name="tipoExame" class="form-control" id="inputTipoExame">
                        </div>
                    </div>
                    <div class="container-fluid">
                        <div class="mx-auto margin" style="width: 200px;">
                            <input type="submit" value="Cadastrar tipo de exame" class="btn btn-primary"/>
                        </div>
                    </div>
                </div>
        </div>
    </section>
</body>
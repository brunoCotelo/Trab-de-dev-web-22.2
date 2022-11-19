<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
        <meta content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" name="viewport">
        <title>Cadastro do Paciente</title>
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
                    <a class="nav-link" href="./cadastroPaciente.jsp">Cadastro Paciente</a> 
                </div>
                <div>
                    <a class="nav-link" href="./especialidadesEPlanos.jsp">Especialidades e planos</a>  
                </div>
            </nav>
        </header>

        <section id="formCadstroPaciente">
            <h2 style="text-align: center;" class="margin"> Cadastro de um paciente</h2>
            <div class="container-fluid formCadstroPaciente">
                <form action="PacienteServlet" method="POST">
                    <div class="container">
                        <input hidden name ="acao" id="acao" value="cadastrar">
                        <div class="row">
                            <div class="mb-auto col-lg-4 mx-auto">
                                <label for="nome" class="form-label"><b>Nome</b></label>
                                <input name="nome" class="form-control" id="nome">
                            </div>
                            <div class="mb-auto col-lg-2 mx-auto">
                                <label for="cpf" class="form-label"><b>CPF</b></label>
                                <input name="cpf" class="form-control" id="cpf" placeholder="______.______.______-____">
                            </div>
                            <div class="container-fluid col-lg-2 mx-auto">
                                <label for="senha" class="form-label"><b>Senha</b></label>
                                <input name="senha" type="password" class="form-control" id="senha">
                            </div>
                            <!--<div class="mb-auto col-lg-1 mx-auto">
                                <label for="autorizado" class="form-label"><b>Autorizado</b></label>
                                <input name="autorizado" class="form-control" id="autorizado">
                            </div> -->
                            <div class="form-group col-lg-3 mx-auto margin">
                                <label for="autorizado"><b>Autorizado</b></label>
                                <select name="autorizado">
                                    <option value="S">Sim</option>
                                    <option value="N">Não</option>
                                </select><br><br>
                            </div>
                        </div>
                        <div class="row">
                            <div class="mx-auto margin" style="width: 200px;">
                                <button type="submit" name="btEnviar" class="btn btn-primary">Cadastrar</button>
                            </div>
                        </div>
                </form>
            </div>
        </section>
    </body>
</html>
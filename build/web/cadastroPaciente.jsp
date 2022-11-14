<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
        <meta content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" name="viewport">
        <title>Cadastro do Paciente</title>
            <script language="JavaSript">
            function retornar() {
                history.go(-1);
            }
        </script>
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
                    <a class="nav-link" href="./cadastroPaciente.jsp">Cadastro Paciente</a> 
                </li>
            </nav>
        </header>

        <section id="formCadstroPaciente">
            <h2 style="text-align: center;" class="margin"> Cadastro de um paciente</h2>
            <div class="container-fluid formCadstroPaciente">
                <form>
                    <div class="container">
                        <div class="row">
                            <div class="mb-auto col-lg-4 mx-auto">
                                <label for="nomePaciente" class="form-label"><b>Nome</b></label>
                                <input class="form-control" id="inputNomePaciente">
                            </div>
                            <div class="mb-auto col-lg-2 mx-auto">
                                <label for="cpfPaciente" class="form-label"><b>CPF</b></label>
                                <input class="form-control" id="inputCPFPaciente" placeholder="______.______.______-____">
                            </div>
                            <div class="container-fluid col-lg-2 mx-auto">
                                <label for="senhaFuncLogin" class="form-label"><b>Senha</b></label>
                                <input name="senha" type="password" class="form-control" id="inputSenhaFuncLogin">
                            </div>
                            <div class="mb-auto col-lg-1 mx-auto">
                                <label for="autorizadoPaciente" class="form-label"><b>Autorizado</b></label>
                                <input class="form-control" id="inputAutorizadoPaciente">
                            </div>
                        </div>
                        <div class="row">
                            <div class="mx-auto margin" style="width: 200px;">
                                <button type="submit" class="btn btn-primary">Cadastrar</button>
                            </div>
                        </div>
                </form>
            </div>
        </section>
    </body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
        <meta content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" name="viewport">
        <title>Cadastro do MÃ©dico</title>
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

        <section id="formCadstroMedico">
            <h2 style="text-align: center;" class="margin"> Cadastro de um mÃ©dico</h2>
            <div class="container-fluid formCadstroMedico">
                <form>
                    <div class="container">
                        <div class="row">
                            <div class="mb-auto col-lg-4 margin">
                                <label for="nomeMedico" class="form-label"><b>Nome</b></label>
                                <input class="form-control" id="inputNomeMedico">
                            </div>
                            <div class="mb-auto col-lg-2 margin">
                                <label for="crmMedico" class="form-label"><b>CRM</b></label>
                                <input class="form-control" id="inputCRMMedico">
                            </div>
                            <div class="mb-auto col-lg-1 margin">
                                <label for="estadoCRMMedico" class="form-label"><b>Status CRM</b></label>
                                <input class="form-control" id="inputEstadoCRMMedico">
                            </div>
                            <div class="mb-auto col-lg-2 margin">
                                <label for="cpfMedico" class="form-label"><b>CPF</b></label>
                                <input class="form-control" id="inputCPFMedico" placeholder="______.______.______-____">
                            </div>
                            <div class="container-fluid col-lg-2 mx-auto margin">
                                <label for="senhaFuncLogin" class="form-label"><b>Senha</b></label>
                                <input name="senha" type="password" class="form-control" id="inputSenhaFuncLogin">
                            </div>
                            <div class="mb-auto col-lg-1 margin">
                                <label for="autorizadoMedico" class="form-label"><b>Autorizado</b></label>
                                <input class="form-control" id="inputAutorizadoMedico">
                            </div>
                        </div>
                        <div class="row">
                            <div class="mx-auto margin" style="width: 200px;">
                                <button type="submit" class="btn btn-primary">Cadastrar Medico</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </section>
    </body>

</html>
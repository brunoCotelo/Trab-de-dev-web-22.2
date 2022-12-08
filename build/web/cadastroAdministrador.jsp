<%@page import="Aplicacao.Atores.Administrador"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.AdmDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
        <meta content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" name="viewport">
        <title>Cadastro do Administrador</title>
    </head>

    <body style="background-color: rgb(210, 240, 245);">
        <header>
            <nav class="navbar navbar-light bg-faded" style="background-color: rgb(0, 0, 0); border-color: #000; justify-content: normal;">
               <a class="navbar-brand" href="#">
                <img src="imagens/download.png" width="100" height="100">
            </a>
            <div>
                <a class="nav-link" href="./menuAdm.jsp">Home</a>
            </div>
            <div>
                <a class="nav-link" href="./cadastroMedico.jsp">Cadastrar Médico</a>
            </div>
            <div>
                <a class="nav-link" href="./cadastroPacienteAdm.jsp">Cadastrar Paciente</a>
            </div>
            <div>
                <a class="nav-link" href="./cadastroTipoPlano.jsp">Cadastrar Plano</a>
            </div>
            <div>
                <a class="nav-link" href="./cadastroEspecialidade.jsp">Cadastrar Especialidade</a>
            </div>
            <div>
                <a class="nav-link" href="./cadastroAdministrador.jsp">Cadastrar Administrador</a>
            </div>
            <div>
                <a class="nav-link" href="./login.jsp">Logout</a>
            </div>
            </nav>
        </header>

        <section id="formCadstroMedico">
            <h2 style="text-align: center;" class="margin"> Cadastro de um administrador</h2>
            <div class="container-fluid formCadstroAdm">
                <form>
                    <div class="container">
                        <div class="row">
                            <div class="mb-auto col-lg-4 mx-auto margin">
                                <label for="nomeAdm" class="form-label"><b>Nome</b></label>
                                <input class="form-control" id="inputNomeAdm">
                            </div>
                            <div class="mb-auto col-lg-2 mx-auto margin">
                                <label for="cpfAdm" class="form-label"><b>CPF</b></label>
                                <input class="form-control" id="inputCPFAdm" placeholder="______.______.______-____">
                            </div>
                            <div class="container-fluid col-lg-2 mx-auto margin">
                                <label for="senhaAdm" class="form-label"><b>Senha</b></label>
                                <input name="senha" type="password" class="form-control" id="inputSenhaAdm">
                            </div>
                        </div>
                        <div class="row">
                            <div class="mx-auto margin" style="width: 200px;">
                                <button type="submit" class="btn btn-primary">Cadastrar Administrador</button>
                            </div>
                        </div>
                    </div>
                </form>
                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">Nome</th>
                                <th scope="col">CPF</th>
                                <th scope="col">Senha</th>
                                <th scope="col">Excluir</th>
                                <th scope="col">Alterar</th>

                            </tr>
                        </thead>
                        <tbody>

                            <%

                                AdmDAO admDAO = new AdmDAO();
                                ArrayList<Administrador> listaAdministradores = admDAO.ListaDeAdministradores();
                                for (Administrador administrador : listaAdministradores) {
                                    out.println("<tr>");
                                    out.println("<th>" + administrador.getNome() + "</th>");
                                    out.println("<th>" + administrador.getCpf() + "</th>");
                                    out.println("<th>" + administrador.getSenha() + "</th>");
                            %>

                        <td><a href="ConsultaServlet?acao=Excluir&id=<%=administrador.getId()%>" type="submit" name="btEnviar" class="btn btn-danger">Excluir</button></td>
                        <td><a href="ConsultaServlet?acao=Alterar&id=<%=administrador.getId()%>" type="submit" name="btEnviar" class="btn btn-warning">Alterar</a></td>

                        <%   out.println("</tr>");
                            }
                        %>

                        </tbody>
                    </table>
            </div>
        </section>
    </body>

</html>
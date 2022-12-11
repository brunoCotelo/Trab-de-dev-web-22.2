<%@page import="Model.PacienteDAO"%>
<%@page import="Aplicacao.Atores.Paciente"%>
<%@page import="Aplicacao.consulta_exame_descricao.TipoPlano"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.TipoPlanoDAO"%>
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

        <section id="formCadstroPaciente">
            <h2 style="text-align: center;" class="margin"> Cadastro de um paciente</h2>
            <div class="container-fluid formCadstroPaciente">
                <form action="PacienteServlet" method="POST">
                    <div class="container">
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
                            <div class="form-group col-lg-3 mx-auto margin">
                                <label for="idtipoplano"><b>Convênios</b></label>
                                <select name="idtipoplano" id="idtipoplano">
                                    <%
                                        TipoPlanoDAO tipoPlanoDAO = new TipoPlanoDAO();
                                        ArrayList<TipoPlano> listaTipoPlanos = tipoPlanoDAO.ListaDeTipoPlano();

                                        for (TipoPlano tipoPlano : listaTipoPlanos) {
                                            out.println("<option value=" + tipoPlano.getId() + ">" + tipoPlano.getDescricao() + "</option>");%>
                                    <%
                                        }
                                    %> 
                                </select><br><br>
                            </div>

                        </div>
                        <div class="row">
                            <div class="mx-auto margin" style="width: 200px;">
                                <button type="submit" name="btEnviar" class="btn btn-primary"><input hidden name ="acao" id="acao" value="cadastrar">Cadastrar</button>
                            </div>
                        </div>

                    </div>
                </form>
                <table class="table table-bordereds">
                    <thead>
                        <tr>
                            <th scope="col">Nome</th>
                            <th scope="col">CPF</th>
                            <th scope="col">Senha</th>
                            <th scope="col">Autorizado</th>
                            <th scope="col">Id Tipo Plano</th>
                            <th scope="col">Excluir</th>
                            <th scope="col">Alterar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            PacienteDAO pacienteDAO = new PacienteDAO();
                            ArrayList<Paciente> listaPacientes = pacienteDAO.ListaDePacientes();

                            for (Paciente paciente : listaPacientes) {
                                out.println("<tr>");
                                out.println("<th>" + paciente.getNome() + "</th>");
                                out.println("<th>" + paciente.getCpf() + "</th>");
                                out.println("<th>" + paciente.getSenha() + "</th>");
                                out.println("<th>" + paciente.getAutorizado() + "</th>");
                                out.println("<th>" + paciente.getIdtipoplano() + "</th>");

                        %>

                    <td><a href="PacienteServlet?acao=Excluir&id=<%=paciente.getId()%>" type="submit" name="btEnviar" class="btn btn-danger">Excluir</button></td>
                    <td><a href="PacienteServlet?acao=Alterar&id=<%=paciente.getId()%>" type="submit" name="btEnviar" class="btn btn-warning">Alterar</a></td>

                    <%   out.println("</tr>");
                        }
                    %>

                    </tbody>
                </table>
        </section>
    </body>
</html>
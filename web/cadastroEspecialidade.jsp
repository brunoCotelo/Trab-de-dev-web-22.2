<%@page import="Aplicacao.consulta_exame_descricao.Especialidade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.EspecialidadeDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
        <meta content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" name="viewport">
        <title>Cadastro da Especialidade</title>
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
                    <a class="nav-link" href="./login.jsp">Logout</a>
                </div>
            </nav>
        </header>
        <section id="formCadastroEspecialidade">
            <h2 style="text-align: center;" class="margin">Cadastro de uma especialidade</h2>
            <div class="container-fluid formCadastroEspecialidade">
                <form action="EspecialidadeServlet" method="POST">
                <div class="container">
                    <div class="row">
                        <div class="container-fluid col-lg-8 mx-auto margin">
                            <label for="descricao" class="form-label"><b>Descrição da Especialidade</b></label>
                            <input name="descricao" class="form-control" id="descricao">
                        </div>
                    </div>
                    <div class="container-fluid">
                        <div class="mx-auto margin" style="width: 200px;">
                             <button type="submit" name="btEnviar" class="btn btn-primary"><input hidden name ="acao" id="acao" value="cadastrar">Cadastrar</button>
                        </div>
                    </div>
                </div>
                </form>
                <table class="table table-bordereds">
                    <thead>
                        <tr>
                            <th scope="col">Especialidades</th>
                            <th scope="col">Excluir</th>
                            <th scope="col">Alterar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
                            ArrayList<Especialidade> listaEspecialidades = especialidadeDAO.ListaDeEspecialidade();

                            for (Especialidade especialidade : listaEspecialidades) {
                                out.println("<tr>");
                                out.println("<th>" + especialidade.getDescricao() + "</th>");%>

                    <td><a href="EspecialidadeServlet?acao=Excluir&id=<%=especialidade.getId()%>" type="submit" name="btEnviar" class="btn btn-danger">Excluir</button></td>
                    <td><a href="EspecialidadeServlet?acao=Alterar&id=<%=especialidade.getId()%>" type="submit" name="btEnviar" class="btn btn-warning">Alterar</a></td>

                    <%   out.println("</tr>");
                        }
                    %>

                    </tbody>
                </table>
            </div>
        </section>
    </body>
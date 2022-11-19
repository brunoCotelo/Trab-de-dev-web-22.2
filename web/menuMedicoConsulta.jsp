<%@page import="Aplicacao.consulta_exame_descricao.Consulta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.ConsultaDAO"%>
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
                <form action="ConsultaServlet" method="POST">
                    <div class="container">
                        <input hidden name ="acao" id="acao" value="cadastrar">
                        <div class="row">
                            <div class="container-fluid col-sm-2 mx-auto margin">
                                <label for="data" class="form-label"><b>Data da consulta</b></label>
                                <input class="form-control" name="data" id="data" placeholder="dd/mm/aaaa">
                            </div>
                            <div class="container-fluid col-md-8 mx-auto margin">
                                <label for="descricao" class="form-label"><b>Descrição da consulta</b></label>
                                <input class="form-control" name="descricao" id="descricao">
                            </div>
                            <div class="container-fluid col-lg-2 mx-auto margin">
                                <label for="realizada" class="form-label"><b>Consulta realizada?</b></label>
                                <input class="form-control" name="realizada" id="realizada">
                            </div>
                            <div class="container-fluid col-lg-2 mx-auto margin">
                                <label for="idmedico" class="form-label"><b>ID do médico</b></label>
                                <input class="form-control" name="idmedico" id="idmedico">
                            </div>
                            <div class="container-fluid col-lg-2 mx-auto margin">
                                <label for="idpaciente" class="form-label"><b>ID do paciente</b></label>
                                <input class="form-control" name="idpaciente" id="idpaciente">
                            </div>
                            <div class="container-fluid">
                                <div class="mx-auto margin" style="width: 200px;">
                                    <button type="submit" name="btEnviar" class="btn btn-primary">Cadastrar Consulta</button>
                                </div>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table table-hover">
                                <thead class="thead-dark">
                                    <tr>
                                        <th scope="col">Data</th>
                                        <th scope="col">Descrição</th>
                                        <th scope="col">Realizada</th>
                                        <th scope="col">Id Medico</th>
                                        <th scope="col">Id Paciente</th>

                                    </tr>
                                </thead>
                                <tbody>

                                    <%
                                        ConsultaDAO consultaDAO = new ConsultaDAO();
                                        ArrayList<Consulta> listaConsulta = consultaDAO.ListaDeConsulta();

                                        for (Consulta consulta : listaConsulta) {
                                            out.println("<tr>");
                                            out.println("<th>" + consulta.getData() + "</th>");
                                            out.println("<th>" + consulta.getDescricao() + "</th>");
                                            out.println("<th>" + consulta.getRealizada() + "</th>");
                                            out.println("<th>" + consulta.getIdmedico() + "</th>");
                                            out.println("<th>" + consulta.getIdpaciente() + "</th>");%>
                                    <%   out.println("</tr>");
                                        }
                                    %>

                                </tbody>
                            </table>
                        </div> 
                </form>
            </div>
        </section>
    </body>
</html>
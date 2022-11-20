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
                        <div class="table-responsive">
                            <table class="table table-hover">
                                <thead class="thead-dark">
                                    <tr>
                                        <th scope="col">Data</th>
                                        <th scope="col">Descrição</th>
                                        <th scope="col">Realizada</th>
                                        <th scope="col">Id Paciente</th>
                                        <th scope="col">Excluir</th>
                                        <th scope="col">Alterar</th>

                                    </tr>
                                </thead>
                                <tbody>

                                    <%
                                        ArrayList<Consulta> listaConsulta = (ArrayList<Consulta>) request.getAttribute("listaConsultas");

                                        for (Consulta consulta : listaConsulta) {
                                            out.println("<tr>");
                                            out.println("<th>" + consulta.getData() + "</th>");
                                            out.println("<th>" + consulta.getDescricao() + "</th>");
                                            out.println("<th>" + consulta.getRealizada() + "</th>");
                                            out.println("<th>" + consulta.getIdpaciente() + "</th>");
                                    %>
                                    
                                     <td><a href="ConsultaServlet?acao=Excluir&id=<%=consulta.getId()%>" type="submit" name="btEnviar" class="btn btn-danger">Excluir</button></td>
                                <td><a href="ConsultaServlet?acao=Alterar&id=<%=consulta.getId()%>" type="submit" name="btEnviar" class="btn btn-warning">Alterar</a></td>
                                    
                                    <%   out.println("</tr>");
                                        }
                                    %>

                                </tbody>
                            </table>
                        </div> 

                    </div>
                </form>
            </div>
        </section>
    </body>
</html>
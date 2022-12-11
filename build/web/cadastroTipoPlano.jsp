<%@page import="java.util.ArrayList"%>
<%@page import="Aplicacao.consulta_exame_descricao.TipoPlano"%>
<%@page import="Model.TipoPlanoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
        <meta content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" name="viewport">
        <title>Cadastro do Tipo do Plano</title>
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
        <section id="formCadastroTipoPlano">
            <h2 style="text-align: center;" class="margin">Cadastro do tipo de um Plano</h2>
            <div class="container-fluid formCadastroTipoPlano">
                <form action="PlanoServlet" method="POST">
                <div class="container">
                    <div class="row">
                        <div class="container-fluid col-lg-8 mx-auto margin">
                            <label for="descricao" class="form-label"><b>Descrição do Tipo do Plano</b></label>
                            <input name="descricao" class="form-control" id="descricao">
                        </div>
                    </div>
                    <div class="mx-auto margin" style="width: 200px;">
                        <button type="submit" name="btEnviar" class="btn btn-primary"><input hidden name ="acao" id="acao" value="cadastrar">Cadastrar</button>
                    </div>
                </div>
                </form>
                <table class="table table-bordereds">
                    <thead>
                        <tr>
                            <th scope="col">Tipos de plano</th>
                            <th scope="col">Excluir</th>
                            <th scope="col">Alterar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            TipoPlanoDAO tipoPlanoDAO = new TipoPlanoDAO();
                            ArrayList<TipoPlano> listaTipoPlanos = tipoPlanoDAO.ListaDeTipoPlano();

                            for (TipoPlano tipoPlano : listaTipoPlanos) {
                                out.println("<tr>");
                                out.println("<th>" + tipoPlano.getDescricao() + "</th>");%>

                    <td><a href="PlanoServlet?acao=Excluir&id=<%=tipoPlano.getId()%>" type="submit" name="btEnviar" class="btn btn-danger">Excluir</button></td>
                    <td><a href="PlanoServlet?acao=Alterar&id=<%=tipoPlano.getId()%>" type="submit" name="btEnviar" class="btn btn-warning">Alterar</a></td>

                    <%   out.println("</tr>");
                        }
                    %>

                    </tbody>
                </table>
            </div>
        </section>
    </body>
</html>
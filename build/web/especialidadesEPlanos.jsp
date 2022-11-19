<%@page import="Model.TipoPlanoDAO"%>
<%@page import="Aplicacao.consulta_exame_descricao.TipoPlano"%>
<%@page import="Model.EspecialidadeDAO"%>
<%@page import="Aplicacao.consulta_exame_descricao.Especialidade"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
    <meta content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" name="viewport">
    <title>Especialidades e planos</title>
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
               <a class="nav-link" href="./cadastroPaciente.jsp">Cadastro</a>  
            </div>
            <div>
               <a class="nav-link" href="./especialidadesEPlanos.jsp">Especialidades e planos</a>  
            </div>
        </nav>
    </header>
    <div class="container-sm margin"> 
                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">Especialidades</th>

                            </tr>
                        </thead>
                        <tbody>
                            
                            <%
                                EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
                                ArrayList<Especialidade> listaEspecialidades = especialidadeDAO.ListaDeEspecialidade();

                                for (Especialidade especialidade : listaEspecialidades) {
                                    out.println("<tr>");
                                    out.println("<th>" + especialidade.getDescricao() + "</th>");%>
                            <%   out.println("</tr>");
                                }
                            %>

                        </tbody>
                    </table>
                </div> 
                            </div>  
                <div class="container-sm margin">
                            <div class="table-responsive">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Tipos de plano</th>

                            </tr>
                        </thead>
                        <tbody>
                            
                            <%
                                TipoPlanoDAO tipoPlanoDAO = new TipoPlanoDAO();
                                ArrayList<TipoPlano> listaTipoPlanos = tipoPlanoDAO.ListaDeTipoPlano();

                                for (TipoPlano tipoPlano : listaTipoPlanos) {
                                    out.println("<tr>");
                                    out.println("<th>" + tipoPlano.getDescricao() + "</th>");%>
                            <%   out.println("</tr>");
                                }
                            %>

                        </tbody>
                    </table>
                </div> 
                </div>
</body>
</html>

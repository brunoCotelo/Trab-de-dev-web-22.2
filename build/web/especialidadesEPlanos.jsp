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
                   <div class="table-responsive">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Especialidade</th>

                            </tr>
                        </thead>
                        <tbody>
                            <%
                                ArrayList<Comentario> listaComentarios = (ArrayList<Comentario>) request.getAttribute("listaComentarios");

                                for (Comentario comentario : listaComentarios) {
                                    out.println("<tr>");
                                    out.println("<th>" + comentario.getId() + "</th>");
                                    out.println("<td>" + comentario.getComentario()+ "</td>");
                                    out.println("<td>" + comentario.getData()+ "</td>");
                                    out.println("<td>" + comentario.getNomeususario()+ "</td>");
                                    out.println("<td>" + comentario.getNomeCategoria()+ "</td>");%>
                        <td><a href="ComentarioController?acao=Alterar&id=<%=comentario.getId()%>" class="btn btn-warning">Alterar</a>
                            <a href="ComentarioController?acao=Excluir&id=<%=comentario.getId()%>" class="btn btn-danger">Excluir</a></td>
                            <%   out.println("</tr>");
                                }
                            %>

                        </tbody>
                    </table>
                </div> 
</body>
</html>

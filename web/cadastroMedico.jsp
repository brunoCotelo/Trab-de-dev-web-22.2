<%@page import="Model.MedicoDAO"%>
<%@page import="Aplicacao.Atores.Medico"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
        <meta content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" name="viewport">
        <title>Cadastro do Médico</title>
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

        <section id="formCadstroMedico">
            <h2 style="text-align: center;" class="margin"> Cadastro de um médico</h2>
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
                            <div class="form-group col-lg-3 mx-auto margin">
                                <label><b>Estado do CRM</b></label>
                                <select name="estadocrm">
                                    <option value="AC">Acre</option>
                                    <option value="AL">Alagoas</option>
                                    <option value="AP">Amapá</option>
                                    <option value="AM">Amazonas</option>
                                    <option value="BA">Bahia</option>
                                    <option value="CE">Ceará</option>
                                    <option value="DF">Distrito Federal</option>
                                    <option value="ES">Espírito Santo</option>
                                    <option value="GO">Goiás</option>
                                    <option value="MA">Maranhão</option>
                                    <option value="MT">Mato Grosso</option>
                                    <option value="MS">Mato Grosso do Sul</option>
                                    <option value="MG">Minas Gerais</option>
                                    <option value="PA">Pará</option>
                                    <option value="PB">Paraíba</option>
                                    <option value="PR">Paraná</option>
                                    <option value="PE">Pernambuco</option>
                                    <option value="PI">Piauí</option>
                                    <option value="RJ">Rio de Janeiro</option>
                                    <option value="RN">Rio Grande do Norte</option>
                                    <option value="RS">Rio Grande do Sul</option>
                                    <option value="RO">Rondônia</option>
                                    <option value="RR">Roraima</option>
                                    <option value="SC">Santa Catarina</option>
                                    <option value="SP">São Paulo</option>
                                    <option value="SE">Sergipe</option>
                                    <option value="TO">Tocantins</option>
                                    <option value="EX">Estrangeiro</option>
                                </select><br><br>
                            </div>
                            <div class="mb-auto col-lg-2 margin">
                                <label for="cpfMedico" class="form-label"><b>CPF</b></label>
                                <input class="form-control" id="inputCPFMedico" placeholder="______.______.______-____">
                            </div>
                            <div class="container-fluid col-lg-2 mx-auto margin">
                                <label for="senhaFuncLogin" class="form-label"><b>Senha</b></label>
                                <input name="senha" type="password" class="form-control" id="inputSenhaFuncLogin">
                            </div>
                            <div class="form-group col-lg-3 mx-auto margin">
                                <label><b>Autorizado</b></label>
                                <select name="autorizado">
                                    <option value="S">Sim</option>
                                    <option value="N">Não</option>
                                </select>
                            </div>
                            <div class="row">
                                <div class="mx-auto margin" style="width: 200px;">
                                    <button type="submit" name="btEnviar" class="btn btn-primary"><input hidden name ="acao" id="acao" value="cadastrar">Cadastrar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">Nome</th>
                                <th scope="col">CRM</th>
                                <th scope="col">Estado do CRM</th>
                                <th scope="col">CPF</th>
                                <th scope="col">Senha</th>
                                <th scope="col">Autorizado</th>
                                <th scope="col">Especialidade</th>
                                <th scope="col">Excluir</th>
                                <th scope="col">Alterar</th>

                            </tr>
                        </thead>
                        <tbody>

                            <%

                                MedicoDAO medicoDAO = new MedicoDAO();
                                ArrayList<Medico> listaMedicos = medicoDAO.ListaDeMedicos();
                                for (Medico medico : listaMedicos) {
                                    out.println("<tr>");
                                    out.println("<th>" + medico.getNome() + "</th>");
                                    out.println("<th>" + medico.getCrm() + "</th>");
                                    out.println("<th>" + medico.getEstadocrm() + "</th>");
                                    out.println("<th>" + medico.getCpf() + "</th>");
                                    out.println("<th>" + medico.getSenha() + "</th>");
                                    out.println("<th>" + medico.getAutorizado() + "</th>");
                                    out.println("<th>" + medico.getIdespecialidade() + "</th>");
                            %>

                        <td><a href="ConsultaServlet?acao=Excluir&id=<%=medico.getId()%>" type="submit" name="btEnviar" class="btn btn-danger">Excluir</button></td>
                        <td><a href="ConsultaServlet?acao=Alterar&id=<%=medico.getId()%>" type="submit" name="btEnviar" class="btn btn-warning">Alterar</a></td>

                        <%   out.println("</tr>");
                            }
                        %>

                        </tbody>
                    </table>
                </div> 
            </div>
        </section>
    </body>
</html>
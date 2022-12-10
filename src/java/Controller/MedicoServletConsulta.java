package Controller;

import Aplicacao.Atores.Medico;
import Aplicacao.Atores.Paciente;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.ConsultaDAO;
import Model.MedicoDAO;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MedicoServletConsulta", urlPatterns = {"/MedicoServletConsulta"})
public class MedicoServletConsulta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = (String) request.getParameter("acao");

        Medico medico = new Medico();
        MedicoDAO medicoDAO = new MedicoDAO();
        RequestDispatcher rd;
        switch (acao) {
            case "Listar":
                try {
                    HttpSession session = request.getSession();
                    Medico usuario = new Medico();
                    usuario = (Medico) session.getAttribute("usuario");
                    ArrayList<Aplicacao.Atores.Medico> listaMedicos = medicoDAO.ListaDeMedicos();
                    request.setAttribute("msgOperacaoRealizada", "");
                    request.setAttribute("listaMedicos", listaMedicos);
                    rd = request.getRequestDispatcher("/cadastroMedico.jsp");
                    rd.forward(request, response);

                } catch (IOException | ServletException ex) {
                    System.out.println(ex.getMessage());
                    throw new RuntimeException("Falha na query listar consultas (Medico) ");
                }
                break;
            //case "Alterar":
            case "Excluir":

                try {
                    int id = Integer.parseInt(request.getParameter("id"));
                    medicoDAO.Excluir(id);
                    request.setAttribute("msgOperacaoRealizada", "Exclusão realizada com sucesso");

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    throw new RuntimeException("Falha em uma query para exclusão de medico");
                }
                break;

        }
        request.setAttribute("medico", medico);
        request.setAttribute("msgError", "");
        request.setAttribute("acao", acao);

        rd = request.getRequestDispatcher("/cadastroMedico.jsp");
        //response.sendRedirect("/BrunoCotelo/menuPaciente.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String data_consulta = request.getParameter("data");
        String descricao_consulta = request.getParameter("descricao");
        String realizada_consulta = request.getParameter("realizada");
        int idmedico_consulta = 2;
        //HttpSession session = request.getSession();
        Paciente paciente = (Paciente) session.getAttribute("usuario");
        int idpaciente_consulta = paciente.getId();
        String acao = request.getParameter("acao");
        RequestDispatcher rd;

//        if(acao == "cadastrar"){
//        
//        }
        if (data_consulta.isEmpty() || idmedico_consulta == 0 || idpaciente_consulta == 0) {
            Medico consulta = new Medico();
            switch (acao) {
                case "cadastrar":
                    request.setAttribute("acao", "cadastrar");
                    break;

//                 case "Alterar":
//                 
//                 case "Excluir": try { ConsultaDAO consultaDAO = new ConsultaDAO(); consulta = consultaDAO.getConsulta(id);
//                 } catch (Exception ex) { System.out.println(ex.getMessage());
//                 throw new RuntimeException("Falha em uma query para cadastro de consulta"); }
//                    break;
                }

            request.setAttribute("msgError", "É necessário preencher todos os campos");
            request.setAttribute("consulta", consulta);

            rd = request.getRequestDispatcher("/menuPaciente.jsp");
            rd.forward(request, response);

        } else {
           // Medico consulta = new Medico(data_consulta, descricao_consulta, realizada_consulta, idmedico_consulta, idpaciente_consulta);
            ConsultaDAO consultaDAO = new ConsultaDAO();
            try {
                switch (acao) {
                    case "cadastrar":
                       // consultaDAO.Inserir(consulta);
                        request.setAttribute("msgOperacaoRealizada", "Inclusão realizada com sucesso");
                        break;
                    case "Alterar":
                      //  consultaDAO.Alterar(consulta);
                        request.setAttribute("msgOperacaoRealizada", "Alteração realizada com sucesso");
                        break;

                }

                ArrayList<Aplicacao.consulta_exame_descricao.Consulta> listaConsultas = consultaDAO.ListaDeConsultaPaciente(idpaciente_consulta);
                request.setAttribute("listaConsultas", listaConsultas);
                rd = request.getRequestDispatcher("/menuPaciente.jsp");
                rd.forward(request, response);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException("Falha em uma query para cadastro de consulta");
            }
        }
    }

}

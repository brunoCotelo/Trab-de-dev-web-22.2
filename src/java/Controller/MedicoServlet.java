package Controller;

import Aplicacao.Atores.Medico;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.MedicoDAO;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MedicoServlet", urlPatterns = {"/MedicoServlet"})
public class MedicoServlet extends HttpServlet {

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
                    ArrayList<Aplicacao.Atores.Medico> listaMedicos = medicoDAO.ListaDeMedicos();
                    request.setAttribute("msgOperacaoRealizada", "");
                    request.setAttribute("listaMedicos", listaMedicos);
                    rd = request.getRequestDispatcher("/cadastroMedico.jsp");
                    rd.forward(request, response);

                } catch (IOException | ServletException ex) {
                    System.out.println(ex.getMessage());
                    throw new RuntimeException("Falha na query listar medicos (Medico) ");
                }
                break;
            case "Alterar":
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

        String nome_user = request.getParameter("nome");
        int crm_user = Integer.parseInt(request.getParameter("crm"));
        String estadocrm_user = request.getParameter("estadocrm");
        String cpf_user = request.getParameter("cpf");
        String senha_user = request.getParameter("senha");
        String autorizado_user = request.getParameter("autorizado");
        int especialidade_user = Integer.parseInt(request.getParameter("especialidade"));
        String acao = request.getParameter("acao");
        RequestDispatcher rd;

//        if(acao == "cadastrar"){
//        
//        }
        if (nome_user.isEmpty() || crm_user == 0 || cpf_user.isEmpty() || estadocrm_user.isEmpty() || senha_user.isEmpty() || autorizado_user.isEmpty() || especialidade_user == 0) {
            Medico medico = new Medico();
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
            request.setAttribute("medico", medico);

            rd = request.getRequestDispatcher("/cadastroMedico.jsp");
            rd.forward(request, response);

        } else {
            Medico medico = new Medico(nome_user, crm_user, estadocrm_user, cpf_user, senha_user, autorizado_user, especialidade_user);
            MedicoDAO medicoDAO = new MedicoDAO();
            try {
                switch (acao) {
                    case "cadastrar":
                        medicoDAO.Inserir(medico);
                        request.setAttribute("msgOperacaoRealizada", "Inclusão realizada com sucesso");
                        break;
                    case "Alterar":
                        medicoDAO.Alterar(medico);
                        request.setAttribute("msgOperacaoRealizada", "Alteração realizada com sucesso");
                        break;
//                    case "Excluir":
//                        medicoDAO.Excluir(id);
//                        request.setAttribute("msgOperacaoRealizada", "Exclusão realizada com sucesso");
//                        break;

                }

                ArrayList<Aplicacao.Atores.Medico> listaMedicos = medicoDAO.ListaDeMedicos();
                request.setAttribute("listaMedicos", listaMedicos);
                rd = request.getRequestDispatcher("/cadastroMedico.jsp");
                rd.forward(request, response);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException("Falha em uma query para cadastro de medico");
            }
        }
    }

}

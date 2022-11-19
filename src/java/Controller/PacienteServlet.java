package Controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.PacienteDAO;
import Aplicacao.Atores.Paciente;
import javax.servlet.RequestDispatcher;


@WebServlet(name = "PacienteServlet", urlPatterns = {"/PacienteServlet"})
public class PacienteServlet extends HttpServlet {

    
    
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String acao = (String) request.getParameter("acao");
//
//        Paciente paciente = new Paciente();
//        PacienteDAO pacienteDAO = new PacienteDAO();
//        RequestDispatcher rd;
//        switch (acao) {
//            case "Listar":
//                try {
//                    ArrayList<Aplicacao.Atores.Paciente> listaPacientes = pacienteDAO.ListaDePacientes();
//                    request.setAttribute("msgOperacaoRealizada", "");
//                    request.setAttribute("listaPacientes", listaPacientes);
//                    rd = request.getRequestDispatcher("/view/paciente/listaPacientes.jsp");
//                    rd.forward(request, response);
//
//                } catch (IOException | ServletException ex) {
//                    System.out.println(ex.getMessage());
//                    throw new RuntimeException("Falha na query listar pacientes (Paciente) ");
//                }
//                break;
//            case "Alterar":
//            case "Excluir":
//                try {
//                    int id = Integer.parseInt(request.getParameter("id"));
//                    paciente = pacienteDAO.getPacienteById(id);
//                    paciente.setId(id);
//                } catch (Exception ex) {
//                    System.out.println(ex.getMessage());
//                    throw new RuntimeException("Falha em uma query para cadastro de paciente");
//                }
//                break;
//
//        }
//        request.setAttribute("paciente", paciente);
//        request.setAttribute("msgError", "");
//        request.setAttribute("acao", acao);
//
//        rd = request.getRequestDispatcher("/view/paciente/formPaciente.jsp");
//        rd.forward(request, response);
//
//    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome_user = request.getParameter("nome");
        String cpf_user = request.getParameter("cpf");
        String senha_user = request.getParameter("senha");
        String autorizado_user = request.getParameter("autorizado");
        String acao = request.getParameter("acao");

        RequestDispatcher rd;

        if (nome_user.isEmpty() || cpf_user.isEmpty() || senha_user.isEmpty() || autorizado_user.isEmpty()) {
            Paciente paciente = new Paciente();
            switch (acao) {
                case "cadastrar":
                    request.setAttribute("acao", "cadastrar");
                    break;
                /**
                 * case "Alterar": case "Excluir": try { PacienteDAO pacienteDAO
                 * = new PacienteDAO(); paciente = pacienteDAO.getPaciente(id);
                 * } catch (Exception ex) { System.out.println(ex.getMessage());
                 * throw new RuntimeException("Falha em uma query para cadastro
                 * de paciente"); }
                    break;*
                 */
            }

            request.setAttribute("msgError", "É necessário preencher todos os campos");
            request.setAttribute("paciente", paciente);

            rd = request.getRequestDispatcher("/cadastroPaciente.jsp");
            rd.forward(request, response);

        } else {

            Paciente paciente = new Paciente(nome_user, cpf_user, senha_user, autorizado_user);
            //paciente.setId(id);
            PacienteDAO pacienteDAO = new PacienteDAO();
            try {
                switch (acao) {
                    case "cadastrar":
                        pacienteDAO.Inserir(paciente);
                        request.setAttribute("msgOperacaoRealizada", "Inclusão realizada com sucesso");
                        break;
//                    case "Alterar":
//                        pacienteDAO.Alterar(paciente);
//                        request.setAttribute("msgOperacaoRealizada", "Alteração realizada com sucesso");
//                        break;
//                    case "Excluir":
//                        pacienteDAO.Excluir(paciente);
//                        request.setAttribute("msgOperacaoRealizada", "Exclusão realizada com sucesso");
//                        break;
                }

                ArrayList<Aplicacao.Atores.Paciente> listaPacientes = pacienteDAO.ListaDePacientes();
                request.setAttribute("listaPacientes", listaPacientes);
                rd = request.getRequestDispatcher("/login.jsp");
                rd.forward(request, response);
                
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException("Falha em uma query para cadastro de paciente");
            }
        }
    }
}

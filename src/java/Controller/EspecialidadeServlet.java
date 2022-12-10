package Controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Aplicacao.consulta_exame_descricao.Especialidade;
import Model.EspecialidadeDAO;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EspecialidadeServlet", urlPatterns = {"/EspecialidadeServlet"})
public class EspecialidadeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = (String) request.getParameter("acao");

        Especialidade especialidade = new Especialidade();
        EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
        RequestDispatcher rd;
        switch (acao) {
            case "Listar":
                try {
//                    HttpSession session = request.getSession();
//                    Paciente usuario = new Paciente();
//                    usuario = (Paciente) session.getAttribute("usuario");
                    ArrayList<Aplicacao.consulta_exame_descricao.Especialidade> listaEspecialidade = especialidadeDAO.ListaDeEspecialidade();
                    request.setAttribute("msgOperacaoRealizada", "");
                    request.setAttribute("listaEspecialidade", listaEspecialidade);
                    rd = request.getRequestDispatcher("/cadastroEspecialidade.jsp");
                    rd.forward(request, response);

                } catch (IOException | ServletException ex) {
                    System.out.println(ex.getMessage());
                    throw new RuntimeException("Falha na query listar tipos de plano (Tipoplano) ");
                }
                break;
            //case "Alterar":
            case "Excluir":

                try {
                    int id = Integer.parseInt(request.getParameter("id"));
                    especialidadeDAO.Excluir(id);
                    request.setAttribute("msgOperacaoRealizada", "Exclusão realizada com sucesso");

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    throw new RuntimeException("Falha em uma query para exclusão de especialidade");
                }
                break;

        }
        request.setAttribute("especialidade", especialidade);
        request.setAttribute("msgError", "");
        request.setAttribute("acao", acao);

        rd = request.getRequestDispatcher("/cadastroEspecialidade.jsp");
        //response.sendRedirect("/BrunoCotelo/menuPaciente.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String descricao_especialidade = request.getParameter("descricao");
        //HttpSession session = request.getSession();
        
        String acao = request.getParameter("acao");
        RequestDispatcher rd;

//        if(acao == "cadastrar"){
//        
//        }
        if (descricao_especialidade.isEmpty()) {
            Especialidade especialidade = new Especialidade();
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
            request.setAttribute("especialidade", especialidade);

            rd = request.getRequestDispatcher("/cadastroEspecialidade.jsp");
            rd.forward(request, response);

        } else {
            Especialidade especialidade = new Especialidade(descricao_especialidade);
            EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
            try {
                switch (acao) {
                    case "cadastrar":
                        especialidadeDAO.Inserir(especialidade);
                        request.setAttribute("msgOperacaoRealizada", "Inclusão realizada com sucesso");
                        break;
                    case "Alterar":
                        especialidadeDAO.Alterar(especialidade);
                        request.setAttribute("msgOperacaoRealizada", "Alteração realizada com sucesso");
                        break;

                }

                ArrayList<Aplicacao.consulta_exame_descricao.Especialidade> listaEspecialidade = especialidadeDAO.ListaDeEspecialidade();
                request.setAttribute("listaEspecialidade", listaEspecialidade);
                rd = request.getRequestDispatcher("/cadastroEspecialidade.jsp");
                rd.forward(request, response);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException("Falha em uma query para cadastro de especialidade");
            }
        }
    }

}

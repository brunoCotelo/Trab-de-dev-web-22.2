package Controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Aplicacao.consulta_exame_descricao.TipoPlano;
import Model.TipoPlanoDAO;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

@WebServlet(name = "PlanoServlet", urlPatterns = {"/PlanoServlet"})
public class PlanoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = (String) request.getParameter("acao");

        TipoPlano tipoPlano = new TipoPlano();
        TipoPlanoDAO tipoPlanoDAO = new TipoPlanoDAO();
        RequestDispatcher rd;
        switch (acao) {
            case "Listar":
                try {
//                    HttpSession session = request.getSession();
//                    Paciente usuario = new Paciente();
//                    usuario = (Paciente) session.getAttribute("usuario");
                    ArrayList<Aplicacao.consulta_exame_descricao.TipoPlano> listaTipoPlano = tipoPlanoDAO.ListaDeTipoPlano();
                    request.setAttribute("msgOperacaoRealizada", "");
                    request.setAttribute("listaTipoPlano", listaTipoPlano);
                    rd = request.getRequestDispatcher("/cadastroTipoPlano.jsp");
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
                    tipoPlanoDAO.Excluir(id);
                    request.setAttribute("msgOperacaoRealizada", "Exclusão realizada com sucesso");

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    throw new RuntimeException("Falha em uma query para exclusão de tipo de plano");
                }
                break;

        }
        request.setAttribute("tipoplano", tipoPlano);
        request.setAttribute("msgError", "");
        request.setAttribute("acao", acao);

        rd = request.getRequestDispatcher("/cadastroTipoPlano.jsp");
        //response.sendRedirect("/BrunoCotelo/menuPaciente.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String descricao_tipoPlano = request.getParameter("descricao");
        //HttpSession session = request.getSession();
        
        String acao = request.getParameter("acao");
        RequestDispatcher rd;

//        if(acao == "cadastrar"){
//        
//        }
        if (descricao_tipoPlano.isEmpty()) {
            TipoPlano tipoPlano = new TipoPlano();
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
            request.setAttribute("tipoPlano", tipoPlano);

            rd = request.getRequestDispatcher("/cadastroTipoPlano.jsp");
            rd.forward(request, response);

        } else {
            TipoPlano tipoPlano = new TipoPlano(descricao_tipoPlano);
            TipoPlanoDAO tipoPlanoDAO = new TipoPlanoDAO();
            try {
                switch (acao) {
                    case "cadastrar":
                        tipoPlanoDAO.Inserir(tipoPlano);
                        request.setAttribute("msgOperacaoRealizada", "Inclusão realizada com sucesso");
                        break;
                    case "Alterar":
                        tipoPlanoDAO.Alterar(tipoPlano);
                        request.setAttribute("msgOperacaoRealizada", "Alteração realizada com sucesso");
                        break;

                }

                ArrayList<Aplicacao.consulta_exame_descricao.TipoPlano> listaTipoPlano = tipoPlanoDAO.ListaDeTipoPlano();
                request.setAttribute("listaTipoPlano", listaTipoPlano);
                rd = request.getRequestDispatcher("/cadastroTipoPlano.jsp");
                rd.forward(request, response);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException("Falha em uma query para cadastro de consulta");
            }
        }
    }

}

package Controller;

import Aplicacao.Atores.Administrador;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.AdmDAO;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AdmServlet", urlPatterns = {"/AdmServlet"})
public class AdmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = (String) request.getParameter("acao");

        Administrador administrador = new Administrador();
        AdmDAO administradorDAO = new AdmDAO();
        RequestDispatcher rd;
        switch (acao) {
            case "Listar":
                try {
                    ArrayList<Aplicacao.Atores.Administrador> listaAdministradors = administradorDAO.ListaDeAdministradores();
                    request.setAttribute("msgOperacaoRealizada", "");
                    request.setAttribute("listaAdministradors", listaAdministradors);
                    rd = request.getRequestDispatcher("/cadastroAdministrador.jsp");
                    rd.forward(request, response);

                } catch (IOException | ServletException ex) {
                    System.out.println(ex.getMessage());
                    throw new RuntimeException("Falha na query listar administradors (Administrador) ");
                }
                break;
            case "Alterar":
            case "Excluir":

                try {
                    int id = Integer.parseInt(request.getParameter("id"));
                    administradorDAO.Excluir(id);
                    request.setAttribute("msgOperacaoRealizada", "Exclusão realizada com sucesso");

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    throw new RuntimeException("Falha em uma query para exclusão de administrador");
                }
                break;

        }
        request.setAttribute("administrador", administrador);
        request.setAttribute("msgError", "");
        request.setAttribute("acao", acao);

        rd = request.getRequestDispatcher("/cadastroAdministrador.jsp");
        //response.sendRedirect("/BrunoCotelo/menuPaciente.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String nome_user = request.getParameter("nome");
        String cpf_user = request.getParameter("cpf");
        String senha_user = request.getParameter("senha");
        String acao = request.getParameter("acao");
        RequestDispatcher rd;

//        if(acao == "cadastrar"){
//        
//        }
        if (nome_user.isEmpty() || cpf_user.isEmpty() || senha_user.isEmpty()) {
            Administrador administrador = new Administrador();
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
            request.setAttribute("administrador", administrador);

            rd = request.getRequestDispatcher("/cadastroAdministrador.jsp");
            rd.forward(request, response);

        } else {
            Administrador administrador = new Administrador(nome_user, cpf_user, senha_user);
            AdmDAO administradorDAO = new AdmDAO();
            try {
                switch (acao) {
                    case "cadastrar":
                        administradorDAO.Inserir(administrador);
                        request.setAttribute("msgOperacaoRealizada", "Inclusão realizada com sucesso");
                        break;
                    case "Alterar":
                        administradorDAO.Alterar(administrador);
                        request.setAttribute("msgOperacaoRealizada", "Alteração realizada com sucesso");
                        break;
//                    case "Excluir":
//                        administradorDAO.Excluir(id);
//                        request.setAttribute("msgOperacaoRealizada", "Exclusão realizada com sucesso");
//                        break;

                }

                ArrayList<Aplicacao.Atores.Administrador> listaAdministradors = administradorDAO.ListaDeAdministradores();
                request.setAttribute("listaAdministradors", listaAdministradors);
                rd = request.getRequestDispatcher("/cadastroAdministrador.jsp");
                rd.forward(request, response);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException("Falha em uma query para cadastro de administrador");
            }
        }
    }

}

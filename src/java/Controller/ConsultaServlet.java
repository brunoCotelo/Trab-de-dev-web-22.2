package Controller;

import Aplicacao.Atores.Paciente;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.ConsultaDAO;
import Aplicacao.consulta_exame_descricao.Consulta;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ConsultaServlet", urlPatterns = {"/ConsultaServlet"})
public class ConsultaServlet extends HttpServlet {

    
    
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String acao = (String) request.getParameter("acao");
//
//        Consulta consulta = new Consulta();
//        ConsultaDAO consultaDAO = new ConsultaDAO();
//        RequestDispatcher rd;
//        switch (acao) {
//            case "Listar":
//                try {
//                    ArrayList<Aplicacao.consulta_exame_descricao.Consulta> listaConsultas = consultaDAO.ListaDeConsulta();
//                    request.setAttribute("msgOperacaoRealizada", "");
//                    request.setAttribute("listaConsultas", listaConsultas);
//                    rd = request.getRequestDispatcher("/view/consulta/listaConsultas.jsp");
//                    rd.forward(request, response);
//
//                } catch (IOException | ServletException ex) {
//                    System.out.println(ex.getMessage());
//                    throw new RuntimeException("Falha na query listar consultas (Consulta) ");
//                }
//                break;
//            case "Alterar":
//            case "Excluir":
//                try {
//                    int id = Integer.parseInt(request.getParameter("id"));
//                    consulta = consultaDAO.getConsulta(id);
//                    consulta.setId(id);
//                } catch (Exception ex) {
//                    System.out.println(ex.getMessage());
//                    throw new RuntimeException("Falha em uma query para cadastro de consulta");
//                }
//                break;
//
//        }
//        request.setAttribute("consulta", consulta);
//        request.setAttribute("msgError", "");
//        request.setAttribute("acao", acao);
//
//        rd = request.getRequestDispatcher("/view/consulta/formConsulta.jsp");
//        rd.forward(request, response);

//    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String data_consulta = request.getParameter("data");
        String descricao_consulta = request.getParameter("descricao");
        String realizada_consulta = request.getParameter("realizada");
        int idmedico_consulta = Integer.parseInt(request.getParameter("idmedico"));
        HttpSession session = request.getSession();
        Paciente paciente = (Paciente) session.getAttribute("usuario");
        int idpaciente_consulta = paciente.getId();
        String acao = request.getParameter("acao");
        
        RequestDispatcher rd;
        
        if(acao == "cadastrar"){
        
        }

        if (data_consulta.isEmpty() || descricao_consulta.isEmpty() || realizada_consulta.isEmpty() || idmedico_consulta == 0 || idpaciente_consulta == 0){
            Consulta consulta = new Consulta();
            switch (acao) {
                case "cadastrar":
                    request.setAttribute("acao", "cadastrar");
                    break;
                
//                 case "Alterar": case "Excluir": try { ConsultaDAO consultaDAO = new ConsultaDAO(); consulta = consultaDAO.getConsulta(id);
//                 } catch (Exception ex) { System.out.println(ex.getMessage());
//                 throw new RuntimeException("Falha em uma query para cadastro de consulta"); }
//                    break;
            }

            request.setAttribute("msgError", "É necessário preencher todos os campos");
            request.setAttribute("consulta", consulta);

            rd = request.getRequestDispatcher("/menuMedicoConsulta.jsp");
            rd.forward(request, response);

        } 
        else {
            Consulta consulta = new Consulta(data_consulta, descricao_consulta, realizada_consulta, idmedico_consulta, idpaciente_consulta);
            ConsultaDAO consultaDAO = new ConsultaDAO();
            try {
                switch (acao) {
                    case "cadastrar":
                        consultaDAO.Inserir(consulta);
                        System.out.println(consultaDAO);
                        request.setAttribute("msgOperacaoRealizada", "Inclusão realizada com sucesso");
                        break;
//                    case "Alterar":
//                        consultaDAO.Alterar(consulta);
//                        request.setAttribute("msgOperacaoRealizada", "Alteração realizada com sucesso");
//                        break;
//                    case "Excluir":
//                        consultaDAO.Excluir(consulta);
//                        request.setAttribute("msgOperacaoRealizada", "Exclusão realizada com sucesso");
//                        break;
                }

                System.out.println("chegou antes do array");
                ArrayList<Aplicacao.consulta_exame_descricao.Consulta> listaConsultas = consultaDAO.ListaDeConsulta();
                request.setAttribute("listaConsultas", listaConsultas);
                rd = request.getRequestDispatcher("/menuMedicoConsulta.jsp");
                rd.forward(request, response);
                
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException("Falha em uma query para cadastro de consulta");
            }
        }
    }
}

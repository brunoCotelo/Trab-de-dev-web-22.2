package Controller;

import Aplicacao.Atores.Administrador;
import Aplicacao.Atores.Medico;
import Aplicacao.Atores.Paciente;
import Aplicacao.Atores.TipoPerfil;
import Aplicacao.consulta_exame_descricao.Consulta;
import Model.AdmDAO;
import Model.ConsultaDAO;
import Model.MedicoDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.PacienteDAO;
import java.util.ArrayList;

@WebServlet(name = "Autentica", urlPatterns = {"/Autentica"})
public class Autentica extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = (String) request.getParameter("acao");
        RequestDispatcher rd;
        switch (acao) {
            case "Login":  // chama form de login

                rd = request.getRequestDispatcher("/../../login.jsp");
                rd.forward(request, response);

                break;
            case "Logout":
                HttpSession session = request.getSession();
                session.invalidate();
                rd = request.getRequestDispatcher("/../../login.jsp");
                rd.forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd;
        // pegando os parâmetros do request
        String cpf_user = request.getParameter("cpf");
        String senha_user = request.getParameter("senha");
        String perfil = request.getParameter("roles");
        TipoPerfil perfill = TipoPerfil.getPerfil(Integer.parseInt(perfil));
        if (cpf_user.isEmpty() || senha_user.isEmpty()) {
            // dados não foram preenchidos retorna ao formulário
            request.setAttribute("msgError", "Usuário e/ou senha incorreto");
            rd = request.getRequestDispatcher("/../../login.jsp");
            rd.forward(request, response);
        } else {
            //trocar o else por um case onde cada switch é um perfil
            switch (perfill) {

                case PACIENTE:
                    Paciente usuarioObtido = new Paciente();
                    Paciente usuario = new Paciente(cpf_user, senha_user);
                    PacienteDAO usuarioDAO = new PacienteDAO();
                    try {
                        usuarioObtido = usuarioDAO.Logar(usuario);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                        throw new RuntimeException("Falha na query para Logar");
                    }

                    if (usuarioObtido.getId() != 0) {
                        HttpSession session = request.getSession();
                        session.setAttribute("usuario", usuarioObtido);
                        session.setAttribute("perfil", usuarioObtido.getPerfil());
                        ConsultaDAO consultaDAO = new ConsultaDAO();
                        ArrayList<Consulta> listaConsultas = consultaDAO.ListaDeConsultaPaciente(usuarioObtido.getId());
                        request.setAttribute("msgOperacaoRealizada", "");
                        request.setAttribute("listaConsultas", listaConsultas);
                        rd = request.getRequestDispatcher("/menuPaciente.jsp");
                        rd.forward(request, response);

                    } else {
                        request.setAttribute("msgError", "Usuário e/ou senha incorreto");
                        rd = request.getRequestDispatcher("/login.jsp");
                        rd.forward(request, response);

                    }
                    break;

                case MEDICO:  //trocar para medico
                    Medico usuarioObtido1;
                    MedicoDAO usuarioDAO1 = new MedicoDAO();
                    try {
                        usuarioObtido1 = usuarioDAO1.Logar(cpf_user, senha_user);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                        throw new RuntimeException("Falha na query para Logar");
                    }

                    if (usuarioObtido1 != null) {
                        HttpSession session = request.getSession();
                        session.setAttribute("usuario", usuarioObtido1);
                        session.setAttribute("perfil", usuarioObtido1.getPerfil());
                        ConsultaDAO consultaDAO = new ConsultaDAO();
                        ArrayList<Consulta> listaConsultas = consultaDAO.ListaDeConsultaMedico(usuarioObtido1.getId());
                    request.setAttribute("msgOperacaoRealizada", "");
                        request.setAttribute("listaConsultas", listaConsultas);
                        rd = request.getRequestDispatcher("/menuMedicoConsulta.jsp");
                        rd.forward(request, response);

                    } else {
                        request.setAttribute("msgError", "Usuário e/ou senha incorreto");
                        rd = request.getRequestDispatcher("/login.jsp");
                        rd.forward(request, response);

                    }
                    break;
                case ADMINISTRADOR:   //trocar para adm
                    Administrador usuarioObtido2;
                    AdmDAO usuarioDAO2 = new AdmDAO();
                    try {
                        usuarioObtido2 = usuarioDAO2.Logar(cpf_user, senha_user);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                        throw new RuntimeException("Falha na query para Logar");
                    }

                    if (usuarioObtido2 != null) {
                        HttpSession session = request.getSession();
                        session.setAttribute("usuario", usuarioObtido2);
                        session.setAttribute("perfil", usuarioObtido2.getPerfil());
                        //ConsultaDAO consultaDAO = new ConsultaDAO();
                        //ArrayList<Consulta> listaConsultas = consultaDAO.ListaDeConsultaAdm(usuarioObtido2.getId());
                        request.setAttribute("msgOperacaoRealizada", "");
                        //request.setAttribute("listaConsultas", listaConsultas);
                        rd = request.getRequestDispatcher("/menuAdm.jsp");
                        rd.forward(request, response);

                    } else {
                        request.setAttribute("msgError", "Usuário e/ou senha incorreto");
                        rd = request.getRequestDispatcher("/login.jsp");
                        rd.forward(request, response);

                    }
                    break;
            }
        }
    }

}

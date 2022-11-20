package Controller;

import Aplicacao.Atores.Medico;
import Aplicacao.Atores.Paciente;
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
        if (cpf_user.isEmpty() || senha_user.isEmpty()) {
            // dados não foram preenchidos retorna ao formulário
            request.setAttribute("msgError", "Usuário e/ou senha incorreto");
            rd = request.getRequestDispatcher("/../../login.jsp");
            rd.forward(request, response);
        } else {
            //trocar o else por um case onde cada switch é um perfil
            switch (perfil) {

                case "0":
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
                        rd = request.getRequestDispatcher("/menuPaciente.jsp");
                        rd.forward(request, response);

                    } else {
                        request.setAttribute("msgError", "Usuário e/ou senha incorreto");
                        rd = request.getRequestDispatcher("/login.jsp");
                        rd.forward(request, response);

                    }
                    break;

                case "1":  //trocar para medico
                    Medico usuarioObtido1 = new Medico();
                    Medico usuario1 = new Medico(cpf_user, senha_user);
                    MedicoDAO usuarioDAO1 = new MedicoDAO();
                    try {
                        usuarioObtido1 = usuarioDAO1.Logar(usuario1);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                        throw new RuntimeException("Falha na query para Logar");
                    }

                    if (usuarioObtido1.getId() != 0) {
                        HttpSession session = request.getSession();
                        session.setAttribute("usuario", usuarioObtido1);
                        session.setAttribute("perfil", usuarioObtido1.getPerfil());
                        rd = request.getRequestDispatcher("/menuMedicoConsulta.jsp");
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

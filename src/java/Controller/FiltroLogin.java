package controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import Aplicacao.Atores.Paciente;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "filtro", urlPatterns = {"/*"})
public class FiltroLogin implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        String uri = ((HttpServletRequest) request).getRequestURI();
        // aqui os servlets da parte pública que não precisa de login
        // e os CSS e JS necessários
        if ((uri.equals("/exemploMVC/"))
                || (uri.contains("/bootstrap"))
                || (uri.contains("/css"))
                || (uri.contains("/imagens"))
                || (uri.contains("/listaDeEspecialidades"))
                || (uri.contains("/login"))
                || (uri.contains("/index"))
                || (uri.contains("/cadastroPaciente"))) 
                {
            chain.doFilter((HttpServletRequest) request, (HttpServletResponse) response);
        } else {
            // se a área necessita de login verifica se o usuário está na sessão - está logado
            Paciente paciente = (Paciente) ((HttpServletRequest) request).getSession().getAttribute("paciente");
            if ((paciente != null) && (!((String) paciente.getNome()).isEmpty())) {
                chain.doFilter((HttpServletRequest) request, (HttpServletResponse) response);
            } else {
                ((HttpServletRequest) request).setAttribute("msgError", "É necessário fazer login");
                
                RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                rd.forward(request, response);

            }
        }

    }

    public void init(FilterConfig arg0) throws ServletException {
    }

    public void destroy() {
    }

}

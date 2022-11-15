package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"pt-br\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("    <meta content=\"width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no\" name=\"viewport\">\r\n");
      out.write("    <title>Login</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body style=\"background-color: rgb(210, 240, 245);\">\r\n");
      out.write("    <header>\r\n");
      out.write("        <nav class=\"navbar navbar-light bg-faded\" style=\"background-color: rgb(0, 0, 0); border-color: #000; justify-content: normal;\">\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">\r\n");
      out.write("                <img src=\"imagens/download.png\" width=\"100\" height=\"100\">\r\n");
      out.write("            </a>\r\n");
      out.write("            <div>\r\n");
      out.write("                <a class=\"nav-link\" href=\"./login.jsp\">Login</a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div>\r\n");
      out.write("               <a class=\"nav-link\" href=\"./cadastroPaciente.jsp\">Cadastro</a>  \r\n");
      out.write("            </div>\r\n");
      out.write("            <div>\r\n");
      out.write("               <a class=\"nav-link\" href=\"./listaDeEspecialidades.jsp\">Especialidades</a>  \r\n");
      out.write("            </div>\r\n");
      out.write("            <div>\r\n");
      out.write("                <a class=\"nav-link\" href=\"./menuPaciente.jsp\">Menu paciente</a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div>\r\n");
      out.write("                <a class=\"nav-link\" href=\"./menuMedicoConsulta.jsp\">Menu médico</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("    </header>\r\n");
      out.write("    <section id=\"formLogin\">\r\n");
      out.write("        <h2 style=\"text-align: center;\" class=\"margin\">Login no sistema</h2>\r\n");
      out.write("        <div class=\"container-fluid formLogin\">\r\n");
      out.write("            <form  action=\"/login\" method=\"post\">\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"container-fluid col-lg-3 mx-auto margin\">\r\n");
      out.write("                            <label for=\"CPFFuncLogin\" class=\"form-label\"><b>CPF</b></label>\r\n");
      out.write("                            <input name=\"cpf\" class=\"form-control\" id=\"inputCPFFuncLogin\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"container-fluid col-lg-3 mx-auto margin\">\r\n");
      out.write("                            <label for=\"senhaFuncLogin\" class=\"form-label\"><b>Senha</b></label>\r\n");
      out.write("                            <input name=\"senha\" type=\"password\" class=\"form-control\" id=\"inputSenhaFuncLogin\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group col-lg-3 mx-auto margin\">\r\n");
      out.write("                        <label><b>Selecione a especialidade</b></label>\r\n");
      out.write("                        <select name=\"roles\">\r\n");
      out.write("                            <option value=\"paciente\">Paciente</option>\r\n");
      out.write("                            <option value=\"medico\">Médico</option>\r\n");
      out.write("                            <option value=\"adm\">Administrador</option>\r\n");
      out.write("                        </select><br><br>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"container-fluid\">\r\n");
      out.write("                        <div class=\"mx-auto margin\" style=\"width: 200px;\">\r\n");
      out.write("                            <input type=\"submit\" value=\"Fazer login\" class=\"btn btn-primary\"/>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"mx-auto margin\" style=\"width: 200px;\">\r\n");
      out.write("                            <a class=\"btn btn-primary\" href=\"./cadastroPaciente.jsp\" role=\"button\">Cadastre-se</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </section>\r\n");
      out.write("</body>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

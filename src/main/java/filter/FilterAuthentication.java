package filter;

import connection.SingleConnection;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import utils.Message;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter(urlPatterns = {"/main/*"}) //Intercepta todas as requisições que vierem do projeto ou mapeamento
public class FilterAuthentication implements Filter {
    //Encerra os processos quando o servidor é parado

    private static Connection CONNECTION;

    //Encerraria o processo com a conexão com o banco
    public void destroy() {
        try {
            CONNECTION.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }
    //Incia os processos ou recursos quando o servidor sobe o projeto
    //ex. iniciar a conexão com o banco
    public void init(FilterConfig config) throws ServletException {
        CONNECTION = SingleConnection.getConnection();
    }

    //Intercepta as requisições e a respostas do sistema
    //Tudo o que fizermos do sistema irá passar pelo metodo doFilter()
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        try {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpSession hasSession = req.getSession();

            String userLogged = (String) hasSession.getAttribute("user");
            String userRegister = (String) hasSession.getAttribute("userRegister");

            String urlAuthenticate = req.getServletPath();//URL está sendo acessado

            if (userLogged == null && !urlAuthenticate.equalsIgnoreCase("/main/ServletLogin")) { //Não está logado

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp?url=" + urlAuthenticate);
                request.setAttribute("message", Message.MESSAGE_AUTHENTICATE);

                requestDispatcher.forward(request, response);


                return; // Para a execução e redireciona para o login
            }
            if (userRegister == null && !urlAuthenticate.equalsIgnoreCase("/main/ServletRegister")) {
                RequestDispatcher requestRegister = request.getRequestDispatcher("/register.jsp?url=" + urlAuthenticate);
                requestRegister.forward(request, response);
                return;
            }


            else {
                chain.doFilter(request, response);
            }
            CONNECTION.commit();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                CONNECTION.rollback();
            } catch (Exception roll) {
                roll.printStackTrace();
            }
        }
    }
}

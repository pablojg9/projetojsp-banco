package servlets;

import java.io.IOException;

import dao.LoginDaoRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Login;
import utils.Message;

@WebServlet(urlPatterns = {"/main/ServletLogin", "/ServletLogin"})
public class ServletLogin extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private LoginDaoRepository loginDaoRepository = new LoginDaoRepository();

    public ServletLogin() {

    }

    // Recebe os dados pela url em parametros
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    // Recebe os dados enviados por um formulario
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String url = request.getParameter("url");

            if (login != null && !login.isEmpty() && password != null && !password.isEmpty()) {
                Login modelLogin = new Login();
                modelLogin.setLogin(login);
                modelLogin.setPassword(password);

                RequestDispatcher requestDispatcher;

                if (loginDaoRepository.validateAuthentication(modelLogin)) {
                    request.getSession().setAttribute("user", modelLogin.getLogin());

                    request.setAttribute("msg", Message.MESSAGE_SUCCESS_REGISTER);


                    if (url == null || url.equals("null")) {
                        url = "main/main.jsp";
                    }
                    requestDispatcher = request.getRequestDispatcher(url);
                    requestDispatcher.forward(request, response);

                } else {
                    requestDispatcher = request.getRequestDispatcher("/index.jsp");
                    request.setAttribute("message", Message.MESSAGE_ERROR);
                }
                requestDispatcher.forward(request, response);

            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
                request.setAttribute("message", Message.MESSAGE_ERROR);
                requestDispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.jsp");
            request.setAttribute("message", e.getMessage());
            requestDispatcher.forward(request, response);

        }
    }
}

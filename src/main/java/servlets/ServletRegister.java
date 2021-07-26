package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Login;
import utils.Message;

import java.io.IOException;

@WebServlet(urlPatterns = {"/main/ServletRegister", "/ServletRegister"})
public class ServletRegister extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginRegister = request.getParameter("loginRegister");
        String passwordRegister = request.getParameter("passwordRegister");
        String url = request.getParameter("url");


        if (loginRegister != null && !loginRegister.isEmpty() && passwordRegister != null && !passwordRegister.isEmpty()) {
            //Instancias
            Login modelLogin = new Login();
            UserDao userDao = new UserDao();

            modelLogin.setLogin(loginRegister);
            modelLogin.setPassword(passwordRegister);

            RequestDispatcher requestDispatcher;

            if (modelLogin.getLogin().equalsIgnoreCase("admin") && modelLogin.getPassword()
                    .equalsIgnoreCase("admin")) {
                request.getSession().setAttribute("userRegister", modelLogin.getLogin());

                if (url == null || url.equals("null")) {
                    url = "/index.jsp";
                }

                requestDispatcher = request.getRequestDispatcher(url);
                requestDispatcher.forward(request, response);

            } else {
                requestDispatcher = request.getRequestDispatcher("register.jsp");
                request.setAttribute("message", Message.MESSAGE_ERRO_REGISTER);
            }
            requestDispatcher.forward(request, response);

        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("register.jsp");
            request.setAttribute("message", Message.MESSAGE_ERRO_REGISTER);
            requestDispatcher.forward(request, response);
        }




    }
}

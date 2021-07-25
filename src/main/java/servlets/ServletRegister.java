package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Login;

import java.io.IOException;

@WebServlet(name = "ServletRegister", value = "/ServletRegister")
public class ServletRegister extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginRegister = req.getParameter("loginRegister");
        String passwordRegister = req.getParameter("passwordRegister");
        String url = req.getParameter("url");


        if(loginRegister != null && !loginRegister.isEmpty() && passwordRegister != null && !passwordRegister.isEmpty()) {
            Login modelLogin = new Login();
            modelLogin.setLogin(loginRegister);
            modelLogin.setPassword(passwordRegister);

            RequestDispatcher requestDispatcher;

            if (modelLogin.getLogin().equalsIgnoreCase("admin")
                    && modelLogin.getPassword().equalsIgnoreCase("admin")) {

                req.getSession().setAttribute("user", modelLogin.getLogin());


                requestDispatcher = req.getRequestDispatcher("url");
                requestDispatcher.forward(req, resp);
            } else {
                requestDispatcher = req.getRequestDispatcher("/register.jsp");
                req.setAttribute("msg", "Login e senha Vazios!");
            }
            requestDispatcher.forward(req, resp);






        }




    }
}

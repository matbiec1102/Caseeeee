package Controller;

import Model.User;
import Service.Implements.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    UserServiceImpl userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                login(request, response);
                break;
            case "register":
                register(request, response);
                break;
            default:
                error404(request, response);
                break;
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = userService.findUserByEmail(email);
        RequestDispatcher requestDispatcher;
        if (!user.getPassword().equals(password)) {
            try {
                response.sendRedirect("loginForm.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        request.setAttribute("user", user);
        requestDispatcher = request.getRequestDispatcher("/home");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void logout(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("user", null);
        try {
            response.sendRedirect("home.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");
        String confirm_password = request.getParameter("confirm_password");
        String role = "user";
        if (!password.equals(confirm_password)) {
            response.sendRedirect("registerForm.jsp");
        } else {
            userService.addUser(name, email, address, phoneNumber, password, role);
               response.sendRedirect("home.jsp");
        }
    }

    private void error404(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("error.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = " ";
        }
        switch (action) {
            case "logout":
                logout(request, response);
            case "loginForm":
                loginForm(request, response);
                break;
            case "registerForm":
                registerForm(request, response);
                break;
            default:
                error404(request, response);
                break;
        }
    }

    private void registerForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/registerForm.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void loginForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/loginForm.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}

package Controller;

import Model.*;
import Service.Implements.BookStoreServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "HomeServlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    BookStoreServiceImpl bookStore = new BookStoreServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "1":
                break;
            case "2":
                break;
            default:
                showHomepage(request, response);
                break;
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "1":
                break;
            case "2":
                break;
            default:
                showHomepage(request, response);
                break;
        }
    }


    private void showHomepage(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getAttribute("user");
        List<Book> bookList = bookStore.findAllBook();
        List<Category> categoryList = bookStore.findAllCategory();
        List<Publisher> publisherList = bookStore.findAllPublisher();
        List<Author> authorsList = bookStore.findAllAuthor();
        request.setAttribute("publisherList", publisherList);
        request.setAttribute("authorList", authorsList);
        request.setAttribute("bookList", bookList);
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("error.jsp");
        if (user == null) {
            requestDispatcher = request.getRequestDispatcher("home.jsp");
        }
        else if (user.getRole().equals("admin")) {
            requestDispatcher = request.getRequestDispatcher("adminHome.jsp");
        } else if (user.getRole().equals("user")){
            request.setAttribute("user",user);
            requestDispatcher = request.getRequestDispatcher("userHome.jsp");
        }

        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}


package Controller;

import Model.Book;
import Service.Implements.BookStoreServiceImpl;
import Service.Service.BookStoreService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookManagementServlet", urlPatterns = "/bookManager")
public class BookManagerServlet extends HttpServlet {
    BookStoreService bookStore = new BookStoreServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "addBook":
                addBook(request, response);
                break;
            case "editBook":
                editBook(request, response);
                break;
        }
    }

    private void addBook(HttpServletRequest request, HttpServletResponse response) {
        String title = request.getParameter("title");
        int price = Integer.parseInt(request.getParameter("price"));
        int bookNumber = Integer.parseInt(request.getParameter("bookNumber"));
        String category = request.getParameter("category");
        String author = request.getParameter("author");
        String image = request.getParameter("image");
        String publisher = request.getParameter("publisher");
        String info = request.getParameter("info");
        bookStore.addBook(title, price, bookNumber, category, author, image, publisher, info);

        try {
            response.sendRedirect("/bookManager");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editBook(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookStore.findBookById(id);
        book.setTitle(request.getParameter("title"));
        book.setPrice(Integer.parseInt(request.getParameter("price")));
        book.setBookNumber(Integer.parseInt(request.getParameter("bookNumber")));
        book.setCategory(request.getParameter("category"));
        book.setAuthor(request.getParameter("author"));
        book.setImage(request.getParameter("image"));
        book.setPublisher(request.getParameter("publisher"));
        book.setInfo(request.getParameter("info"));
        bookStore.editBook(book);
        try {
            response.sendRedirect("/bookManager");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete":
                deleteBook(request, response);
                break;
            case "showEditBookForm":
                showEditBookForm(request, response);
                break;
            case "showAddBook":
                showAddBookForm(request, response);
                break;
            default:
                showAllBook(request, response);
        }
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        bookStore.deleteBook(id);
        try {
            response.sendRedirect("/bookManager");
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }

    private void showAllBook(HttpServletRequest request, HttpServletResponse response) {
        List<Book> bookList = bookStore.findAllBook();
        request.setAttribute("bookList", bookList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/BookManager.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showAddBookForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/addForm.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditBookForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookStore.findBookById(id);
        request.setAttribute("book", book);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/editForm.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}

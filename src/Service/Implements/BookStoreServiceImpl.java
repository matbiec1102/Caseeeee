package Service.Implements;

import Model.*;
import Service.Service.BookStoreService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookStoreServiceImpl implements BookStoreService {
    MysqlConnectionImpl mysqlConnection = new MysqlConnectionImpl();
    private static final String sqlQr_findAllBook = "Select * from book;";
    private static final String sqlQr_findAllAuthor = "Select * from author;";
    private static final String sqlQr_findAllPublisher = "select  * from  publisher;";
    private static final String sqlQr_findAllCategory = "select * from category";
    private static final String sqlQr_addNewBook = "insert into book (title,price,bookNumber,category,author,image,publisher,info)values(?,?,?,?,?,?,?,?);";
    private static final String sqlQr_deleteBook = "delete from book where id=?";
    private static final String sqlQr_editBook = "update book set title=?,price=?,bookNumber=?,category=?,author=?,image=?,publisher=?,info=? where id =?;";
    private static final String sqlQr_findAllRole = "select * from role";

    @Override
    public List<Category> findAllCategory() {
        List<Category> categories = new ArrayList<>();
        try (
                Connection connection = mysqlConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQr_findAllCategory);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                categories.add(new Category(id, name));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public List<Book> findAllBook() {
        List<Book> books = new ArrayList<>();
        try (
                Connection connection = mysqlConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQr_findAllBook);
        ) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                int price = rs.getInt("price");
                int bookNumber = rs.getInt("bookNumber");
                String category = rs.getString("category");
                String author = rs.getString("author");
                String image = rs.getString("image");
                String publisher = rs.getString("publisher");
                String info = rs.getString("info");
                books.add(new Book(id, title, price, bookNumber, category, author, image, publisher, info));
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Author> findAllAuthor() {
        List<Author> authors = new ArrayList<>();
        try (
                Connection connection = mysqlConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sqlQr_findAllAuthor);
        ) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                authors.add(new Author(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

    @Override
    public List<Publisher> findAllPublisher() {
        List<Publisher> publishers = new ArrayList<>();
        try (
                Connection connection = mysqlConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sqlQr_findAllPublisher);
        ) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                publishers.add(new Publisher(id, name, address, phoneNumber));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return publishers;
    }

    @Override
    public List<Role> findAllRole() {
        List<Role> roles = new ArrayList<>();
        try (
                Connection connection = mysqlConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sqlQr_findAllRole);
        ) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                roles.add(new Role(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public List<Book> findBookByName(String name) {
        List<Book> books = findAllBook();
        for (Book book : books) {
            if (book.getTitle().equals(name)) {
                books.add(book);
            }
        }
        return books;
    }

    @Override
    public List<Book> findBookByCategory(String category) {
        List<Book> books = findAllBook();
        for (Book book : books) {
            if (book.getCategory().equals(category)) {
                books.add(book);
            }
        }
        return books;
    }

    @Override
    public List<Book> findBookByAuthor(String author) {
        List<Book> books = findAllBook();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                books.add(book);
            }
        }
        return books;
    }

    @Override
    public Book findBookById(int id) {
        List<Book> books = findAllBook();
        Book myBook = null;
        for (Book book : books) {
            if (book.getId() == id) {
                myBook = book;
            }
        }
        return myBook;
    }

    @Override
    public boolean addBook(String title, int price, int bookNumber, String category, String author, String image, String publisher, String info) {
        boolean status = false;
        Connection connection = mysqlConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sqlQr_addNewBook);
            ps.setString(1, title);
            ps.setInt(2, price);
            ps.setInt(3, bookNumber);
            ps.setString(4, category);
            ps.setString(5, author);
            ps.setString(6, image);
            ps.setString(7, publisher);
            ps.setString(8, info);
            status = ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return status;
    }

    private boolean getStatus(Book book, boolean status, Connection connection, String sqlQr_addNewBook) {
        try {
            PreparedStatement ps = connection.prepareStatement(sqlQr_addNewBook);
            String title = book.getTitle();
            int price = book.getPrice();
            int bookNumber = book.getBookNumber();
            String category = book.getCategory();
            String author = book.getAuthor();
            String image = book.getImage();
            String publisher = book.getPublisher();
            String info = book.getInfo();
            ps.setString(1, title);
            ps.setInt(2, price);
            ps.setInt(3, bookNumber);
            ps.setString(4, category);
            ps.setString(5, author);
            ps.setString(6, image);
            ps.setString(7, publisher);
            ps.setString(8, info);
            status = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean deleteBook(int id) {
        boolean status = false;
        Connection connection = mysqlConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sqlQr_deleteBook);
            ps.setInt(1, id);
            status = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }


    @Override
    public boolean editBook( Book newBook) {
        boolean status = false;
        Connection connection = mysqlConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQr_editBook);
            preparedStatement.setString(1, newBook.getTitle());
            preparedStatement.setInt(2, newBook.getPrice());
            preparedStatement.setInt(3, newBook.getBookNumber());
            preparedStatement.setString(4, newBook.getCategory());
            preparedStatement.setString(5, newBook.getAuthor());
            preparedStatement.setString(6, newBook.getImage());
            preparedStatement.setString(7, newBook.getPublisher());
            preparedStatement.setString(8, newBook.getInfo());
            preparedStatement.setInt(9, newBook.getId());
            status = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}

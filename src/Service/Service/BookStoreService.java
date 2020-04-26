package Service.Service;

import Model.*;

import java.util.List;

public interface BookStoreService {
    List<Book> findAllBook();

    List<Author> findAllAuthor();

    List<Publisher> findAllPublisher();

    List<Category> findAllCategory();

    List<Role> findAllRole();

    List<Book> findBookByName(String name);

    List<Book> findBookByCategory(String name);

    List<Book> findBookByAuthor(String name);

    Book findBookById(int id);

    boolean addBook(String title, int price, int bookNumber, String category, String author, String image, String publisher, String info);

    boolean deleteBook(int id);

    boolean editBook( Book newBook);
}

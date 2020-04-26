package Model;

public class Book {
    private int id;
    private String title;
    private int price;
    private int bookNumber;
    private String category;
    private String author;
    private String image;
    private String publisher;
    private String info;

    public Book(int id, String title, int price, int bookNumber, String category, String author, String image, String publisher, String info) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.bookNumber = bookNumber;
        this.category = category;
        this.author = author;
        this.image = image;
        this.publisher = publisher;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

package Model;

public class OrderItem {
    private int id;
    private int amount;
    private int bookId;
    private int orderId;
    private int totalPrice;
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public OrderItem(int id, int amount, int bookId, int orderId, int totalPrice, int userId) {
        this.id = id;
        this.amount = amount;
        this.bookId = bookId;
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.userId = userId;
    }
}

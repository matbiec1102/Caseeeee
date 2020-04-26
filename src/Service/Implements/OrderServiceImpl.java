package Service.Implements;

import Model.Order;
import Model.OrderItem;
import Service.Service.OrderService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    MysqlConnectionImpl mysqlConnection = new MysqlConnectionImpl();
    private static final String sqlQr_findAllOrderItem = "select * from orderItem where userId=?";
    private static final String sqlQr_RemoveOrderItemByID = "delete from orderItem where id=?";
    private static final String sqlQr_addOrderItem = "insert into orderItem(amount, bookId, orderId, totalPrice, userId) VALUES (?,?,?,?,?)";
    private static final String sqlQr_CheckOutOrder = "delete  from orderItem where orderId=?";
    private static final String sqlQr_findAllOrder = "select * from `order`";
    private static final String sqlQr_addOrder = "insert into `order`( userId, totalPrice) VALUES(?,?) ";

    @Override
    public List<OrderItem> findAllOrderItemOfUser(int userId) {
        List<OrderItem> orderItems = new ArrayList<>();
        try (
                Connection connection = mysqlConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQr_findAllOrderItem);
        ) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int amount = rs.getInt("amount");
                int bookId = rs.getInt("bookId");
                int orderId = rs.getInt("orderId");
                int totalPride = rs.getInt("totalPride");
                int myUserId = rs.getInt("userId");
                orderItems.add(new OrderItem(id, amount, bookId, orderId, totalPride, myUserId));
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return orderItems;
    }

    @Override
    public boolean checkOutOrder(int order_id) {
        return getStatus(order_id, sqlQr_CheckOutOrder);
    }

    private boolean getStatus(int order_id, String sqlQr_checkOutOrder) {
        boolean status = false;
        try (
                Connection connection = mysqlConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareCall(sqlQr_checkOutOrder);
        ) {
            preparedStatement.setInt(1, order_id);
            status = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean deleteOrderItem(int item_id) {
        return getStatus(item_id, sqlQr_RemoveOrderItemByID);
    }

    @Override
    public boolean addOrderItem(OrderItem orderItem) {
        boolean status = false;
        Connection connection = mysqlConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sqlQr_addOrderItem);
            ps.setInt(1, orderItem.getAmount());
            ps.setInt(2, orderItem.getBookId());
            ps.setInt(3, orderItem.getOrderId());
            ps.setInt(4, orderItem.getTotalPrice());
            ps.setInt(5, orderItem.getUserId());
            status = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public List<Order> findAllOrder() {
        List<Order> orders = new ArrayList<>();
        try (
                Connection connection = mysqlConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQr_findAllOrder);
        ) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int myUserId = rs.getInt("userId");
                int totalPride = rs.getInt("totalPride");
                orders.add(new Order(id, myUserId, totalPride));
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public Order findOrderByUserId(int user_id) {
        List<Order> orders = findAllOrder();
        Order myOrder = null;
        for (Order order : orders) {
            if (order.getUserId() == user_id) {
                myOrder = order;
            }
        }
        return myOrder;
    }

    @Override
    public boolean createNewOrder(Order order) {
        boolean status = false;
        Connection connection = mysqlConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sqlQr_addOrder);
            ps.setInt(1, order.getUserId());
            ps.setInt(2, order.getTotalPrice());
            status = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}

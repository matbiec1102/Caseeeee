package Service.Service;

import Model.Order;
import Model.OrderItem;

import java.util.List;

public interface OrderService {

    List<OrderItem> findAllOrderItemOfUser(int userId);
    boolean checkOutOrder(int order_id);
    boolean deleteOrderItem(int item_id);
    boolean addOrderItem(OrderItem orderItem);

    List<Order> findAllOrder();

    Order findOrderByUserId(int user_id);
    boolean createNewOrder(Order order);
}

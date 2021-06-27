package rabbitmq.service;

import rabbitmq.dto.Order;

public interface OrderService {
    Order save(Order order);
}

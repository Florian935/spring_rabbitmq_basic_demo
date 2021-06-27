package rabbitmq.service.impl;

import org.springframework.stereotype.Service;
import rabbitmq.dto.Order;
import rabbitmq.service.OrderService;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Order save(Order order) {

        order.setId(UUID.randomUUID().toString());

        return order;
    }
}

package rabbitmq.consumer.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import rabbitmq.consumer.Consumer;
import rabbitmq.dto.Order;

import static rabbitmq.config.MessagingConfig.QUEUE_NAME;

@Service
public class OrderConsumer implements Consumer<Order> {

    @RabbitListener(queues = QUEUE_NAME)
    public void consume(Order order) {

        System.out.printf("#### Message received from queue : %s\n", order.getName());
    }
}

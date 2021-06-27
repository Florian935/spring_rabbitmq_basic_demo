package rabbitmq.producer.impl;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import rabbitmq.dto.Order;
import rabbitmq.producer.Producer;

import static lombok.AccessLevel.PRIVATE;
import static rabbitmq.config.MessagingConfig.EXCHANGE_NAME;
import static rabbitmq.config.MessagingConfig.ROUTING_KEY;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class OrderProducerImpl implements Producer<Order> {
    RabbitTemplate customRabbitTemplate;

    @Override
    public void produce(Order order) {

        customRabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, order);
    }
}

package rabbitmq.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;
import rabbitmq.dto.Order;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static rabbitmq.config.MessagingConfig.EXCHANGE_NAME;
import static rabbitmq.config.MessagingConfig.ROUTING_KEY;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class PublisherController {
    private RabbitTemplate rabbitTemplate;

    @PostMapping(path = "/", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public Order orderBook(@RequestBody Order order) {
        order.setId(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, order);

        return order;
    }
}

package rabbitmq.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import rabbitmq.dto.Order;
import rabbitmq.producer.Producer;
import rabbitmq.service.OrderService;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderController {
    OrderService orderService;
    Producer<Order> orderProducer;

    @PostMapping(path = "", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public Order orderBook(@RequestBody Order order) {

        final Order savedOrder = orderService.save(order);
        orderProducer.produce(savedOrder);

        return savedOrder;
    }
}

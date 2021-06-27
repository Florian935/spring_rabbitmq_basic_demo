package rabbitmq.consumer;

public interface Consumer<T> {
    void consume(T message);
}

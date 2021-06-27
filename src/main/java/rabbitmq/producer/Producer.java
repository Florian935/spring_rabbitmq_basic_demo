package rabbitmq.producer;

public interface Producer<T> {
    void produce(T message);
}

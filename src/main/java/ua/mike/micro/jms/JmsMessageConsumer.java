package ua.mike.micro.jms;

/**
 * Created by mike on 03.06.2022 13:04
 */
@FunctionalInterface
public interface JmsMessageConsumer<S> {

    void consume(S s) throws Exception;
}

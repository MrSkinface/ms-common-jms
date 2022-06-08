package ua.mike.micro.jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

/**
 * Created by mike on 03.06.2022 13:32
 */
@RequiredArgsConstructor
public class JmsConsumerActions {

    private final ObjectMapper mapper;

    @SneakyThrows
    public  <T>void consume(String data, Class<T> clazz, JmsMessageConsumer<T> consumer) {
        consumer.consume(mapper.readValue(data, clazz));
    }
}

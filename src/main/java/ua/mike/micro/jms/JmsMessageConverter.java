package ua.mike.micro.jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.*;

/**
 * Created by mike on 01.06.2022 13:39
 */
public class JmsMessageConverter extends MappingJackson2MessageConverter {

    private final ObjectMapper mapper;

    public JmsMessageConverter(ObjectMapper mapper) {
        super.setObjectMapper(mapper);
        super.setTargetType(MessageType.TEXT);
        this.mapper = mapper;
    }

    @SneakyThrows
    @Override
    public Message toMessage(Object object, Session session) throws MessageConversionException {
        final var message = (TextMessage) super.toMessage(object, session);
        message.setText(mapper.writeValueAsString(object));
        return message;
    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        final var msg = (TextMessage) message;
        return msg.getText();
    }
}

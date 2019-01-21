package org.sahil.msbroker.config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.BindingBuilder.GenericArgumentsConfigurer;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * the producer can only send messages to an exchange. An exchange is a very simple thing. On one
 * side it receives messages from producers and the other side it pushes them to queues. The
 * exchange must know exactly what to do with a message it receives. Should it be appended to a
 * particular queue? Should it be appended to many queues? Or should it get discarded. The rules for
 * that are defined by the exchange type
 */
@Configuration
public class RabbitMQConfig {

    @Value("${mq-config.queue}")
    String queueName;

    @Autowired
    private MQAdditionalConfig additionalConfig;

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    /**
     * There are a few exchange types available: direct, topic, headers and fanout.
     */
    @Bean
    DirectExchange exchange() {
        return new DirectExchange(additionalConfig.getExchange());
    }

    @Bean
    public GenericArgumentsConfigurer binding(Queue queue, Exchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(additionalConfig.getRoutingKey());
    }

}
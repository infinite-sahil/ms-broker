package org.sahil.msbroker.config;

import org.sahil.msbroker.domain.Employee;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    private MQAdditionalConfig additionalConfig;


    public void send(final Employee employee) {
        rabbitTemplate.convertAndSend(additionalConfig.getExchange(),
                additionalConfig.getRoutingKey(),
                employee);
        System.out.println("Send msg = " + employee);

    }

}

package org.sahil.msbroker.consumer;

import org.sahil.msbroker.domain.Employee;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "${mq-config.queue}")
public class RabbitMQConsumer {

    @RabbitHandler
    public void receivedMessage(final Employee employee) {
        System.out.println("Received Message From MQ: " + employee);
    }

}

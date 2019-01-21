package org.sahil.msbroker.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mq-config")
@Getter
@Setter
public class MQAdditionalConfig {

    private String exchange;
    private String queue;
    private String routingKey;

}

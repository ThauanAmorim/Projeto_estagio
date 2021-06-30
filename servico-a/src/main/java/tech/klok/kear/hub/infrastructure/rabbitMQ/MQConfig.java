package tech.klok.kear.hub.infrastructure.rabbitMQ;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;

@Configuration
public class MQConfig {

    public static final String LOGIN_QUEUE_CONTROLLER = "login_queue_controller";
    public static final String LOGIN_QUEUE_SERVICE = "login_queue_service";
    public static final String LOGIN_EXCHANGE_CONTROLLER = "login_exchange_controller";
    public static final String LOGIN_EXCHANGE_SERVICE = "login_exchange_service";
    public static final String ROUTING_KEY = "message_routingKey";

    
    public Queue queue(String name) {
        return new Queue(name);
    }

    @Bean
    public Queue queue1() {
        return new Queue(LOGIN_QUEUE_CONTROLLER);
    }

    @Bean
    public Queue queue2() {
        return new Queue(LOGIN_QUEUE_SERVICE);
    }

    @Bean
    public TopicExchange exchange1 () {
        return new TopicExchange(LOGIN_EXCHANGE_CONTROLLER);
    }

    @Bean
    public TopicExchange exchange2 () {
        return new TopicExchange(LOGIN_EXCHANGE_SERVICE);
    }

    @Bean
    public Binding binding1(Queue queue1, TopicExchange exchange1) {
        Binding binding = BindingBuilder
            .bind(queue1)
            .to(exchange1)
            .with(ROUTING_KEY);
        return binding;
    }
    
    @Bean
    public Binding binding2(Queue queue2, TopicExchange exchange2) {
        Binding binding = BindingBuilder
            .bind(queue2)
            .to(exchange2)
            .with(ROUTING_KEY);
        return binding;
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory factory) {
        RabbitTemplate template = new RabbitTemplate(factory);
        template.setMessageConverter(messageConverter());
        return template;
    }
}

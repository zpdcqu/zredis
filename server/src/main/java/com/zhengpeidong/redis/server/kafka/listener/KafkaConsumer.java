package com.zhengpeidong.redis.server.kafka.listener;

import com.alibaba.fastjson.JSON;
import com.zhengpeidong.redis.server.kafka.model.Protocol;
import com.zhengpeidong.redis.server.redis.Strategy;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 *kafka消费者
 */
@Service
public class KafkaConsumer {
    @Autowired
    ApplicationContext context;

    @KafkaListener(topics = "Kafka_Example", containerGroup = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }


    @KafkaListener(topics = "Kafka_Example_json", containerGroup = "group_json",
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(Protocol protocol) {
        System.out.println("Consumed JSON Message: " + protocol.toString());
        String strategyBeanName =toStrategyBeanName(protocol);
        Strategy strategy = (Strategy) context.getBean(strategyBeanName);
        Object excute = strategy.excute(protocol);
        System.out.println(excute);
    }

    private String toStrategyBeanName(Protocol protocol){
        return protocol.getOperator().toLowerCase()+"Strategy";
    }
}

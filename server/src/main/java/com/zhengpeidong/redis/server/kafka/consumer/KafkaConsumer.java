package com.zhengpeidong.redis.server.kafka.consumer;

import com.zhengpeidong.redis.server.kafka.model.Protocol;
import com.zhengpeidong.redis.server.redis.Strategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

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
        String operator = protocol.getOperator();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <operator.length() ; i++) {
            String ele = operator.charAt(i)+"";
            if (i==0){
                stringBuilder.append(ele.toUpperCase());
            }else {
                stringBuilder.append(ele.toLowerCase());
            }
        }
        return stringBuilder.toString()+"Strategy";
    }
}

package com.zhengpeidong.redis.server.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @description: kafka生产者
 * @author: ZhengPeidong
 * @create: 2019-12-07 18:15
 */

@Service
@Slf4j
public class KafkaProducer {




    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;



    public void send(String topic, String payload) {

        log.info("send msg topic=[{}],payload=[{}]", topic, payload);
        kafkaTemplate.send(topic, payload);
        log.info("send over !");

    }



}

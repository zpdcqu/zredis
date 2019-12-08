package com.zhengpeidong.redis.server.kafka;

import com.alibaba.fastjson.JSON;
import com.zhengpeidong.redis.server.SpringBootKafkaConsumerExampleApplication;
import com.zhengpeidong.redis.server.kafka.model.Protocol;
import com.zhengpeidong.redis.server.kafka.producer.KafkaProducer;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @author: ZhengPeidong
 * @create: 2019-12-07 18:29
 */

@SpringBootTest(classes = SpringBootKafkaConsumerExampleApplication.class)
@RunWith(SpringRunner.class)
public class Test {

    @Autowired
    KafkaProducer producer;

    @org.junit.Test
    public void send(){
        Protocol protocol = new Protocol();
        protocol.setOperator("set");
        protocol.setKey("aa");
        protocol.setValue("测试get方法");
        producer.send("Kafka_Example_json",JSON.toJSONString(protocol).toLowerCase());


        protocol.setOperator("get");
        protocol.setKey("aa");
        producer.send("Kafka_Example_json",JSON.toJSONString(protocol).toLowerCase());
    }


}

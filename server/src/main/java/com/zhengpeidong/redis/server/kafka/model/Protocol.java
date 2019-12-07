package com.zhengpeidong.redis.server.kafka.model;

import lombok.Data;

@Data
public class Protocol {

    private String operator;
    private String key;
    private String value;

}

package com.zhengpeidong.redis.server.redis.impl;

import com.zhengpeidong.redis.server.kafka.model.Protocol;
import com.zhengpeidong.redis.server.redis.Strategy;
import org.springframework.stereotype.Component;

/**
 * @description: set操作
 * @author: ZhengPeidong
 * @create: 2019-12-07 18:03
 */
@Component("setStrategy")
public class SetStrategy implements Strategy {
    @Override
    public Object excute(Protocol protocol) {
        return protocol.getKey();
    }
}

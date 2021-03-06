package com.zhengpeidong.redis.server.redis.impl;

import com.zhengpeidong.redis.server.kafka.model.Protocol;
import com.zhengpeidong.redis.server.redis.Strategy;
import com.zhengpeidong.redis.server.redis.core.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description: set操作
 * @author: ZhengPeidong
 * @create: 2019-12-07 18:03
 */
@Component("SetStrategy")
public class SetStrategy   implements Strategy {

    @Autowired
    Storage storage;
    @Override
    public Object excute(Protocol protocol) {
       storage.getStringMap().put(protocol.getKey(),protocol.getValue());
       return true;
    }
}

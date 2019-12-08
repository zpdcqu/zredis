package com.zhengpeidong.redis.server.redis.impl;

import com.zhengpeidong.redis.server.kafka.model.Protocol;
import com.zhengpeidong.redis.server.redis.Strategy;
import com.zhengpeidong.redis.server.redis.core.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description: get操作
 * @author: ZhengPeidong
 * @create: 2019-12-08 23:58
 */
@Component("GetStrategy")
public class GetStrategy  implements Strategy {
    @Autowired
    Storage storage;
    @Override
    public Object excute(Protocol protocol) {
        return storage.getStringMap().get(protocol.getKey());
    }
}

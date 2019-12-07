package com.zhengpeidong.redis.server.redis;

import com.zhengpeidong.redis.server.kafka.model.Protocol;

/**
 * @program: zredis
 * @description: 策略接口
 * @author: ZhengPeidong
 * @create: 2019-12-07 17:43
 */
public interface Strategy {
   Object excute(Protocol protocol);
}


package com.zhengpeidong.redis.server.redis.core;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 存储中心
 * @author: ZhengPeidong
 * @create: 2019-12-08 23:51
 */

@Component
@Data
public class Storage {
    private ConcurrentHashMap<String,String> stringMap = new ConcurrentHashMap<>();

}

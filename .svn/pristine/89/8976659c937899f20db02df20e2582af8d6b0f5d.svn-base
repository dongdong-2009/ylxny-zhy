package com.zhy.collector.data.redis;

import redis.clients.jedis.Jedis;

/**
 * @author : zengqiang
 * @version V1.0
 * @Project: DataCollector
 * @Package com.shoujiang.platform.base.data
 * @Description: 存放数据 redis队列
 * @date Date : 2018年08月30日 15:47
 */
public class RedisQueue {
    private static Jedis Redis = new Jedis("127.0.0.1");

    public static void SetList(String key,String value){
        Redis.lpush(key,value);
    }

    public static String ListRPOP(String key){
        return Redis.rpop(key);
    }
}

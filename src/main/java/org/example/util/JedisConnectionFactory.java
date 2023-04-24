package org.example.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

public class JedisConnectionFactory {

    private static final JedisPool jedisPool;

    static {
        //配置连接池
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        //最大连接数
        poolConfig.setMaxTotal(8);
        //最大空闲连接
        poolConfig.setMaxIdle(8);
        //最小空闲连接
        poolConfig.setMinIdle(0);
        //等待时常
        poolConfig.setMaxWait(Duration.ofDays(10));

        //创建连接池对象
        jedisPool = new JedisPool(poolConfig, "192.168.60.131", 6379,
                1000, "123456");

    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}

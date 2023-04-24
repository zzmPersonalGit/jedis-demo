package org.example;

import org.example.util.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

public class JedisTest {

    private Jedis jedis;

    @BeforeEach
    void setUp() {
        //建立连接
        //jedis = new Jedis("192.168.60.131",6379);
        jedis = JedisConnectionFactory.getJedis();
        //设置密码
        //jedis.auth("123456");
        //选择库
        jedis.select(0);
    }

    @Test
    void test() {

        jedis.set("name","小黄");
        String name = jedis.get("name");
        String age = jedis.get("age");
        System.out.println(name+age);
    }

    @AfterEach
    void tearDown() {
        if (jedis != null){
            jedis.close();
        }
    }
}

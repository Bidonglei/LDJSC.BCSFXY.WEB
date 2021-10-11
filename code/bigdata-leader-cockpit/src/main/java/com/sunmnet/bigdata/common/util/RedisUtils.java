package com.sunmnet.bigdata.common.util;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import java.util.Properties;

/**
 * Created by lichong on 2017/10/26.
 */
public class RedisUtils {

    private JedisPool pool;

    private static class LazyHolder {
        private static final RedisUtils INSTANCE = new RedisUtils();
    }

    private RedisUtils(){

        Properties properties = PropertiesUtils.getProperties();

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxTotal(100);
        //控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
        //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
        jedisPoolConfig.setMaxTotal(100);
        //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
        jedisPoolConfig.setMaxIdle(50);
        //表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
        jedisPoolConfig.setMaxWaitMillis(10000);
        //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
        jedisPoolConfig.setTestOnBorrow(true);

        final String ip=properties.getProperty("redis.ip");
        final int port=Integer.parseInt(properties.getProperty("redis.port"));
        final int timeout=Integer.parseInt(properties.getProperty("redis.timeout"));

        pool = new JedisPool(jedisPoolConfig, ip, port,timeout);
    }

    public static final RedisUtils instance(){
        return LazyHolder.INSTANCE;
    }

    public JedisPool getPool(){
        return pool;
    }

}

/*
 * Author:   lishihui
 * FileName: RedisUtil
 * Date:     2019/12/18 14:55
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.springboot.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉
 * 〈redis工具〉
 *
 * @AUTHOR lishihui
 * @DATE 2019/12/18 14:55
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
public class RedisUtil {

    /**
     * 日志
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(RedisUtil.class);

    /**
     * 指定缓存失效时间
     *
     * @param redisTemplate
     * @param key
     * @param time
     * @return
     */
    public static boolean expire(RedisTemplate<String, Object> redisTemplate, String key, long time) {
        if (time <= 0) {
            LOGGER.info("缓存失效时间不能小于等于0");
            return false;
        }
        return redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }

    /**
     * 获取过期时间
     *
     * @param redisTemplate
     * @param key
     * @return
     */
    public static Long getExpire(RedisTemplate<String, Object> redisTemplate, String key) {
        return redisTemplate.getExpire(key);
    }

    /**
     * 判断key是否存在
     *
     * @param redisTemplate
     * @param key
     * @return
     */
    public static boolean hasKey(RedisTemplate<String, Object> redisTemplate, String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 删除缓存
     *
     * @param redisTemplate
     * @param keys
     * @return
     */
    public static void del(RedisTemplate<String, Object> redisTemplate, List<String> keys) {
        redisTemplate.delete(keys);
    }

    /**
     * 根据key获取value
     *
     * @param redisTemplate
     * @param key
     * @return
     */
    public static Object get(RedisTemplate<String, Object> redisTemplate, String key) {
        return StringUtils.isEmpty(key) ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 设置key和value
     *
     * @param redisTemplate
     * @param key
     * @param value
     * @return
     */
    public static Boolean set(RedisTemplate<String, Object> redisTemplate, String key, String value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            LOGGER.error("set redis key:{},value:{} Exception:{}", new Object[]{key, value, e});
            return false;
        }
    }

    /**
     * 设置key和value(带有失效时间)
     *
     * @param redisTemplate
     * @param key
     * @param value
     * @return
     */
    public static Boolean set(RedisTemplate<String, Object> redisTemplate, String key, String value, long time) {
        try {
            redisTemplate.opsForValue().set(key, value, time);
            return true;
        } catch (Exception e) {
            LOGGER.error("set redis key:{},value:{} Exception:{}", new Object[]{key, value, e});
            return false;
        }
    }

    /**
     * HashGet
     *
     * @param key  键 不能为null
     * @param item 项 不能为null
     * @return 值
     */
    public static Object hget(RedisTemplate<String, Object> redisTemplate, String key, String item) {
        return redisTemplate.opsForHash().get(key, item);
    }

    /**
     * 获取hashKey对应的所有键值
     *
     * @param key 键
     * @return 对应的多个键值
     */
    public static Map<Object, Object> hmget(RedisTemplate<String, Object> redisTemplate, String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * HashSet
     *
     * @param key 键
     * @param map 对应多个键值
     * @return true 成功 false 失败
     */
    public static boolean hmset(RedisTemplate<String, Object> redisTemplate, String key, Map<String, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            LOGGER.error("hmset key:{},map:{},exception:{}", new Object[]{key, map, e});
            return false;
        }
    }

    /**
     * HashSet 并设置时间
     *
     * @param key  键
     * @param map  对应多个键值
     * @param time 时间(秒)
     * @return true成功 false失败
     */
    public static boolean hmset(RedisTemplate<String, Object> redisTemplate, String key, Map<String, Object> map,
                                long time) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if (time > 0) {
                expire(redisTemplate, key, time);
            }
            return true;
        } catch (Exception e) {
            LOGGER.error("hmset key:{},map:{},exception:{}", new Object[]{key, map, e});
            return false;
        }
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @return true 成功 false失败
     */
    public static boolean hset(RedisTemplate<String, Object> redisTemplate, String key, String item, Object value) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            return true;
        } catch (Exception e) {
            LOGGER.error("hset key:{},item:{},value:{},exception:{}", new Object[]{key, item, value, e});
            return false;
        }
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @param time  时间(秒) 注意:如果已存在的hash表有时间,这里将会替换原有的时间
     * @return true 成功 false失败
     */
    public static boolean hset(RedisTemplate<String, Object> redisTemplate, String key, String item, Object value,
                               long time) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            if (time > 0) {
                expire(redisTemplate, key, time);
            }
            return true;
        } catch (Exception e) {
            LOGGER.error("hset key:{},item:{},value:{},exception:{}", new Object[]{key, item, value, e});
            return false;
        }
    }

    /**
     * 删除hash表中的值
     *
     * @param key  键 不能为null
     * @param item 项 可以使多个 不能为null
     */
    public static void hdel(RedisTemplate<String, Object> redisTemplate, String key, Object... item) {
        redisTemplate.opsForHash().delete(key, item);
    }

    /**
     * 判断hash表中是否有该项的值
     *
     * @param key  键 不能为null
     * @param item 项 不能为null
     * @return true 存在 false不存在
     */
    public static boolean hHasKey(RedisTemplate<String, Object> redisTemplate, String key, String item) {
        return redisTemplate.opsForHash().hasKey(key, item);
    }

    /**
     * hash递增 如果不存在,就会创建一个 并把新增后的值返回
     *
     * @param key  键
     * @param item 项
     * @param by   要增加几(大于0)
     * @return
     */
    public static double hincr(RedisTemplate<String, Object> redisTemplate, String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item, by);
    }

    /**
     * hash递减
     *
     * @param key  键
     * @param item 项
     * @param by   要减少记(小于0)
     * @return
     */
    public static double hdecr(RedisTemplate<String, Object> redisTemplate, String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item, -by);
    }

    /**
     * 根据key获取Set中的所有值
     *
     * @param key 键
     * @return
     */
    public static Set<Object> sGet(RedisTemplate<String, Object> redisTemplate, String key) {
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            LOGGER.error("sGet key:{},exception:{}", new Object[]{key, e});
            return null;
        }
    }

    /**
     * 根据value从一个set中查询,是否存在
     *
     * @param key   键
     * @param value 值
     * @return true 存在 false不存在
     */
    public static boolean sHasKey(RedisTemplate<String, Object> redisTemplate, String key, Object value) {
        try {
            return redisTemplate.opsForSet().isMember(key, value);
        } catch (Exception e) {
            LOGGER.error("sHasKey key:{},value:{},exception:{}", new Object[]{key, value, e});
            return false;
        }
    }

    /**
     * 将数据放入set缓存
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 成功个数
     */
    public static long sSet(RedisTemplate<String, Object> redisTemplate, String key, Object... values) {
        try {
            return redisTemplate.opsForSet().add(key, values);
        } catch (Exception e) {
            LOGGER.error("sSet key:{},values:{},exception:{}", new Object[]{key, values, e});
            return 0;
        }
    }

    /**
     * 将set数据放入缓存
     *
     * @param key    键
     * @param time   时间(秒)
     * @param values 值 可以是多个
     * @return 成功个数
     */
    public static long sSetAndTime(RedisTemplate<String, Object> redisTemplate, String key, long time,
                                   Object... values) {
        try {
            Long count = redisTemplate.opsForSet().add(key, values);
            if (time > 0) {
                expire(redisTemplate, key, time);
            }
            return count;
        } catch (Exception e) {
            LOGGER.error("sSetAndTime key:{},time:{},values:{},exception:{}", new Object[]{key, time, values, e});
            return 0;
        }
    }

    /**
     * 获取set缓存的长度
     *
     * @param key 键
     * @return
     */
    public static long sGetSetSize(RedisTemplate<String, Object> redisTemplate, String key) {
        try {
            return redisTemplate.opsForSet().size(key);
        } catch (Exception e) {
            LOGGER.error("sGetSetSize key:{},exception:{}", new Object[]{key, e});
            return 0;
        }
    }

    /**
     * 移除值为value的
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 移除的个数
     */
    public static long setRemove(RedisTemplate<String, Object> redisTemplate, String key, Object... values) {
        try {
            Long count = redisTemplate.opsForSet().remove(key, values);
            return count;
        } catch (Exception e) {
            LOGGER.error("setRemove key:{},values:{},exception:{}", new Object[]{key, values, e});
            return 0;
        }
    }

    /**
     * 获取list缓存的内容
     *
     * @param key   键
     * @param start 开始
     * @param end   结束 0 到 -1代表所有值
     * @return
     */
    public static List<Object> lGet(RedisTemplate<String, Object> redisTemplate, String key, long start, long end) {
        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            LOGGER.error("lGet key:{} start;{},end:{},exception:{}", new Object[]{key, start, end, e});
            return null;
        }
    }

    /**
     * 获取list缓存的长度
     *
     * @param key 键
     * @return
     */
    public static long lGetListSize(RedisTemplate<String, Object> redisTemplate, String key) {
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            LOGGER.error("lGetListSize key:{},exception:{}", new Object[]{key, e});
            return 0;
        }
    }

    /**
     * 通过索引 获取list中的值
     *
     * @param key   键
     * @param index 索引
     * @return
     */
    public static Object lGetIndex(RedisTemplate<String, Object> redisTemplate, String key, long index) {
        try {
            return redisTemplate.opsForList().index(key, index);
        } catch (Exception e) {
            LOGGER.error("lGetIndex key:{},index:{},exception:{}", new Object[]{key, index, e});
            return null;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public static boolean lSet(RedisTemplate<String, Object> redisTemplate, String key, Object value) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e) {
            LOGGER.error("lSet key:{},value:{},exception:{}", new Object[]{key, value, e});
            return false;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    public static boolean lSet(RedisTemplate<String, Object> redisTemplate, String key, Object value, long time) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            if (time > 0) {
                expire(redisTemplate, key, time);
            }
            return true;
        } catch (Exception e) {
            LOGGER.error("lSet key:{},value:{},exception:{}", new Object[]{key, value, e});
            return false;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public static boolean lSet(RedisTemplate<String, Object> redisTemplate, String key, List<Object> value) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            return true;
        } catch (Exception e) {
            LOGGER.error("lSet key:{},value:{},exception:{}", new Object[]{key, value, e});
            return false;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    public static boolean lSet(RedisTemplate<String, Object> redisTemplate, String key, List<Object> value, long time) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            if (time > 0) {
                expire(redisTemplate, key, time);
            }
            return true;
        } catch (Exception e) {
            LOGGER.error("lSet key:{},value:{},exception:{}", new Object[]{key, value, e});
            return false;
        }
    }

    /**
     * 根据索引修改list中的某条数据
     *
     * @param key   键
     * @param index 索引
     * @param value 值
     * @return
     */
    public static boolean lUpdateByIndex(RedisTemplate<String, Object> redisTemplate, String key, long index,
                                         Object value) {
        try {
            redisTemplate.opsForList().set(key, index, value);
            return true;
        } catch (Exception e) {
            LOGGER.error("lUpdateIndex key:{},value:{},exception:{}", new Object[]{key, value, e});
            return false;
        }
    }

    /**
     * 移除N个值为value
     *
     * @param key   键
     * @param count 移除多少个
     * @param value 值
     * @return 移除的个数
     */
    public static long lRemove(RedisTemplate<String, Object> redisTemplate, String key, long count, Object value) {
        try {
            Long remove = redisTemplate.opsForList().remove(key, count, value);
            return remove;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


}

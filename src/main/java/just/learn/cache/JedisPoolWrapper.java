package just.learn.cache;

import just.learn.common.constants.Parameters;
import just.learn.common.enums.ResultEnum;
import just.learn.common.execption.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.PostConstruct;

/**
 * @author Ethanp
 * @version V1.0
 * @Package cn.jihangyu.glowworm.cache
 * @Description: TODO redis连接池
 * @date 2018/2/7 9:51
 */
@Component
@Slf4j
public class JedisPoolWrapper {

    private JedisPool jedisPool = null;

    @Autowired
    private Parameters parameters;


    @PostConstruct//这个注解保证类实例化的时候会被执行，相当于静态代码块
    public void init() {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxWaitMillis(parameters.getRedisMaxWaitMillis());
            config.setMaxIdle(parameters.getRedisMaxIdle());
            config.setMaxTotal(parameters.getRedisMaxTotal());
            jedisPool = new JedisPool(config, parameters.getRedisHost(), parameters.getRedisPort(), 2000);
        } catch (Exception e) {
            log.error("Fail to initialize redis pool", e);
            throw new CustomException(ResultEnum.REDIS_INITIALIZATION_ERROR);
        }

    }


    public JedisPool getJedisPool() {
        return jedisPool;
    }
}


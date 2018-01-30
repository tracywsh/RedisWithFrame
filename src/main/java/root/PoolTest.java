package root;

import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class PoolTest {
	
	@Autowired
	private JedisPool jedisPool;
	
	@PostConstruct
	public void test(){
		System.out.println("=====JedisPool的测试=======");
		//获取连接
		Jedis jedis = jedisPool.getResource();
		
		//获取所有的key
		Set<String> keySet = jedis.keys("*");
		for (String key : keySet){
			System.out.println(key + ":" + jedis.type(key));
		}
		
		//释放连接
		jedis.close();
	}
}


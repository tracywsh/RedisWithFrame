package root;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import redis.clients.jedis.JedisPool;


@Component
public class RedisOperationsTest {
	
	//name必须指定
	//操作字符串
	@Resource(name="redisTemplate")
	private ValueOperations<String,String> stringOperations;
	
	//操作列表
	@Resource(name="redisTemplate")
	private ListOperations<String,Object> listOperations;
	
	//操作集合
	@Resource(name="redisTemplate")
	private SetOperations<String,Object> setOperations;
	
	//操作有序集合
	@Resource(name="redisTemplate")
	private ZSetOperations<String,Object> zsetOperations;
	
	//操作hash
	@Resource(name="redisTemplate")
	private HashOperations<String, Object, Object> hashOperations;
	
	@PostConstruct
	private void test(){
		
		System.out.println("========字符串操作============");
		stringOperations.set("string", "wangsh");
		System.out.println(stringOperations.get("string"));
		
		System.out.println("=========列表操作=============");
		List<String> values = new ArrayList<String>();
		values.add("a");
		values.add("b");
		values.add("c");
		listOperations.leftPush("list", values);
		System.out.println(listOperations.range("list", 0, -1));
		
		System.out.println("=========集合操作=============");
		setOperations.add("set", "value1", "value2", "value3");
		System.out.println(setOperations.members("set"));
		
		System.out.println("=========有序集合操作=============");
		zsetOperations.add("zset", "value1", 1);
		zsetOperations.add("zset", "value2", 0.5);
		zsetOperations.add("zset", "value3", 1.2);
		System.out.println(zsetOperations.range("zset", 0, -1));
		
		System.out.println("=========hash操作=============");
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value");
		map.put("key3", "value3");
		hashOperations.putAll("hash", map);
		System.out.println(hashOperations.entries("hash"));
		
	}
}

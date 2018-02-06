package root;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisTemplateTest {
	
	@Resource
	private RedisTemplate<String,String> redisTemplate;
	
	@PostConstruct
	private void test(){
		
		//操作字符串
		redisTemplate.opsForValue();
		
		//操作hash
		redisTemplate.opsForHash();
		
		//操作list
		redisTemplate.opsForList();
		
		//操作set
		redisTemplate.opsForSet();
		
		//操作有序集合
		redisTemplate.opsForZSet();
	}
	
}

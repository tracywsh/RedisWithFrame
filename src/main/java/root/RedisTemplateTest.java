package root;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisTemplateTest {
	
	@Resource(name="redisTemplate")
	private ListOperations<String, String> listUser;
	
	@PostConstruct
	private void test(){
		System.out.println("=======redisTempalte测试=======");
		listUser.leftPush("user", "wangsh");
		listUser.rightPush("user", "han");
		List<String> list = listUser.range("user", 0, -1);
		for (String str : list){
			System.out.println(str);
		}
	}
	
}

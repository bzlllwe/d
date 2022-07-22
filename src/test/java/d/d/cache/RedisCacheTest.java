package d.d.cache;

import d.d.model.StudentPo;
import d.d.repository.StudentRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisCacheTest {

	@Autowired
	RedisCache redisCache;

	@Autowired
	StudentRepo studentRepo;

	/**
	 * docker exec -it redis /bin/bash
	 * cd /usr/local/bin
	 * auth 123456
	 * ping
	 *
	 * select 0
	 * keys *
	 *
	 * 127.0.0.1:6379> get key
	 * "2"
	 * 127.0.0.1:6379> get "\xac\xed\x00\x05t\x00\x03key"
	 * "\xac\xed\x00\x05sr\x00\x11java.lang.Integer\x12\xe2\xa0\xa4\xf7\x81\x878\x02\x00\x01I\x00\
	 * x05valuexr\x00\x10java.lang.Number\x86\xac\x95\x1d\x0b\x94\xe0\x8b\x02\x00\x00xp\x00\x00\x00\x02"
	 * 127.0.0.1:6379>
	 *
	 * \xac\xed\x00\x05t\x00\x03key 反序列化相关
	 */
	@Test
	public void setCacheObject() {
		redisCache.setCacheObject("key",2);
		System.out.println((int)redisCache.getCacheObject("key"));

		System.out.println(redisCache.keys("*")); //[]
	}

	@Test
	public void testList() {
		StudentPo s1 = new StudentPo("s1","h1");
		StudentPo s2 = new StudentPo("s2","h2");
		List l = new ArrayList();
		l.add(s1);
		l.add(s2);
		redisCache.setCacheObject("list",l);
		System.out.println(redisCache.getCacheObject("list").toString());
		// [StudentPo(name=s1, hobby=h1), StudentPo(name=s2, hobby=h2)]
		//127.0.0.1:6379> get list
		//"[\"java.util.ArrayList\",[[\"d.d.model.StudentPo\",{\"id\":null,\"createDate\":null,\"updateDate\":null,\"name\":\"s1\",\"hobby\":\"h1\"}],[\"d.d.model.StudentPo\",{\"id\":null,\"createDate\":null,\"updateDate\":null,\"name\":\"s2\",\"hobby\":\"h2\"}]]]"

	}

	@Test
	public void testList2(){
		List l = studentRepo.findAll();
		redisCache.setCacheObject("list2",l);
		System.out.println(redisCache.getCacheObject("list2").toString());
	}
}
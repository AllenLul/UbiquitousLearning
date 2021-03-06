package just.learn;

import just.learn.entity.User;
import just.learn.mapper.UserMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LearnApplicationTests.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class LearnApplicationTests {
	@Autowired
	private UserMapper mapper;
	@Test
	public void contextLoads() {

	}
	@Test
	@Rollback
	public  void testInsert(){
		User user=new User();
		user.setPassword( DigestUtils.md5Hex("test"));
		user.setRole("manager");
		user.setNumber("testMd5");
		user.setNote("a");
		user.setDepartment("a");
		user.setPhone("a");
		user.setName("a");
		user.setHeadpic("a");
		user.setGender("a");
		mapper.insertSelective(user);
		System.out.println("###################");
	}


}

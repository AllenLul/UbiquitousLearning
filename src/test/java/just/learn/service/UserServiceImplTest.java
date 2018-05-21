package just.learn.service;

import just.learn.common.enums.RoleEnum;
import just.learn.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Ethanp
 * @version V1.0
 * @Package just.learn.service
 * @Description: TODO
 * @date 2018/5/21 17:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceImplTest {
    @Autowired
    @Qualifier("userServiceImpl")
    UserService userService;
    @Test
    public void insert() {
        User user=new User();
        user.setRole(RoleEnum.STUDENT.getValue());
        user.setGender("男");
        user.setHeadpic("test junit测试数据 插入");
        user.setNote("junit测试数据");
        user.setDepartment("计算机学院");
        user.setName("pxc");
        user.setNumber("15225656");
        user.setPhone("188526265256");
        user.setNickname("asdfas");
        userService.insert(user);
    }

    @Test
    public void delete() {
        userService.delete(1);
    }

    @Test
    public void update() {
        User user=new User();
        user.setRole(RoleEnum.STUDENT.getValue());
        user.setGender("男");
        user.setHeadpic("test junit测试数据 更新");
        user.setNote("junit测试数据");
        user.setDepartment("计算机学院");
        user.setName("pxc");
        user.setNumber("15225656");
        user.setPhone("188526265256");
        user.setNickname("asdfas");
        userService.update(user);
    }

    @Test
    public void getById() {
        System.out.println(userService.getById(1));
    }

    @Test
    public void getByNumber() {
        System.out.println(userService.getByNumber("15225656"));
    }

    @Test
    public void findStudentsInfo() {
        System.out.println(userService.findStudentsInfo(1,3));
    }

    @Test
    public void getUser() {
        User user=new User();
        user.setRole(RoleEnum.STUDENT.getValue());
        user.setGender("男");
        user.setHeadpic("test junit测试数据 更新");
        user.setNote("junit测试数据");
        user.setDepartment("计算机学院");
        user.setName("pxc");
        user.setNumber("15225656");
        user.setPhone("188526265256");
        user.setNickname("asdfas");
        System.out.println(userService.getUser(user));
    }
}
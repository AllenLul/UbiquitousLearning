package just.learn.service;

import just.learn.entity.Homework;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author Ethanp
 * @version V1.0
 * @Package just.learn.service
 * @Description: TODO
 * @date 2018/5/21 17:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomeworkServiceImplTest {
    @Autowired
    @Qualifier("homeworkServiceImpl")
    protected HomeworkService homeworkService;
    @Test
    public void insert() {
        Homework homework=new Homework();
        homework.setName("junit 测试数据 插入");
        homework.setCourseId(1);
        homework.setEndTime(new Date());
        homework.setDetail("test");
        homework.setType("docx");
        homework.setUserId(55);
        homeworkService.insert(homework);

    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
        Homework homework=new Homework();
        homework.setName("junit 测试数据 更新");
        homework.setCourseId(1);
        homework.setEndTime(new Date());
        homework.setDetail("test");
        homework.setType("docx");
        homework.setUserId(55);
        homeworkService.update(homework);
    }

    @Test
    public void getById() {
        System.out.println(homeworkService.getById(1));
    }

    @Test
    public void findStudentsInfo() {

    }

    @Test
    public void getHomework() {
        Homework homework=new Homework();
        homework.setName("junit 测试数据 更新");
        homework.setCourseId(1);
        homework.setEndTime(new Date());
        homework.setDetail("test");
        homework.setType("docx");
        homework.setUserId(55);
        homeworkService.getHomework(homework);
    }

    @Test
    public void batchDownload() {

    }
}
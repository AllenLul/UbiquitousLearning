package just.learn.service;


import just.learn.entity.Video;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



/**
 * @author Ethanp
 * @version V1.0
 * @Package just.learn.service
 * @Description: TODO
 * @date 2018/5/21 15:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VideoServiceImplTest {
    @Autowired
    @Qualifier("videoServiceImpl")
    protected VideoService videoService;
    @Test
    public void insert() {
        Video video=new Video();
        video.setTimes(3600);
        video.setCourseId(1);
        video.setName("junit测试数据 插入");
        video.setUrl("test");
        video.setIsPass("1");
        video.setLength(Double.parseDouble("3600"));
        videoService.insert(video);
    }

    @Test
    public void delete() {
        videoService.delete(2);
    }

    @Test
    public void update() {
        Video video=new Video();
        video.setTimes(3600);
        video.setCourseId(1);
        video.setName("junit测试数据 更新");
        video.setUrl("test");
        video.setIsPass("1");
        video.setLength(Double.parseDouble("3600"));
        videoService.update(video);
    }

    @Test
    public void getById() {
        System.out.println(videoService.getById(1));
    }

    @Test
    public void findStudentsInfo() {

    }

    @Test
    public void getVideo() {
        Video video=new Video();
        video.setTimes(3600);
        video.setCourseId(1);
        video.setName("junit测试数据 更新");
        video.setUrl("test");
        video.setIsPass("1");
        video.setLength(Double.parseDouble("3600"));
        System.out.println( videoService.getVideo(video));
    }
}
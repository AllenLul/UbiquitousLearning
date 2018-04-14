package just.learn.service;

import just.learn.entity.Courseware;
import just.learn.entity.Video;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Ethanp
 * @version V1.0
 * @Package just.learn.service
 * @Description: TODO
 * @date 2018/4/14 13:23
 */
public interface FileService {

    String uploaCourseware(MultipartFile file, Courseware courseware) throws IOException;
    String uploaVideo(MultipartFile file, Video video) throws IOException;
}

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

    String uploadCourseware(MultipartFile file) throws Exception;
    String uploadVideo(MultipartFile file) throws Exception;
}

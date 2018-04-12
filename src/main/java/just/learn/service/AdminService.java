package just.learn.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Ethanp
 * @version V1.0
 * @Package just.learn.service
 * @Description: TODO
 * @date 2018/4/12 20:22
 */
public interface AdminService {
    public String importInfo(MultipartFile file) throws Exception;
}

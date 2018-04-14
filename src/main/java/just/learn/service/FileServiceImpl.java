package just.learn.service;

import just.learn.common.enums.ResultEnum;
import just.learn.common.execption.CustomException;
import just.learn.common.utils.GetTypeByHead;
import just.learn.entity.Courseware;
import just.learn.entity.Video;
import just.learn.mapper.CoursewareMapper;
import just.learn.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Ethanp
 * @version V1.0
 * @Package just.learn.service
 * @Description: TODO
 * @date 2018/4/14 13:23
 */
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private CoursewareMapper coursewareMapper;
    @Autowired
    private VideoMapper videoMapper;
    @Override
    public String uploaCourseware(MultipartFile file, Courseware courseware) throws IOException {
        if(courseware==null){
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        if(file==null||file.isEmpty()){
            throw new CustomException(ResultEnum.FILE_EMPTY);
        }
        if("docx".equals(GetTypeByHead.getFileType(file))||"mp4".equals(GetTypeByHead.getFileType(file))||"avi".equals(GetTypeByHead.getFileType(file))){
            file.transferTo(new File("/var/www/img/learn/courseware/"+file.getOriginalFilename()));
            coursewareMapper.insertSelective(courseware);
            return "url";
        }else {
            throw new CustomException(ResultEnum.FILE_FORMAT_ERROR);
        }

    }
    @Override
    public String uploaVideo(MultipartFile file, Video video) throws IOException {

        if(file==null||file.isEmpty()){
            throw new CustomException(ResultEnum.FILE_EMPTY);
        }
        if(!"docx".equals(GetTypeByHead.getFileType(file))){
            throw new CustomException(ResultEnum.FILE_FORMAT_ERROR);
        }
        if("docx".equals(GetTypeByHead.getFileType(file))||"mp4".equals(GetTypeByHead.getFileType(file))||"avi".equals(GetTypeByHead.getFileType(file))){
            file.transferTo(new File("/var/www/img/learn/courseware/"+file.getOriginalFilename()));
            videoMapper.insertSelective(video);
            return "url";
        }else {
            throw new CustomException(ResultEnum.FILE_FORMAT_ERROR);
        }
    }
}

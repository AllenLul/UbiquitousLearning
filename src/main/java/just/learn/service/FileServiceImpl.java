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
    public String uploadCourseware(MultipartFile file) throws Exception {

        if(file==null||file.isEmpty()){
            throw new CustomException(ResultEnum.FILE_EMPTY);
        }
        if("docx".equals(GetTypeByHead.getFileType(file))||"mp4".equals(GetTypeByHead.getFileType(file))||"avi".equals(GetTypeByHead.getFileType(file))){
            String path="E:\\courseware";
            File targetDir=new File(path);
            if(!targetDir.exists()){
                targetDir.mkdirs();
            }
            File target=new File(path+"\\"+file.getOriginalFilename());
            if(!target.exists()){
                target.createNewFile();
            }
            file.transferTo(target);
            return path+"\\"+file.getOriginalFilename();
        }else {
            throw new CustomException(ResultEnum.FILE_FORMAT_ERROR);
        }

    }
    @Override
    public String uploadVideo(MultipartFile file) throws Exception {

        if(file==null||file.isEmpty()){
            throw new CustomException(ResultEnum.FILE_EMPTY);
        }
        if("mp4".equals(GetTypeByHead.getFileType(file))||"avi".equals(GetTypeByHead.getFileType(file))){
            String path="E:\\video";
            File targetDir=new File(path);
            if(!targetDir.exists()){
                targetDir.mkdirs();
            }
            File target=new File(path+"\\"+file.getOriginalFilename());
            if(!target.exists()){
                target.createNewFile();
            }
            file.transferTo(target);
            return path+"\\"+file.getOriginalFilename();
        }else {
            throw new CustomException(ResultEnum.FILE_FORMAT_ERROR);
        }
    }
}

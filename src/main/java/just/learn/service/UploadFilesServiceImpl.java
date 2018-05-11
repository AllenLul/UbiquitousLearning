package just.learn.service;

import just.learn.common.enums.ResultEnum;
import just.learn.common.execption.CustomException;
import just.learn.common.utils.QiniuFileUploadUtil;
import just.learn.entity.UploadFiles;
import just.learn.mapper.UploadFilesMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Service
public class UploadFilesServiceImpl implements UploadFilesService {

    @Resource
    UploadFilesMapper mapper;

    @Override
    public UploadFiles insert(UploadFiles uploadFiles) {
        if (uploadFiles == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        mapper.insertSelective(uploadFiles);
        return uploadFiles;
    }

    @Override
    public boolean delete(Integer id) {
        if (getById(id) == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public int update(UploadFiles uploadFiles) {
        if (uploadFiles == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        if (getById(uploadFiles.getId()) == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return mapper.updateByPrimaryKeySelective(uploadFiles);
    }

    @Override
    public UploadFiles getById(Integer id) {
        if (id == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        UploadFiles uploadFiles = mapper.selectByPrimaryKey(id);
        if (uploadFiles == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return uploadFiles;
    }

    @Override
    public String upload(MultipartFile file, Integer id) throws IOException {
        if (file == null||id==null ) {
            throw new CustomException(ResultEnum.FILE_ERROR);
        }
        UploadFiles files=mapper.selectByPrimaryKey(id);
        if(files==null){
            throw new CustomException(ResultEnum.OBJECT_FIND_ERROR);
        }
        String img_url= "http://p4a0xyee4.bkt.clouddn.com/"+QiniuFileUploadUtil.uploadBookImg(file);
        String urls="";
        if(files.getUrls()==null||files.getUrls().equals("")){
            urls=img_url+",";
        }else {
            if(isExistence(img_url,files.getUrls())){//判断图片是否存在
                throw new CustomException(ResultEnum.IMG_HAS_EXISTED);
            }
            urls=files.getUrls()+img_url+",";
        }
        files.setUrls(urls);
        mapper.updateByPrimaryKeySelective(files);
        return files.getUrls();
    }

    @Override
    public List<UploadFiles> getAll() {

        return mapper.getAll();
    }

    private boolean isExistence(String img_url, String urls) {
        String urlList[]=urls.split(",");
        for (String s : urlList) {
            if(img_url.equals(s)){
                return true;
            }
        }
        return false;
    }


}
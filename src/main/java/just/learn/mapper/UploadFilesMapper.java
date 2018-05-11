package just.learn.mapper;

import just.learn.entity.UploadFiles;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UploadFilesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UploadFiles record);

    int insertSelective(UploadFiles record);

    UploadFiles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UploadFiles record);

    int updateByPrimaryKey(UploadFiles record);

    List<UploadFiles> getAll();
}
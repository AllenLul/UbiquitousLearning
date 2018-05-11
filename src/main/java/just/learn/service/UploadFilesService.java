package just.learn.service;

import just.learn.entity.UploadFiles;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface UploadFilesService {


    public UploadFiles insert(UploadFiles uploadFiles);

    public boolean delete(Integer id);

    public int update(UploadFiles uploadFiles);

    public UploadFiles getById(Integer id);

    String upload(MultipartFile file, Integer id) throws IOException;

    List<UploadFiles> getAll();
}
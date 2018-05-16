package just.learn.service;

import just.learn.entity.Homework;
import just.learn.entity.PageQueryBean;
import just.learn.vo.QueryCondition;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface HomeworkService {


    public Homework insert(Homework homework);

    public boolean delete(Integer id);

    public int update(Homework homework);

    public Homework getById(Integer id);

    List<Homework> findStudentsInfo(Integer pageNum, Integer pageSize);

    List<Homework>  getHomework(Homework homework);

    String batchDownload(Integer id, HttpServletResponse response) throws Exception;
}
package just.learn.service;

import com.github.pagehelper.PageHelper;
import just.learn.common.enums.ResultEnum;
import just.learn.common.execption.CustomException;
import just.learn.entity.Course;
import just.learn.entity.User;
import just.learn.mapper.UserMapper;
import org.springframework.stereotype.Service;
import just.learn.vo.QueryCondition;
import just.learn.entity.PageQueryBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper mapper;

    @Override
    public User insert(User user) {
        if (user == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        mapper.insertSelective(user);
        return user;
    }

    @Override
    public boolean delete(Integer id) {
        if (getById(id) == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public User update(User user) {
        if (user == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        if (getById(user.getId()) == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
       mapper.updateByPrimaryKeySelective(user);
        return mapper.selectByPrimaryKey(user.getId());
    }

    @Override
    public User getById(Integer id) {
        if (id == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        User user = mapper.selectByPrimaryKey(id);
        if (user == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return user;
    }



    @Override
    public User getByNumber(String number) {
        if (number == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        User user = mapper.selectByNumber(number);
        if (user == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return user;
    }

    @Override
    public List<User> findStudentsInfo(QueryCondition<User> queryCondition) {
        PageHelper.startPage(queryCondition.getPageNum(),queryCondition.getPageSize());
        return mapper.getUser(queryCondition.getObject());
    }

    @Override
    public List<User> getUser(User user) {
        if (user == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        return mapper.getUser(user);
    }

    @Override
    public String uploadUserPic(MultipartFile file) throws IOException {
        String path="e:\\img\\user";
        File targetDir=new File(path);
        if(!targetDir.exists()){
            targetDir.mkdirs();
        }
        File target=new File(path+"\\"+file.getOriginalFilename());
        if(!target.exists()){
            target.createNewFile();
        }
        file.transferTo(new File(path));
        return path+"\\"+file.getOriginalFilename();
    }
/*    @Override
public List<User> getAll() {
    return mapper.selectAll();
    }*/
}
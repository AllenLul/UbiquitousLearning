package just.learn.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserCourse {
    private Integer id;

    private Integer userId;

    private Integer courseId;

    private Date gmtCreate;


}
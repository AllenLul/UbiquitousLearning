package just.learn.entity;

import lombok.Data;

import java.util.Date;
@Data
public class SubmitHomework {
    private Integer id;

    private Integer userId;//提交作业的学生id

    private Integer homeworkId;//提交作业的作业id

    private String url;//提交作业的文件路径

    private String score;//分数

    private Date gmtCreate;

    private Date gmtUpdate;


}
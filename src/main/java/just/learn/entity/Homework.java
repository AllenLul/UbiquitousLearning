package just.learn.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Homework {
    private Integer id;

    private Integer courseId;

    private String name;

    private String type;

    private Date endTime;

    private String detail;

    private Integer userId;

    private User user;

}
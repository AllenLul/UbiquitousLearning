package just.learn.entity;

import lombok.Data;

@Data
public class Video {
    private Integer id;

    private Integer courseId;

    private String name;

    private String url;

    private String isPass;

    private Double length;

    private Integer times;

}
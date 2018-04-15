package just.learn.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Post {
    private Integer id;

    private String name;

    private String detail;

    private Date createTime;

    private String canReply;

    private String isTop;

    private Integer replyId;

    private Integer userId;

    private User user;

    private Post replyPost;
}
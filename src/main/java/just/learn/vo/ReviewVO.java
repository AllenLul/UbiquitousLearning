package just.learn.vo;

import just.learn.entity.Review;
import lombok.Data;

/**
 * @author Ethanp
 * @version V1.0
 * @Package just.learn.vo
 * @Description: TODO
 * @date 2018/4/13 19:31
 */
@Data
public class ReviewVO {
    private String type;
    private Review[] reviews;
}

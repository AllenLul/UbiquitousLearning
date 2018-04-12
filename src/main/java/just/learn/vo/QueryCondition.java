package just.learn.vo;

import just.learn.entity.PageQueryBean;
import lombok.Data;

/**
 * @author Ethanp
 * @version V1.0
 * @Package just.learn.vo
 * @Description: TODO 查询条件
 * @date 2018/4/12 18:24
 */
@Data
public class QueryCondition  extends PageQueryBean{//除了分页的基本条件，扩展几个条件
    private String startDate;
    private String endDate;
}

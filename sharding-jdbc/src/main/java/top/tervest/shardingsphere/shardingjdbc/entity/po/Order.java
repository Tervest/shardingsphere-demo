package top.tervest.shardingsphere.shardingjdbc.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ZhangNanNan
 * @create 2019-07-08 15:53
 */
@Data
@AllArgsConstructor
public class Order {
    private Integer orderId;
    private Integer userId;
}

package top.tervest.shardingsphere.shardingjdbc.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.tervest.shardingsphere.shardingjdbc.entity.po.OrderCountDo;
import top.tervest.shardingsphere.shardingjdbc.entity.po.OrderPo;

import java.util.List;

/**
 * @author ZhangNanNan
 * @create 2019-07-08 17:09
 */
@Mapper
public interface OrderDao {

    /**
     * 保存Order
     * @param order
     * @return
     */
    Integer saveOrder(@Param("order") OrderPo order);

    /**
     * 获取Orders
     * @return
     */
    List<OrderPo> listOrders();

    /**
     * 更新Order
     * @param order
     * @return
     */
    int updateOrder(@Param("order") OrderPo order);

    /**
     * 删除Order
     * @param order
     * @return
     */
    int deleteOrder(@Param("order") OrderPo order);

    /**
     * 获取Oders并排序
     * @return
     */
    List<OrderPo> listOrdersSort();

    /**
     * Order分组统计
     * @return
     */
    List<OrderCountDo> listOrderGroup();
}

package top.tervest.shardingsphere.shardingjdbc.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.tervest.shardingsphere.shardingjdbc.entity.po.Order;

import java.util.List;

/**
 * @author ZhangNanNan
 * @create 2019-07-08 17:09
 */
@Mapper
public interface OrderDao {

    Integer saveOrder(@Param("order") Order order);

    List<Order> listOrders();

    int updateOrder(@Param("order") Order order);

    int deleteOrder(@Param("order") Order order);

    List<Order> listOrdersSort();
}

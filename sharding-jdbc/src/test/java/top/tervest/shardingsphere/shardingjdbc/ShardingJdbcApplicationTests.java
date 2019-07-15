package top.tervest.shardingsphere.shardingjdbc;

import com.alibaba.fastjson.JSON;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.tervest.shardingsphere.shardingjdbc.dao.OrderDao;
import top.tervest.shardingsphere.shardingjdbc.entity.po.Order;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingJdbcApplicationTests {

    @Autowired
    OrderDao orderDao;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testListOrders(){
        List<Order> orders = orderDao.listOrders();
        print(orders);
    }


    @Test
    public void testSaveOrder(){
        for (int i = 0,j = 1;i < 20 ; i++,j++) {
            Order order = new Order(i,j);
            orderDao.saveOrder(order);
        }
    }

    @Test
    public void testUpdateOrder(){
        Order order = new Order(1,2);
        int i = orderDao.updateOrder(order);
        Assert.assertEquals(1,i);
    }

    @Test
    public void testDeleteOrder(){
        Order order = new Order(1,2);
        int i = orderDao.deleteOrder(order);
        Assert.assertEquals(1,i);
    }

    @Test
    public void testListOrdersSort(){
        List<Order> orders = orderDao.listOrdersSort();
        print(orders);
    }


    public static void print(Object object){
        System.out.println(JSON.toJSONString(object));
    }

}

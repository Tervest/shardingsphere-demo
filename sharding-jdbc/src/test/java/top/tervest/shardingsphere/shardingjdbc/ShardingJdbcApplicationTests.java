package top.tervest.shardingsphere.shardingjdbc;

import com.alibaba.fastjson.JSON;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.tervest.shardingsphere.shardingjdbc.dao.HTP1Dao;
import top.tervest.shardingsphere.shardingjdbc.dao.OrderDao;
import top.tervest.shardingsphere.shardingjdbc.entity.po.Htp1Do;
import top.tervest.shardingsphere.shardingjdbc.entity.po.OrderCountDo;
import top.tervest.shardingsphere.shardingjdbc.entity.po.OrderPo;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingJdbcApplicationTests {

    @Autowired
    OrderDao orderDao;
    @Autowired
    HTP1Dao htp1Dao;

    @Test
    public void contextLoads() {
        List<Htp1Do> htp1Dos = htp1Dao.listHtp1();
        print(htp1Dos);
    }


    @Test
    public void testListOrders(){
        List<OrderPo> orders = orderDao.listOrders();
        print(orders);
    }


    @Test
    public void testSaveOrder(){
        for (int i = 0,j = 2;i < 20 ; i++,j++) {
            OrderPo order = new OrderPo(i,j);
            orderDao.saveOrder(order);
        }
    }

    @Test
    public void testUpdateOrder(){
        OrderPo order = new OrderPo(1,2);
        int i = orderDao.updateOrder(order);
        Assert.assertEquals(1,i);
    }

    @Test
    public void testDeleteOrder(){
        OrderPo order = new OrderPo(1,2);
        int i = orderDao.deleteOrder(order);
        Assert.assertEquals(1,i);
    }

    @Test
    public void testListOrdersSort(){
        List<OrderPo> orders = orderDao.listOrdersSort();
        print(orders);
    }

    @Test
    public void testListOrderGrou(){
        List<OrderCountDo> orderCountDos = orderDao.listOrderGroup();
        print(orderCountDos);
    }


    public static void print(Object object){
        System.out.println(JSON.toJSONString(object));
    }

}

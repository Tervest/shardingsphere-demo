package top.tervest.shardingsphere.shardingjdbc.dao;

import org.apache.ibatis.annotations.Mapper;
import top.tervest.shardingsphere.shardingjdbc.entity.po.Htp1Do;

import java.util.List;

/**
 * @author ZhangNanNan
 * @create 2019-08-13 11:10
 */
@Mapper
public interface HTP1Dao {
    List<Htp1Do> listHtp1();
}

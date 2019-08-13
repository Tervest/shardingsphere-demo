package top.tervest.shardingsphere.shardingjdbc.config;

import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 * @author ZhangNanNan
 * @create 2019-08-13 11:44
 */
public class TableHintShardingAlgorithm implements HintShardingAlgorithm<String> {
    @Override
    public Collection<String> doSharding(Collection<String> collection, HintShardingValue<String> hintShardingValue) {
        return null;
    }
}

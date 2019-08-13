package top.tervest.shardingsphere.shardingjdbc.config;

import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author ZhangNanNan
 * @create 2019-08-13 11:59
 */
public class TableRangeShardingAlgorithm implements RangeShardingAlgorithm<String> {
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<String> shardingValue) {
        Collection<String> list = new ArrayList<>();
        String db_name="DA_MEDICAL_HPT1";
        Range<String> valueRange = shardingValue.getValueRange();
        if (valueRange.hasLowerBound()) {
            String s = valueRange.lowerEndpoint();
            try {
                Date date = (Date) new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse( s );
                String year = String.format("%tY", date);
                String mon  = String.format("%tm",date);
                db_name=db_name+"_"+year+mon;
                list.add(db_name);
                System.out.println("db_name:" + db_name);

            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }
}
